package com.chenqian.service.impl;

import com.chenqian.common.Const;
import com.chenqian.common.ServerResponse;
import com.chenqian.dao.CartMapper;
import com.chenqian.dao.ProductMapper;
import com.chenqian.enums.ResponseCodeEnum;
import com.chenqian.pojo.Cart;
import com.chenqian.pojo.Product;
import com.chenqian.service.ICartService;
import com.chenqian.util.BigDecimalUtil;
import com.chenqian.util.PropertiesUtil;
import com.chenqian.vo.CartProductVo;
import com.chenqian.vo.CartVo;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 21:11
 * <p>
 * 购物车
 */
@Service("iCartService")
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加到购物车
     *
     * @param userId    用户Id
     * @param productId 商品Id
     * @param count     数量
     * @return
     */
    @Override
    public ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count) {
        if (productId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(), ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdProductId(userId, productId);
        if (cart == null) {
            //这个产品不在这个购物车里,需要新增一个这个产品的记录
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setProductId(productId);
            cartItem.setUserId(userId);
            cartMapper.insert(cartItem);
        } else {
            //这个产品已经在购物车里了. 如果产品已存在,数量相加
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);
    }

    /**
     * 购物车计算
     *
     * @param userId
     * @return
     */
    private CartVo getCartVoLimit(Integer userId) {
        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();

        // 初始化购物车总价 -> BigDecimal的String构造器
        BigDecimal cartTotalPrice = new BigDecimal("0");

        if (CollectionUtils.isNotEmpty(cartList)) {
            for (Cart cartItem : cartList) {
                CartProductVo cartProductVo = new CartProductVo();
                // TODO 优化(对象拷贝)
                cartProductVo.setId(cartItem.getId());
                cartProductVo.setUserId(userId);
                cartProductVo.setProductId(cartItem.getProductId());

                // 查询购物车的产品
                Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
                if (product != null) {
                    // TODO 优化(对象拷贝)
                    cartProductVo.setProductMainImage(product.getMainImage());
                    cartProductVo.setProductName(product.getName());
                    cartProductVo.setProductSubtitle(product.getSubtitle());
                    cartProductVo.setProductStatus(product.getStatus());
                    cartProductVo.setProductPrice(product.getPrice());
                    cartProductVo.setProductStock(product.getStock());
                    // 判断库存
                    int buyLimitCount = 0;
                    if (product.getStock() >= cartItem.getQuantity()) {
                        // 库存充足的时候
                        buyLimitCount = cartItem.getQuantity();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    } else {
                        buyLimitCount = product.getStock();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    // 数量
                    cartProductVo.setQuantity(buyLimitCount);
                    // 计算总价
                    cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(), cartProductVo.getQuantity()));
                    cartProductVo.setProductChecked(cartItem.getChecked());
                }

                if (cartItem.getChecked() == Const.Cart.CHECKED) {
                    //如果已经勾选,增加到整个的购物车总价中
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(), cartProductVo.getProductTotalPrice().doubleValue());
                }
                cartProductVoList.add(cartProductVo);
            }
        }
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

        return cartVo;
    }

    /**
     * 判断是否全选
     *
     * @param userId 用户Id
     * @return
     */
    private boolean getAllCheckedStatus(Integer userId) {
        if (userId == null) {
            return false;
        }
        // 如果有未勾选的, 则不为0 返回false
        return cartMapper.selectCartProductCheckedStatusByUserId(userId) == 0;
    }


    /**
     * 更新购物车
     *
     * @param userId    用户Id
     * @param productId 商品Id
     * @param count
     * @return
     */
    @Override
    public ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count) {
        if (productId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(), ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdProductId(userId, productId);
        if (cart != null) {
            cart.setQuantity(count);
        }
        cartMapper.updateByPrimaryKey(cart);
        return this.list(userId);
    }

    /**
     * 删除购物车的商品
     *
     * @param userId     用户Id
     * @param productIds 商品Id集合
     * @return
     */
    @Override
    public ServerResponse<CartVo> deleteProduct(Integer userId, String productIds) {
        // 用 , 分割 转成集合
        List<String> productList = Splitter.on(",").splitToList(productIds);
        if (CollectionUtils.isEmpty(productList)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(), ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        cartMapper.deleteByUserIdProductIds(userId, productList);
        return this.list(userId);
    }

    /**
     *
     *
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<CartVo> list(Integer userId) {
        CartVo cartVo = this.getCartVoLimit(userId);
        return ServerResponse.createBySuccessMessage(cartVo);
    }


    /**
     * @param userId    用户Id
     * @param productId
     * @param checked
     * @return
     */
    @Override
    public ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked) {
        cartMapper.checkedOrUncheckedProduct(userId, productId, checked);
        return this.list(userId);
    }

    /**
     * 获取购物车中的产品数量
     *
     * @param userId 用户Id
     * @return
     */
    @Override
    public ServerResponse<Integer> getCartProductCount(Integer userId) {
        if (userId == null) {
            return ServerResponse.createBySuccessMessage(0);
        }
        return ServerResponse.createBySuccessMessage(cartMapper.selectCartProductCount(userId));
    }


}

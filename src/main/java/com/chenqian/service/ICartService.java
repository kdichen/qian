package com.chenqian.service;

import com.chenqian.common.ServerResponse;
import com.chenqian.vo.CartVo;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 21:10
 * <p>
 * 购物车
 */

public interface ICartService {

    /**
     * 添加到购物车
     *
     * @param userId    用户Id
     * @param productId 商品Id
     * @param count     数量
     * @return
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
     * 更新购物车
     *
     * @param userId    用户Id
     * @param productId 商品Id
     * @param count
     * @return
     */
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    /**
     * 查询购物车集合
     *
     * @param userId
     * @return
     */
    ServerResponse<CartVo> list(Integer userId);

    /**
     * 全选/反选/单独选/单独反选
     *
     * @param userId    用户Id
     * @param productId 商品Id
     * @param checked
     * @return
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    /**
     * 获取购物车中的产品数量
     *
     * @param userId 用户Id
     * @return
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);
}

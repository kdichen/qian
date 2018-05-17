package com.chenqian.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 21:21
 * <p>
 * 结合了产品和购物车的一个抽象对象
 */

@Getter
@Setter
public class CartProductVo {

    private Integer id;

    /**
     * 用户名
     */
    private Integer userId;

    /**
     * 商品Id
     */
    private Integer productId;

    /**
     * 购物车中此商品的数量
     */
    private Integer quantity;

    /**
     * 商品名称
     */
    private String productName;

    /**
     *
     */
    private String productSubtitle;

    /**
     * 产品主图
     */
    private String productMainImage;

    /**
     * 产品价格
     */
    private BigDecimal productPrice;

    /**
     * 产品状态
     */
    private Integer productStatus;

    /**
     * 产品总价
     */
    private BigDecimal productTotalPrice;

    /**
     * 产品库存
     */
    private Integer productStock;

    /**
     * 此商品是否勾选
     */
    private Integer productChecked;

    /**
     * 限制数量的一个返回结果
     */
    private String limitQuantity;
}

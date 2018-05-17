package com.chenqian.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 21:18
 */

@Getter
@Setter
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    /**
     * 购物车总价
     */
    private BigDecimal cartTotalPrice;

    /**
     * 是否已经都勾选
     */
    private Boolean allChecked;

    /**
     * 购物车显示的图片
     */
    private String imageHost;



}

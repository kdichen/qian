package com.chenqian.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 订单明细
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    /**
     * 订单子表ID.
     */
    private Integer id;

    /**
     * 用户.
     */
    private Integer userId;

    /**
     * 订单编号.
     * */
    private Long orderNo;

    /**
     * 商品ID.
     */
    private Integer productId;

    /**
     * 商品名称.
     */
    private String productName;

    /**
     * 商品图片地址.
     */
    private String productImage;

    /**
     * 生成订单时的商品单价，单位是元,保留两位小数.
     */
    private BigDecimal currentUnitPrice;

    /**
     * 商品数量.
     */
    private Integer quantity;

    /**
     * 商品总价,单位是元,保留两位小数.
     */
    private BigDecimal totalPrice;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

}
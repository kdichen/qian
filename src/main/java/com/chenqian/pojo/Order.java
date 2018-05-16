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
 * 订单
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * 订单ID.
     */
    private Integer id;

    /**
     * 订单号.
     */
    private Long orderNo;

    /**
     * 用户ID.
     */
    private Integer userId;

    /**
     * 类别ID.
     */
    private Integer shippingId;

    /**
     * 实际付款金额,单位是元,保留两位小数.
     */
    private BigDecimal payment;

    /**
     * 支付类型,1-在线支付.
     */
    private Integer paymentType;

    /**
     * 运费,单位是元.
     */
    private Integer postage;

    /**
     * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭.
     */
    private Integer status;

    /**
     * 支付时间.
     */
    private Date paymentTime;

    /**
     * 发货时间.
     */
    private Date sendTime;

    /**
     * 交易完成时间.
     */
    private Date endTime;

    /**
     * 交易关闭时间.
     */
    private Date closeTime;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;
}
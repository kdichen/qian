package com.chenqian.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 支付
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayInfo {

    /**
     * 支付ID.
     */
    private Integer id;

    /**
     * 用户ID.
     */
    private Integer userId;

    /**
     * 订单号.
     */
    private Long orderNo;

    /**
     * 支付平台:1-支付宝,2-微信.
     */
    private Integer payPlatform;

    /**
     * 支付宝支付流水号.
     */
    private String platformNumber;

    /**
     * 支付宝支付状态.
     */
    private String platformStatus;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

}
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
 * 收货
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

    private Integer id;

    /**
     * 用户ID.
     */
    private Integer userId;

    /**
     * 收货姓名.
     */
    private String receiverName;

    /**
     * 收货固定电话.
     */
    private String receiverPhone;

    /**
     * 收货移动电话.
     */
    private String receiverMobile;

    /**
     * 省份.
     */
    private String receiverProvince;

    /**
     * 城市.
     */
    private String receiverCity;

    /**
     * 区/县.
     */
    private String receiverDistrict;

    /**
     * 详细地址.
     */
    private String receiverAddress;

    /**
     * 邮编.
     */
    private String receiverZip;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 修改时间.
     */
    private Date updateTime;

}
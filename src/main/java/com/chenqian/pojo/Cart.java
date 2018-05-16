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
 * 购物车
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    /**
     * 购物车ID.
     */
    private Integer id;

    /**
     * 用户ID.
     */
    private Integer userId;

    /**
     * 商品ID.
     */
    private Integer productId;

    /**
     * 数量.
     */
    private Integer quantity;

    /**
     * 是否选择,1=已勾选,0=未勾选.
     */
    private Integer checked;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

}
package com.chenqian.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 16:03
 */

@Getter
@Setter
public class ProductListVo {

    /**
     * 商品id.
     */
    private Integer id;

    /**
     * 分类id,对应mmall_category表的主键.
     */
    private Integer categoryId;

    /**
     * 商品名称.
     */
    private String name;

    /**
     * 商品副标题.
     */
    private String subtitle;

    /**
     * 产品主图,url相对地址.
     */
    private String mainImage;


    /**
     * 价格,单位-元保留两位小数.
     */
    private BigDecimal price;


    /**
     * 商品状态.1-在售 2-下架 3-删除.
     */
    private Integer status;

    private String imageHost;

}

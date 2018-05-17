package com.chenqian.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 15:27
 */
@Getter
@Setter
public class ProductDetailVo {
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
     * 图片地址,json格式,扩展用.
     */
    private String subImages;

    /**
     * 商品详情.
     */
    private String detail;

    /**
     * 价格,单位-元保留两位小数.
     */
    private BigDecimal price;

    /**
     * 库存数量.
     */
    private Integer stock;

    /**
     * 商品状态.1-在售 2-下架 3-删除.
     */
    private Integer status;

    /**
     * 创建时间.
     */
    private String createTime;

    /**
     * 修改时间.
     */
    private String updateTime;

    /** 服务器图片前缀 */
    private String imageHost;

    /**
     * 父分类
     */
    private Integer parentCategoryId;

}

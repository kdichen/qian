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
 * 类别
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    /**
     * 类别ID.
     */
    private Integer id;

    /**
     * 父类别id当id=0时说明是根节点,一级类别.
     */
    private Integer parentId;

    /**
     * 类别名称.
     */
    private String name;

    /**
     * 类别状态1-正常,2-已废弃.
     */
    private Boolean status;

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序.
     */
    private Integer sortOrder;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

}
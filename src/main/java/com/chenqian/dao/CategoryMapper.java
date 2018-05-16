package com.chenqian.dao;

import com.chenqian.pojo.Category;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 类别
 */
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
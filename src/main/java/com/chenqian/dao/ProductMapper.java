package com.chenqian.dao;

import com.chenqian.pojo.Product;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 商品
 */
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}
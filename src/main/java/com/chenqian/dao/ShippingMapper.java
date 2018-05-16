package com.chenqian.dao;

import com.chenqian.pojo.Shipping;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 物流
 */
public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);
}
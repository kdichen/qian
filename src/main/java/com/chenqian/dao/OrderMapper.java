package com.chenqian.dao;

import com.chenqian.pojo.Order;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 订单
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
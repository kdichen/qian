package com.chenqian.dao;

import com.chenqian.pojo.OrderItem;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 订单明细
 */
public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
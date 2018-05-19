package com.chenqian.dao;

import com.chenqian.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 订单
 */
public interface OrderMapper {

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增订单
     *
     * @param record
     * @return
     */
    int insert(Order record);

    /**
     * 选择性新增
     *
     * @param record
     * @return
     */
    int insertSelective(Order record);

    /**
     * 查询订单
     *
     * @param id
     * @return
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 选择性更新订单
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 选择性更新订单
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Order record);

    /**
     * 根据订单号和用户ID查订单是否存在
     *
     * @param userId  用户Id
     * @param orderNo 订单编号
     * @return
     */
    Order selectByUserIdAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    /**
     * 查询订单号
     *
     * @param orderNo
     * @return
     */
    Order selectByOrderNo(Long orderNo);

    /**
     * 查看用户订单
     *
     * @param userId
     * @return
     */
    List<Order> selectByUserId(Integer userId);

    // -------------  后台 ---------------

    /**
     * 订单详情(带分页)
     * @return
     */
    List<Order> selectAllOrder();

}
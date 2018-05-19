package com.chenqian.dao;

import com.chenqian.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 订单明细
 */
public interface OrderItemMapper {

    /**
     * 删除订单明细
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增订单明细
     *
     * @param record
     * @return
     */
    int insert(OrderItem record);

    /**
     * 选择性更新
     *
     * @param record
     * @return
     */
    int insertSelective(OrderItem record);

    /**
     * 查询订单明细
     *
     * @param id
     * @return
     */
    OrderItem selectByPrimaryKey(Integer id);

    /**
     * 选择性更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderItem record);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrderItem record);

    /**
     * 根据订单编号和UserId查询出订单明细
     *
     * @param orderNo 订单编号
     * @param userId  用户Id
     * @return
     */
    List<OrderItem> getByOrderNoUserId(@Param("orderNo") Long orderNo, @Param("userId") Integer userId);

    /**
     * 批量插入
     *
     * @param orderItemList
     */
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);

    /**
     * 根据订单编号查询订单详情
     *
     * @param orderNo 订单编号
     * @return
     */
    List<OrderItem> getByOrderNo(@Param("orderNo") Long orderNo);

}
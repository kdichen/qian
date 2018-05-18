package com.chenqian.dao;

import com.chenqian.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 物流
 */
public interface ShippingMapper {

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加
     *
     * @param record
     * @return
     */
    int insert(Shipping record);

    /**
     * 选择性增加
     *
     * @param record
     * @return
     */
    int insertSelective(Shipping record);

    /**
     * 差询
     *
     * @param id
     * @return
     */
    Shipping selectByPrimaryKey(Integer id);

    /**
     * 选择性查询
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Shipping record);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Shipping record);

    /**
     * 根据当前登录用户用户Id删除收货地址
     *
     * @param userId     用户Id
     * @param shippingId 订单Id
     * @return
     */
    int deleteByShippingIdUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    /**
     * 修改收获地址
     *
     * @param record 收货地址对象
     * @return
     */
    int updateByShipping(Shipping record);

    /**
     * 查询当前用户Id的收获地址
     *
     * @param userId     用户Id
     * @param shippingId 收获地址Id
     * @return
     */
    Shipping selectByShippingIdUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    /**
     * 查询当前登录用户的所有收货地址
     *
     * @param userId 用户Id
     * @return
     */
    List<Shipping> selectByUserId(@Param("userId") Integer userId);
}
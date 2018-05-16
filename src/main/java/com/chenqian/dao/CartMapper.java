package com.chenqian.dao;

import com.chenqian.pojo.Cart;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 购物车
 */
public interface CartMapper {
    /**
     * 删除
     *
     * @param id 购物车ID
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record 购物车
     * @return
     */
    int insert(Cart record);

    int insertSelective(Cart record);

    /**
     * 查询单个
     *
     * @param id 购物车ID
     * @return
     */
    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}
package com.chenqian.dao;

import com.chenqian.pojo.User;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 用户
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
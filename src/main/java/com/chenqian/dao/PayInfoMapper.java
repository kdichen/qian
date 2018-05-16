package com.chenqian.dao;

import com.chenqian.pojo.PayInfo;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 支付
 */
public interface PayInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    PayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);
}
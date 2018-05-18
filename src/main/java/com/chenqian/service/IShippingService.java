package com.chenqian.service;

import com.chenqian.common.ServerResponse;
import com.chenqian.pojo.Shipping;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 陈谦
 * @Date: 2018/5/18 9:36
 * <p>
 * 收货地址
 */
public interface IShippingService {

    /**
     * 添加收获地址
     *
     * @param userId   用户Id
     * @param shipping
     * @return
     */
    ServerResponse add(Integer userId, Shipping shipping);

    /**
     * 删除收获地址
     *
     * @param userId     用户Id
     * @param shippingId 收获地址Id
     * @return
     */
    ServerResponse<String> del(Integer userId, Integer shippingId);

    /**
     * 修改收货地址
     *
     * @param userId   用户Id
     * @param shipping shipping
     * @return
     */
    ServerResponse update(Integer userId, Shipping shipping);

    /**
     * 查询收货地址
     *
     * @param userId     用户Id
     * @param shippingId 收获地址Id
     * @return
     */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    /**
     * 查询所有收获地址(带分页)
     *
     * @param userId   用户Id
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}

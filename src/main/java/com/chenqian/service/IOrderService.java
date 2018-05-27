package com.chenqian.service;

import com.chenqian.common.ServerResponse;
import com.chenqian.vo.OrderVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author: 陈谦
 * @Date: 2018/5/18 16:31
 */

public interface IOrderService {

    /**
     * 个人中心查看订单(带分页)
     * @param userId 用户Id
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    /**
     * 支付
     *
     * @param orderNo 订单Id
     * @param userId  用户Id
     * @param path    二维码地址
     * @return
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
     * 支付宝回调
     *
     * @param params
     * @return
     */
    ServerResponse aliCallback(Map<String, String> params);

    /**
     * 查询订单支付状态
     *
     * @param userId  用户ID
     * @param orderNo 订单ID
     * @return
     */
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    /**
     * 创建订单
     *
     * @param userId
     * @param shippingId 收货地址
     * @return
     */
    ServerResponse createOrder(Integer userId, Integer shippingId);

    /**
     * 取消订单(付款前)
     *
     * @param userId  用户Id
     * @param orderNo 订单编号
     * @return
     */
    ServerResponse<String> cancel(Integer userId, Long orderNo);

    /**
     * 获取购物车已经选中的商品详情
     *
     * @param userId 用户Id
     * @return
     */
    ServerResponse getOrderCartProduct(Integer userId);

    /**
     * 查看用户的订单详情
     *
     * @param userId  用户Id
     * @param orderNo 订单Id
     * @return
     */
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    // ---------------------- 后台管理 --------------------

    /**
     * 订单详情(带分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> manageList(int pageNum,int pageSize);

    /**
     * 查看订单详情
     * @param orderNo
     * @return
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    /**
     * 按订单号搜索 (待拓展)
     * @param orderNo 订单号
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);

    /**
     * 发货
     * @param orderNo 订单号
     * @return
     */
    ServerResponse<String> manageSendGoods(Long orderNo);

    /**
     * 指定时间内未付款, 则关闭订单
     * @param hour
     */
    void closeOrder(int hour);

}

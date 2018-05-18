package com.chenqian.service.impl;

import com.chenqian.common.ServerResponse;
import com.chenqian.dao.ShippingMapper;
import com.chenqian.pojo.Shipping;
import com.chenqian.service.IShippingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 陈谦
 * @Date: 2018/5/18 9:37
 * <p>
 * 收货地址
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    /**
     * 添加收获地址
     * Shipping -> SpringMVC 对象绑定方式, SpringMVC会自动生成这个对象, 并给他赋值
     *
     * @param userId   用户Id
     * @param shipping shipping
     * @return
     */
    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0) {
            Map result = Maps.newHashMap();
            result.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccessMessage("新建地址成功", result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    /**
     * 删除收获地址, 避免绕过前台直接传订单d, 删除不是自己的收获地址的情况. 所以要根据userId来删
     *
     * @param userId     用户Id
     * @param shippingId 收获地址Id
     * @return
     */
    @Override
    public ServerResponse<String> del(Integer userId, Integer shippingId) {
        int resultCount = shippingMapper.deleteByShippingIdUserId(userId, shippingId);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    /**
     * 修改收货地址, 同样是判断是否是登录用户的订单
     *
     * @param userId   用户Id
     * @param shipping shipping
     * @return
     */
    @Override
    public ServerResponse update(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByShipping(shipping);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    /**
     * 查询收货地址
     *
     * @param userId     用户Id
     * @param shippingId 收获地址Id
     * @return
     */
    @Override
    public ServerResponse<Shipping> select(Integer userId, Integer shippingId) {
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId, shippingId);
        if (shipping == null) {
            return ServerResponse.createByErrorMessage("无法查询到该地址");
        }
        return ServerResponse.createBySuccessMessage("更新地址成功", shipping);
    }

    /**
     * 查询所有收获地址(带分页)
     *
     * @param userId   用户Id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccessMessage(pageInfo);
    }
}

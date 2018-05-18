package com.chenqian.controller.portal;

import com.chenqian.common.Const;
import com.chenqian.common.ServerResponse;
import com.chenqian.enums.ResponseCodeEnum;
import com.chenqian.pojo.Shipping;
import com.chenqian.pojo.User;
import com.chenqian.service.IShippingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: 陈谦
 * @Date: 2018/5/18 9:36
 * <p>
 * 收获地址
 */

@Controller
@RequestMapping("/shipping/")
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;


    /**
     * 增加收获地址
     *
     * @param session
     * @param shipping
     * @return
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse add(HttpSession session, Shipping shipping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return iShippingService.add(user.getId(), shipping);
    }

    /**
     * 删除当前用户的手偶货地址
     *
     * @param session
     * @param shippingId 收货地址Id
     * @return
     */
    @RequestMapping("del.do")
    @ResponseBody
    public ServerResponse del(HttpSession session, Integer shippingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return iShippingService.del(user.getId(), shippingId);
    }

    /**
     * 修改当前用户的收获地址
     *
     * @param session
     * @param shipping 收获地址
     * @return
     */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse update(HttpSession session, Shipping shipping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return iShippingService.update(user.getId(), shipping);
    }


    /**
     * 查询收获地址
     *
     * @param session
     * @param shippingId 收货地址Id
     * @return
     */
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<Shipping> select(HttpSession session, Integer shippingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return iShippingService.select(user.getId(), shippingId);
    }


    /**
     * 查询当前登录用户的所有收货地址(带分页)
     *
     * @param pageNum
     * @param pageSize
     * @param session
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return iShippingService.list(user.getId(), pageNum, pageSize);
    }
}

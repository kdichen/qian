package com.chenqian.service;

import com.chenqian.common.ServerResponse;
import com.chenqian.pojo.User;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 11:19
 * <p>
 * 用户
 */

public interface IUserService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 注册
     *
     * @param user 用户对象
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 判断用户名是否存在
     *
     * @param str  传入的String
     * @param type 用户名/email 类型
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 找回密码问题
     *
     * @param username 用户名
     * @return
     */
    ServerResponse selectQuestion(String username);

    /**
     * 找回密码答案
     *
     * @param username 用户名
     * @param question 密码问题
     * @param answer   密码答案
     * @return
     */
    ServerResponse<String> forgetCheckAnswer(String username, String question, String answer);

    /**
     * 重置密码
     *
     * @param username    用户名
     * @param passwordNew 新密码
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetRequestPassword(String username, String passwordNew, String forgetToken);

    /**
     * 登录状态下重置密码
     *
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param user        用户对象
     * @return
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);


    /**
     * 更新用户个人信息
     *
     * @param user 用户对象
     * @return
     */
    ServerResponse<User> updateInfomation(User user);

    /**
     * 获取用户的详细信息
     *
     * @param userId 用户Id
     * @return
     */
    ServerResponse<User> getInformation(Integer userId);
}

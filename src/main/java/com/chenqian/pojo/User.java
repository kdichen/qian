package com.chenqian.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 用户
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户表id.
     */
    private Integer id;

    /**
     * 用户名.
     */
    private String username;

    /**
     * 用户密码，MD5加密.
     */
    private String password;

    /**
     * 邮箱.
     */
    private String email;

    /**
     * 电话.
     */
    private String phone;

    /**
     * 找回密码问题.
     */
    private String question;

    /**
     * 找回密码答案.
     */
    private String answer;

    /**
     * 角色0-管理员,1-普通用户.
     */
    private Integer role;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 最后一次更新时间.
     */
    private Date updateTime;

}
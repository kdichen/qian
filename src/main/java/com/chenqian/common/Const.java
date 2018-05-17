package com.chenqian.common;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 12:02
 * <p>
 * 封装常量
 */

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public interface Role {

        // 普通用户
        int ROLE_CUSTOMER = 0;
        // 管理员
        int ROLE_ADMIN = 1;

    }
}

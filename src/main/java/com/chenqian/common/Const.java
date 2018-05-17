package com.chenqian.common;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 12:02
 * <p>
 * 封装常量
 */

@Getter
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public interface ProductListOrderBy {
        /**
         * [与前端的约定]: 用下划线风格, 后面说明是升序还是降序
         */
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    public interface Cart{
        /**
         * 即购物车选中状态
         */
        int CHECKED = 1;
        /**
         * 购物车中未选中状态
         */
        int UN_CHECKED = 0;

        String LIMIT_NUM_FAIL = "限制失败";
        String LIMIT_NUM_SUCCESS = "限制成功";
    }

    public interface Role {

        /**
         * 普通用户
         */
        int ROLE_CUSTOMER = 0;

        /**
         * 管理员
         */
        int ROLE_ADMIN = 1;
    }

    @Getter
    public enum ProductStatusEnum {
        ON_SALE(1, "在线");
        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }


    }
}

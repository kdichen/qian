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

    public static final  String TOKEN_PREFIX = "token_";


    public interface RedisCacheExTime{
        // 30
        int REDIS_SESSION_EX_TIME = 60 * 30;

    }

    public interface ProductListOrderBy {
        /**
         * [与前端的约定]: 用下划线风格, 后面说明是升序还是降序
         */
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    /**
     * 购物车
     */
    public interface Cart {
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

    /**
     * 角色
     */
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

    /**
     * 商品状态
     */
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

    /**
     * 订单状态
     */
    @Getter
    public enum OrderStatusEnum {
        CANCELED(0, "已取消"), NO_PAY(10, "未支付"), PAID(20, "已付款"), SHIPPED(40, "已发货"), ORDER_SUCCESS(50, "订单完成"), ORDER_CLOSE(60, "订单关闭");


        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

    /**
     * 支付宝回调函数
     */
    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        /**
         * 必须这样返回
         */
        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    /**
     * 支付平台
     */
    @Getter
    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝");

        PayPlatformEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

    }

    /**
     * 支付方式
     */
    @Getter
    public enum PaymentTypeEnum {
        ONLINE_PAY(1, "在线支付");

        PaymentTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;


        public static PaymentTypeEnum codeOf(int code) {
            for (PaymentTypeEnum paymentTypeEnum : values()) {
                if (paymentTypeEnum.getCode() == code) {
                    return paymentTypeEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

    }
}

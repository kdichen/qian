package com.chenqian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 11:29
 */

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {
    SUCCESS(0, "成功"),

    ERROR(1, "错误"),

    ILLEGAL_ARGUMENT(2, "非法验证"),

    NEED_LOGIN(10, "需要登录"),;

    private final int code;

    private final String desc;

}

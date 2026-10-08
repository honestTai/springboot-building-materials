package com.build.common;

import lombok.Getter;

/**
 * 系统接口返回类
 */
@Getter
public class Result<T> {
    private String code;

    private String msg;

    private T data;

    private Integer total;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg, T data, Integer total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }
}

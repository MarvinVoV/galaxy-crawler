package com.galaxy.crawler.core.model.result;

import lombok.Data;

/**
 * @author hufeng
 * @version BaseResult.java, v 0.1 2020/7/5 20:05 Exp $
 */

@Data
public class BaseResult<T> {
    private boolean success;
    private String  code;
    private String  message;
    private T       data;


    public static <T> BaseResult<T> buildSuccessResult(T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public BaseResult<T> buildFailResult(String code, String message) {
        BaseResult<T> result = new BaseResult<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}

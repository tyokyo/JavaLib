package com.fengwenyi.javalib.jk;

/**
 * @author Wenyi Feng
 */
public interface ICallback<T> {

    /**
     * 成功回调
     */
    void onSuccess(T t);

    /**
     * 失败回调
     */
    void onFail(String msg);
}

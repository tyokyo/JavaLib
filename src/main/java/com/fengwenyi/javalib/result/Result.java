package com.fengwenyi.javalib.result;

/**
 * 返回码封装类
 * @author Wenyi Feng.
 */
public class Result {

    private int code;
    private String msg;
    private Object data;

    /**
     * 实例化
     */
    public Result() {
    }

    // [common]
    private void common(IReturnCode iReturnCode) {
        this.code = iReturnCode.getCode();
        this.msg = iReturnCode.getMsg();
    }

    /**
     * 设置返回码
     * @param iReturnCode 自定义枚举类，需要实现或继承IReturnCode
     */
    public void setResult(IReturnCode iReturnCode) {
        common(iReturnCode);
    }

    /**
     * 添加数据
     * @param iReturnCode 自定义枚举类，需要实现或继承IReturnCode
     * @param data 自定义数据对象
     */
    public void setData(IReturnCode iReturnCode, Object data) {
        common(iReturnCode);

        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

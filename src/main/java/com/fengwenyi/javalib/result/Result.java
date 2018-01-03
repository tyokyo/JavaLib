package com.fengwenyi.javalib.result;

/**
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
     */
    public void setResult(IReturnCode iReturnCode) {
        common(iReturnCode);
    }

    /**
     * 添加数据
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

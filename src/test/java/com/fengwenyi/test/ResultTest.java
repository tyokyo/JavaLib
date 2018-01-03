package com.fengwenyi.test;

import com.fengwenyi.javalib.result.IReturnCode;
import com.fengwenyi.javalib.result.Result;
import org.junit.Test;

/**
 * @author Wenyi Feng.
 */
public class ResultTest {

    @Test
    public void test() {
        Result result = new Result();
        //result.setData(ReturnCode.SUCCESS, "DATA");
        result.setResult(ReturnCode.ERROR_500);
        System.out.print(result.toString());
    }

    enum ReturnCode implements IReturnCode {

        // 500
        ERROR_500(500, "(Error)程序出错"),

        SUCCESS(0, "Success")
        ;

        private int code;
        private String msg;

        ReturnCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getMsg() {
            return msg;
        }
    }
}

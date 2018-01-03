package com.fengwenyi.javalib.util;

/**
 * Wenyi Feng(xfsy_2015@163.com)
 * 2017-12-07 13:50
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNullStr(String str) {

        return str == null
                || "".equals(str)
                || str.length() < 1;

    }

}

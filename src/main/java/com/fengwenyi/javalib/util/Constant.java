package com.fengwenyi.javalib.util;

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-28 14:32
 */
public interface Constant {

    /**
     * 编码
     */
    String DEFAULT_CHATSET = "UTF-8";

    /**
     * 连接超时时间（1分钟）
     */
    int DEFAULT_CONN_TIMEOUT = 1000 * 60;

    /**
     * 读取超时时间（10分钟）
     */
    int DEFAULT_READ_TIMEOUT = 1000 * 60 * 10;

    /**
     * get
     */
    String RequestMethodGet = "GET";

    /**
     * post
     */
    String RequestMethodPost = "POST";

    /**
     * put
     */
    String RequestMethodPut = "PUT";

    /**
     * delete
     */
    String RequestMethodDelete = "DELETE";

    /**
     * 获取ip地址的信息的uri
     */
    String IP_INFO_URI = "http://ip.taobao.com/service/getIpInfo.php";

}

package com.fengwenyi.javalib.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.fengwenyi.javalib.util.Constant.IP_INFO_URI;

/**
 * Wenyi Feng(xfsy_2015@163.com)
 * 2017-12-07 13:45
 */
public class Utils {

    /**
     * 将Map型转为请求参数型
     *
     * @param data Map类型的参数
     *
     * @return url请求的参数
     *
     * @throws UnsupportedEncodingException 异常
     */
    public static String getUrlParamsByMap(Map<String, String> data) throws UnsupportedEncodingException {

        if (data == null || data.isEmpty()) return null;

        StringBuilder sb = new StringBuilder();

        for (Map.Entry i : data.entrySet()) {

            sb
                    .append(i.getKey())
                    .append("=")
                    .append(URLEncoder.encode(i.getValue().toString(), Constant.DEFAULT_CHATSET))
                    .append("&");

        }

        return sb.toString();
    }

    /**
     * 将url参数转换成map
     * @param  param 如：aa=11&bb=22&cc=33
     * @return 参数Map
     */
    public static Map<String, String> getUrlParams(String param) {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtil.isNullStr(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

    /**
     * 获取ip位置信息
     * @param ip ip地址
     * @return json数据
     * @throws IOException io异常
     */
    public static JsonObject getIpInfo(String ip) throws IOException {
        String param = "?ip=" + ip;
        String ipInfoStr = NetDataUtil.get(IP_INFO_URI + param, null, null);
        JsonObject ipInfoJsonObject = new JsonParser().parse(ipInfoStr).getAsJsonObject();
        return ipInfoJsonObject.get("data").getAsJsonObject();
    }

    /**
     * 通过ip获取位置
     * @param ip ip地址
     * @return （国家）（地区）（省份）（城市）（县级）（运营商）
     * @throws IOException io异常
     */
    public static String getPosition(String ip) throws IOException {
        JsonObject dataObject = getIpInfo(ip);
        String country = dataObject.get("country").getAsString();
        String area = dataObject.get("area").getAsString();
        String region = dataObject.get("region").getAsString();
        String city = dataObject.get("city").getAsString();
        String county = dataObject.get("county").getAsString();
        String isp = dataObject.get("isp").getAsString();
        return country + area + region + city + county + isp;
    }

    /**
     * UUID
     */
    public static String getUUID() {
        String uuIdStr = UUID.randomUUID().toString();

        return uuIdStr.replaceAll("-", "");
    }

}

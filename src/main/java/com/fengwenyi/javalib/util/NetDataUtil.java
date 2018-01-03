package com.fengwenyi.javalib.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-10-26 16:53
 */
public class NetDataUtil {
    /**
     * GET方式向URL提交数据并获取返回结果（常用）
     *
     * @param url URL/url+param
     *
     * @return 服务器数据
     *
     * @throws IOException 异常
     */
    public static String doGetByUrl(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection) urlObject.openConnection();
        httpUrlConn.setConnectTimeout(Constant.DEFAULT_CONN_TIMEOUT);
        httpUrlConn.setReadTimeout(Constant.DEFAULT_READ_TIMEOUT);
        httpUrlConn.setUseCaches(false);
        httpUrlConn.setRequestMethod(Constant.RequestMethodGet);
        httpUrlConn.setDoInput(true);
        httpUrlConn.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        httpUrlConn.disconnect();
        return sb.toString();
    }

    /**
     * GET方式向URL提交数据并获取返回结果（参数放在Map中）
     *
     * @param url   服务器地址
     * @param param 参数
     *
     * @return 服务器数据
     *
     * @throws IOException 异常
     */
    public static String doGetByUrl(String url, Map<String, String> param) throws IOException {

        StringBuffer stringBuffer = new StringBuffer(url).append("?");

        for (Map.Entry<String, String> map : param.entrySet()) {
            String paramKey = map.getKey();
            String paramValue = map.getValue();
            stringBuffer.append(paramKey).append("=").append(paramValue).append("&");
        }

        url = stringBuffer.substring(0, stringBuffer.length() - 1);

        URL urlObject = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection) urlObject.openConnection();
        httpUrlConn.setConnectTimeout(Constant.DEFAULT_CONN_TIMEOUT);
        httpUrlConn.setReadTimeout(Constant.DEFAULT_READ_TIMEOUT);
        httpUrlConn.setUseCaches(false);
        httpUrlConn.setRequestMethod(Constant.RequestMethodGet);
        httpUrlConn.setDoInput(true);
        httpUrlConn.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        httpUrlConn.disconnect();
        return sb.toString();
    }

    /**
     * POST方式向URL提交数据并获取返回结果（常用）
     *
     * @param url    服务器地址
     * @param param  参数
     *
     * @return 服务器数据
     *
     * @throws IOException 异常
     */
    public static String doPostByUrl(String url, String param) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection) urlObject.openConnection();
        httpUrlConn.setConnectTimeout(Constant.DEFAULT_CONN_TIMEOUT);
        httpUrlConn.setReadTimeout(Constant.DEFAULT_READ_TIMEOUT);
        httpUrlConn.setUseCaches(false);
        httpUrlConn.setRequestMethod(Constant.RequestMethodPost);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.connect();

        PrintWriter pw = new PrintWriter(httpUrlConn.getOutputStream());
        pw.print(param);
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        httpUrlConn.disconnect();
        return sb.toString();
    }

    // Post 方式请求数据(DataOutputStream)
    private String doPostByUrl2(String uri, String param) throws IOException {
        HttpURLConnection connection;
        URL url = new URL(uri);

        connection = (HttpURLConnection)url.openConnection();// 新建连接实例
        connection.setConnectTimeout(Constant.DEFAULT_CONN_TIMEOUT);// 设置连接超时时间，单位毫秒
        connection.setReadTimeout(Constant.DEFAULT_READ_TIMEOUT);// 设置读取数据超时时间，单位毫秒
        connection.setDoInput(true);// 是否打开输出流 true|false
        connection.setDoOutput(true);// 是否打开输入流true|false
        connection.setRequestMethod(Constant.RequestMethodPost);// 提交方法POST|GET
        connection.setUseCaches(false);// 是否缓存true|false
        connection.connect();// 打开连接端口

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(param);
        out.flush();
        out.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Constant.DEFAULT_CHATSET));
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = reader.readLine())!= null) {
            buffer.append(line);
        }
        reader.close();
        connection.disconnect(); // 关闭连接
        return buffer.toString();
    }


    /**
     * POST方式向URL提交数据并获取返回结果（json）
     *
     * @param url     服务器地址
     * @param param   参数
     *
     * @return 服务器数据
     *
     * @throws IOException 异常
     */
    public static String doPostJsonByUrl(String url, String param) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection)urlObject.openConnection();
        httpUrlConn.setConnectTimeout(Constant.DEFAULT_CONN_TIMEOUT);
        httpUrlConn.setReadTimeout(Constant.DEFAULT_READ_TIMEOUT);
        httpUrlConn.setUseCaches(false);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setRequestMethod(Constant.RequestMethodPost);
        httpUrlConn.setRequestProperty("Accept", "application/json");
        httpUrlConn.setRequestProperty("Content-Type", "application/json");
        httpUrlConn.connect();

        PrintWriter pw = new PrintWriter(httpUrlConn.getOutputStream());
        pw.print(param);
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }

        httpUrlConn.disconnect();
        return sb.toString();
    }

    /**
     * POST方式向URL提交数据并获取返回结果（自定义属性）
     *
     * @param url      服务器地址
     * @param header   header属性设置
     * @param param    参数
     * @param connTime 链接超时时间
     * @param readTime 读取超时时间
     * @param isCaChes 是否使用缓存
     *
     * @return 服务器数据
     *
     * @throws IOException  异常
     */
    public static String doPostByUrl(String url, Map<String, String> header, String param, int connTime, int readTime,
                                     boolean isCaChes) throws IOException {

        URL urlObject = new URL(url);

        HttpURLConnection httpUrlConn = (HttpURLConnection)urlObject.openConnection();

        httpUrlConn.setConnectTimeout(connTime);
        httpUrlConn.setReadTimeout(readTime);
        httpUrlConn.setUseCaches(isCaChes);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setRequestMethod(Constant.RequestMethodPost);

        for (Map.Entry<String, String> map : header.entrySet()) {
            String headerKey = map.getKey();
            String headerValue = map.getValue();
            httpUrlConn.setRequestProperty(headerKey, headerValue);
        }

        httpUrlConn.connect();

        PrintWriter pw = new PrintWriter(httpUrlConn.getOutputStream());
        pw.print(param);
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }

        httpUrlConn.disconnect();

        return sb.toString();
    }

    /**
     * GET方式向URL提交数据并获取返回结果（自定义）
     *
     * @param url      服务器地址
     * @param header   header属性设置
     * @param param    参数
     * @param connTime 链接超时时间
     * @param readTime 读取超时时间
     * @param isCaChes 是否使用缓存
     *
     * @return 服务器数据
     *
     * @throws IOException 异常
     */
    public static String doGetByUrl(String url, Map<String, String> header, Map<String, String> param, int connTime,
                                    int readTime, boolean isCaChes) throws IOException {

        StringBuilder stringBuilder = new StringBuilder(url).append("?");

        for (Map.Entry<String, String> map : param.entrySet()) {
            String paramKey = map.getKey();
            String paramValue = map.getValue();
            stringBuilder.append(paramKey).append("=").append(paramValue).append("&");
        }

        url = stringBuilder.substring(0, stringBuilder.length() - 1);

        URL urlObject = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection) urlObject.openConnection();
        httpUrlConn.setConnectTimeout(connTime);
        httpUrlConn.setReadTimeout(readTime);
        httpUrlConn.setUseCaches(isCaChes);
        httpUrlConn.setRequestMethod(Constant.RequestMethodGet);
        httpUrlConn.setDoInput(true);

        for (Map.Entry<String, String> map : header.entrySet()) {
            String headerKey = map.getKey();
            String headerValue = map.getValue();
            httpUrlConn.setRequestProperty(headerKey, headerValue);
        }

        httpUrlConn.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        httpUrlConn.disconnect();

        return sb.toString();
    }

}

package com.ks.spider.common;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author by hj
 * @Date 2020/5/10 18:06
 * @Description : http客户端工具类
 */
@Slf4j
@Component
public class HttpClientUtils {
    private final static String GET_METHOD = "GET";
    private final static String POST_METHOD = "POST";

    /**
     * get请求
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public static String sendGet(String url, Map<String, String> headers, Map<String, String> params) {
        // 创建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        StringBuilder reqUrl = new StringBuilder(url);
        String result = "";
        /*
         * 设置param参数
         */
        if (params != null && params.size() > 0) {
            reqUrl.append("?");
            for (Map.Entry<String, String> param : params.entrySet()) {
                reqUrl.append(param.getKey() + "=" + param.getValue() + "&");
            }
            url = reqUrl.subSequence(0, reqUrl.length() - 1).toString();
        }
        log.debug("[url:" + url + ",method:" + GET_METHOD + "]");
        HttpGet httpGet = new HttpGet(url);
        /**
         * 设置头部
         */
        log.debug("Header\n");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpGet.addHeader(header.getKey(), header.getValue());
                log.debug(header.getKey() + " : " + header.getValue());
            }
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            /**
             * 请求成功
             */
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, SysParam.DEFAULT_CHARSET);
            }
        } catch (IOException e) {
            log.error("网络请求出错，请检查原因");
        } finally {
            // 关闭资源
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
                log.error("网络关闭错误错，请检查原因");
            }
        }
        return result;
    }



}

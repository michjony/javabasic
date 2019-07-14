package com.michjony.basic.util.http;

import com.michjony.basic.util.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * user:Cherie
 * datetime;2019/7/12 20:12
 */
@Slf4j
public class OkHttpUtils {


    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .callTimeout(60, TimeUnit.SECONDS)
            .build();

    /**
     * 异步get
     *
     * @param url
     * @param params
     */
    public static void asynget(String url, Map<String, String> params) {
        final Request request = new Request.Builder()
                .url(url + MyStringUtils.buildUrl(params))
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                log.info("onFailure: {}", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                log.info("onResponse: " + response.body().string());
            }
        });
    }


    /**
     * 异步get
     *
     * @param url
     * @param params
     * @param callback
     */
    public static void asynget(String url, Map<String, String> params, Callback callback) {
        final Request request = new Request.Builder()
                .url(url + MyStringUtils.buildUrl(params))
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * 同步get
     *
     * @param url
     * @param params
     * @return
     */
    public static String sync(String url, Map<String, String> params) {
        final Request request = new Request.Builder()
                .url(url + MyStringUtils.buildUrl(params))
                .get()//默认就是GET请求，可以不写
                .build();
        try {
            Response rsp = okHttpClient.newCall(request).execute();
            if (rsp.isSuccessful()) {
                return rsp.body().string();
            } else {
                throw new IOException("Unexpected code " + rsp);
            }

        } catch (IOException e) {
            log.error("e:{}", e);
            return "";
        }
    }

    /**
     * POST请求（键值对 key-value）
     * @param url
     * @param params
     */
    public void postKeyValue(String url, Map<String, String> params) {
        // 创建 FormBody 添加需要的键值对
        FormBody.Builder builder = new FormBody.Builder();
        params.forEach((k, v) -> builder.add(k, v));
        builder.build();

    }


    public static void main(String[] args) {
        String sync = sync("http://www.baidu.com", new HashMap<>());
        log.info("sync");
    }

}

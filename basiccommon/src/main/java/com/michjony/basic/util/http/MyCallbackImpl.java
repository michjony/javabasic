package com.michjony.basic.util.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;

/**
 * 异步接口实现类
 * user:Cherie
 * datetime;2019/7/12 21:13
 */
//@Slf4j
public class MyCallbackImpl implements Callback {

    @Override
    public void onFailure(Call call, IOException e) {
//        log.info("e:{}", e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
//        log.info("res:", response.body().string());
    }
}

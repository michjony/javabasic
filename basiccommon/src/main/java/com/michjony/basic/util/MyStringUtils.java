package com.michjony.basic.util;

import java.util.Map;

/**
 * user:Cherie
 * datetime;2019/7/12 20:15
 */
public final class MyStringUtils {

    private final static String urlLink = "&";

    private final static String equalSign = "=";

    public static String buildUrl(Map<String, String> param) {
        if (param.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(urlLink).append(key).append(equalSign).append(value);
        }
        return "?" + sb.substring(1).toString();
    }

}

package com.example.demotest2.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.houbb.heaven.util.lang.StringUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaiduTranslationUtils {
        private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

        private static final String appid = "20180528000167957";
        private static final String securityKey = "blsBUtg8jzRuJLy8Qb3c";


        public String getTransResult(String query, String from, String to) {
            Map<String, String> params = buildParams(query, from, to);
            StringBuilder result = new StringBuilder(StringUtil.EMPTY);
            JSONArray resultArray = JSONObject.parseObject(HttpGet.get(TRANS_API_HOST, params)).getJSONArray("trans_result");
            for (Object o : resultArray) {
                JSONObject jsonObjectResult = (JSONObject) o;
                result.append(jsonObjectResult.getString("dst")).append("\n");
            }
            result.deleteCharAt(result.length()-1);
            return result.toString();
        }

        private Map<String, String> buildParams(String query, String from, String to) {
            Map<String, String> params = new HashMap<String, String>();
            params.put("q", query);
            params.put("from", from);
            params.put("to", to);

            params.put("appid", appid);

            // 随机数
            String salt = String.valueOf(System.currentTimeMillis());
            params.put("salt", salt);

            // 签名
            String src = appid + query + salt + securityKey; // 加密前的原文
            params.put("sign", MD5.md5(src));

            params.put("action","1");

            return params;
        }


}

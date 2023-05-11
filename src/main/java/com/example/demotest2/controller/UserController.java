package com.example.demotest2.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.example.demotest2.utils.BaiduTranslationUtils;
import com.example.demotest2.utils.TranslationUtils;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private SensitiveWordBs sensitiveWordBs;
    @Resource
    private BaiduTranslationUtils baiduTranslationUtils;

    @GetMapping("/getUser")
    public String getUser() {
        String testA = "这个女人真的很漂亮……";
        System.out.println(sensitiveWordBs.replace(testA));
        System.out.println(sensitiveWordBs.findFirst(testA));
        System.out.println(sensitiveWordBs.contains(testA) ? "包含敏感词" : "不包含敏感词");
        return "user";
    }

    @GetMapping("/translation")
    public String translation() throws InterruptedException, IOException {
        File jsonFile = new File("C:\\Users\\18252\\Desktop\\test.json");
        String testA = FileUtils.readFileToString(jsonFile, "UTF-8");
//        String testA = "";
        LinkedHashMap<String, String> oldObject = JSONObject.parseObject(testA, LinkedHashMap.class, Feature.OrderedField);
        JSONObject newObject = new JSONObject(64, true);
        int count = 0;
        for (String k : oldObject.keySet()) {
            newObject.put(k, baiduTranslationUtils.getTransResult(oldObject.get(k).toString(), "en", "zh"));
            System.out.println(oldObject.get(k) + "--" + newObject.get(k));
            System.out.println("=========================== " + k + " =================================");
            Thread.sleep(100);

        }
        return newObject.toJSONString();
    }

    @GetMapping("/getWords")
    public String getWords() {
        for (int i = 2; i < 60; i++) {
            System.out.println("Form1.CheckBox" + i + ".Value = 0");
        }
        return "";
    }

    @GetMapping("/getPassword")
    public String getPassword() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("action", "downprocess");
        paramMap.put("sign", "A2UHOV5vUGFSW1FuBjZTb1Y6V2QHagMyBDpUZAZtVGBVcwAjAWEDZgdnC2oBYFxrAWMHMlM_aVmQDNg_c_c");
        paramMap.put("p", "gpks");
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            String result= HttpUtil.post("https://wwn.lanzoul.com/ajaxm.php", paramMap);
//            JSONObject jsonObject = JSONObject.parseObject(result);
//            if ("密码不正确".equals(jsonObject.getString("inf"))) {
//                System.out.println("密码不正确！");
//            }else {
//                System.out.println("密码正确！");
//            }
            System.out.println(i+": "+result);
        }
        System.out.println(System.currentTimeMillis());
        return "";
    }


}

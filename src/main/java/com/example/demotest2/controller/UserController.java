package com.example.demotest2.controller;

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


}

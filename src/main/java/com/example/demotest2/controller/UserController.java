package com.example.demotest2.controller;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    SensitiveWordBs sensitiveWordBs;

    @GetMapping("/getUser")
    public String getUser() {
        String testA = "这个女人真的很漂亮……";
        System.out.println(sensitiveWordBs.replace(testA));
        System.out.println(sensitiveWordBs.findFirst(testA));
        System.out.println(sensitiveWordBs.contains(testA) ? "包含敏感词" : "不包含敏感词");
        return "user";
    }

}

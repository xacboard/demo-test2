package com.example.demotest2.conig;

import com.github.houbb.sensitive.word.api.IWordAllow;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
@Component
public class MyDdWordAllow implements IWordAllow {

    @Override
    public List<String> allow() {
        System.out.println("查询了一次敏感词数据库！");
        // 数据库查询
        return Arrays.asList("性","女人","女装");
    }

}

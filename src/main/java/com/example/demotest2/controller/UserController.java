package com.example.demotest2.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demotest2.domain.User;
import com.example.demotest2.strategy.TestAStrategy;
import com.example.demotest2.util.MyThreadPool;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    SensitiveWordBs sensitiveWordBs;

    private RateLimiter rateLimiter = RateLimiter.create(1.0);

    @GetMapping("/getUser")
    public String getUser() {
        String testA = "这个女人真的很漂亮……";
        String testB = "";
        System.out.println(sensitiveWordBs.replace(testB));
        System.out.println(sensitiveWordBs.findFirst(testA));
        System.out.println(sensitiveWordBs.contains(testA) ? "包含敏感词" : "不包含敏感词");
        return "user";
    }

    @GetMapping("/dddd")
    public String ddddd() {
        String test = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"msg\": \"{\\\"multiArray\\\":[[\\\"11\\\",\\\"5\\\",\\\"7\\\",\\\"8\\\",\\\"9\\\",\\\"10\\\"],[\\\"1101\\\",\\\"1102\\\",\\\"1103\\\",\\\"1105\\\",\\\"1106\\\",\\\"1107\\\",\\\"1108\\\",\\\"1109\\\",\\\"1110\\\",\\\"1111\\\",\\\"1112\\\",\\\"1113\\\",\\\"1115\\\",\\\"1116\\\",\\\"1117\\\",\\\"1118\\\",\\\"1119\\\",\\\"1120\\\",\\\"1121\\\",\\\"1122\\\",\\\"1123\\\",\\\"1125\\\"]],\\\"multiIndex\\\":{\\\"10\\\":[\\\"1001\\\",\\\"1002\\\",\\\"1003\\\",\\\"1005\\\",\\\"1006\\\",\\\"1007\\\",\\\"1008\\\",\\\"1009\\\",\\\"1010\\\",\\\"1011\\\",\\\"1012\\\",\\\"1013\\\",\\\"1015\\\",\\\"1016\\\",\\\"1017\\\",\\\"1018\\\",\\\"1019\\\",\\\"1020\\\",\\\"1021\\\",\\\"1022\\\",\\\"1023\\\",\\\"1025\\\",\\\"1026\\\",\\\"1027\\\",\\\"1028\\\",\\\"1029\\\",\\\"1030\\\",\\\"1031\\\"],\\\"11\\\":[\\\"1101\\\",\\\"1102\\\",\\\"1103\\\",\\\"1105\\\",\\\"1106\\\",\\\"1107\\\",\\\"1108\\\",\\\"1109\\\",\\\"1110\\\",\\\"1111\\\",\\\"1112\\\",\\\"1113\\\",\\\"1115\\\",\\\"1116\\\",\\\"1117\\\",\\\"1118\\\",\\\"1119\\\",\\\"1120\\\",\\\"1121\\\",\\\"1122\\\",\\\"1123\\\",\\\"1125\\\"],\\\"5\\\":[\\\"前台\\\",\\\"开门点\\\"],\\\"7\\\":[\\\"8701\\\",\\\"8702\\\",\\\"8703\\\",\\\"8705\\\",\\\"8706\\\",\\\"8707\\\",\\\"8708\\\",\\\"8709\\\",\\\"8710\\\",\\\"8716\\\",\\\"8717\\\",\\\"8718\\\",\\\"8719\\\",\\\"8720\\\",\\\"8721\\\",\\\"8722\\\",\\\"8723\\\",\\\"8725\\\",\\\"8726\\\",\\\"8727\\\",\\\"8728\\\",\\\"8729\\\",\\\"8730\\\",\\\"8731\\\"],\\\"8\\\":[\\\"8801\\\",\\\"8802\\\",\\\"8803\\\",\\\"8805\\\",\\\"8806\\\",\\\"8807\\\",\\\"8808\\\",\\\"8809\\\",\\\"8810\\\",\\\"8811\\\",\\\"8812\\\",\\\"8813\\\",\\\"8815\\\",\\\"8816\\\",\\\"8817\\\",\\\"8818\\\",\\\"8819\\\",\\\"8820\\\",\\\"8821\\\",\\\"8822\\\",\\\"8823\\\",\\\"8825\\\",\\\"8826\\\",\\\"8827\\\",\\\"8828\\\",\\\"8829\\\",\\\"8830\\\",\\\"8831\\\"],\\\"9\\\":[\\\"8901\\\",\\\"8902\\\",\\\"8903\\\",\\\"8905\\\",\\\"8906\\\",\\\"8907\\\",\\\"8908\\\",\\\"8909\\\",\\\"8910\\\",\\\"8911\\\",\\\"8912\\\",\\\"8913\\\",\\\"8915\\\",\\\"8916\\\",\\\"8917\\\",\\\"8918\\\",\\\"8919\\\",\\\"8920\\\",\\\"8921\\\",\\\"8922\\\",\\\"8923\\\",\\\"8925\\\",\\\"8926\\\",\\\"8927\\\",\\\"8928\\\",\\\"8929\\\",\\\"8930\\\",\\\"8931\\\"]},\\\"multiNoCHArray\\\":[[\\\"11\\\",\\\"7\\\",\\\"8\\\",\\\"9\\\",\\\"10\\\"],[\\\"1101\\\",\\\"1102\\\",\\\"1103\\\",\\\"1105\\\",\\\"1106\\\",\\\"1107\\\",\\\"1108\\\",\\\"1109\\\",\\\"1110\\\",\\\"1111\\\",\\\"1112\\\",\\\"1113\\\",\\\"1115\\\",\\\"1116\\\",\\\"1117\\\",\\\"1118\\\",\\\"1119\\\",\\\"1120\\\",\\\"1121\\\",\\\"1122\\\",\\\"1123\\\",\\\"1125\\\"]],\\\"multiNoCHIndex\\\":{\\\"10\\\":[\\\"1001\\\",\\\"1002\\\",\\\"1003\\\",\\\"1005\\\",\\\"1006\\\",\\\"1007\\\",\\\"1008\\\",\\\"1009\\\",\\\"1010\\\",\\\"1011\\\",\\\"1012\\\",\\\"1013\\\",\\\"1015\\\",\\\"1016\\\",\\\"1017\\\",\\\"1018\\\",\\\"1019\\\",\\\"1020\\\",\\\"1021\\\",\\\"1022\\\",\\\"1023\\\",\\\"1025\\\",\\\"1026\\\",\\\"1027\\\",\\\"1028\\\",\\\"1029\\\",\\\"1030\\\",\\\"1031\\\"],\\\"11\\\":[\\\"1101\\\",\\\"1102\\\",\\\"1103\\\",\\\"1105\\\",\\\"1106\\\",\\\"1107\\\",\\\"1108\\\",\\\"1109\\\",\\\"1110\\\",\\\"1111\\\",\\\"1112\\\",\\\"1113\\\",\\\"1115\\\",\\\"1116\\\",\\\"1117\\\",\\\"1118\\\",\\\"1119\\\",\\\"1120\\\",\\\"1121\\\",\\\"1122\\\",\\\"1123\\\",\\\"1125\\\"],\\\"7\\\":[\\\"8701\\\",\\\"8702\\\",\\\"8703\\\",\\\"8705\\\",\\\"8706\\\",\\\"8707\\\",\\\"8708\\\",\\\"8709\\\",\\\"8710\\\",\\\"8716\\\",\\\"8717\\\",\\\"8718\\\",\\\"8719\\\",\\\"8720\\\",\\\"8721\\\",\\\"8722\\\",\\\"8723\\\",\\\"8725\\\",\\\"8726\\\",\\\"8727\\\",\\\"8728\\\",\\\"8729\\\",\\\"8730\\\",\\\"8731\\\"],\\\"8\\\":[\\\"8801\\\",\\\"8802\\\",\\\"8803\\\",\\\"8805\\\",\\\"8806\\\",\\\"8807\\\",\\\"8808\\\",\\\"8809\\\",\\\"8810\\\",\\\"8811\\\",\\\"8812\\\",\\\"8813\\\",\\\"8815\\\",\\\"8816\\\",\\\"8817\\\",\\\"8818\\\",\\\"8819\\\",\\\"8820\\\",\\\"8821\\\",\\\"8822\\\",\\\"8823\\\",\\\"8825\\\",\\\"8826\\\",\\\"8827\\\",\\\"8828\\\",\\\"8829\\\",\\\"8830\\\",\\\"8831\\\"],\\\"9\\\":[\\\"8901\\\",\\\"8902\\\",\\\"8903\\\",\\\"8905\\\",\\\"8906\\\",\\\"8907\\\",\\\"8908\\\",\\\"8909\\\",\\\"8910\\\",\\\"8911\\\",\\\"8912\\\",\\\"8913\\\",\\\"8915\\\",\\\"8916\\\",\\\"8917\\\",\\\"8918\\\",\\\"8919\\\",\\\"8920\\\",\\\"8921\\\",\\\"8922\\\",\\\"8923\\\",\\\"8925\\\",\\\"8926\\\",\\\"8927\\\",\\\"8928\\\",\\\"8929\\\",\\\"8930\\\",\\\"8931\\\"]}}\",\n" +
                "    \"data\": null\n" +
                "}";
//        JSONObject result = JSONUtil.parseObj(test);
//        String msg = JSONUtil.parseObj(test).get("msg",String.class);
//        JSONObject dd = JSONUtil.parseObj(JSONUtil.parseObj(test).get("msg",String.class));
        String multiIndex = JSONUtil.parseObj(JSONUtil.parseObj(test).get("msg", String.class)).get("multiIndex", String.class);
        System.out.println(multiIndex);
        System.out.println("===========================");
        return "user";
    }


    @PostMapping("/rrrr")
    public String test(@RequestBody Map<String, Object> params) {
        List<Map> test = (List<Map>) params.get("test");
        for (int i = 0; i < test.size(); i++) {
            Map obj = test.get(i);
            System.out.println(obj.get("name"));
        }
        return test.size() + "";
    }

    @GetMapping("/rm")
    public String rmTest() {
        TestAStrategy strategy = new TestAStrategy();
        double acquire = rateLimiter.acquire(1);
        MyThreadPool.executor.execute(strategy::testA);

        return "test";
    }

}

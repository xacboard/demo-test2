package com.example.demotest2.controller;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping("/test")
    public String testA() throws IOException, InterruptedException {
        String[] arguments = new String[]{"python", "D:\\GPT2-Chinese-old\\generate.py", "--save_samples"};   //这里构建要在cmd中输入的参数，第二个参数表示.py文件的路径，第二个之后的参数都表示要传给.py文件的参数，可以根据.py文件的需求写
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = new String(arguments[i].getBytes(), "UTF-8"); //将字符串转换为utf-8编码
        }
        Process process = Runtime.getRuntime().exec(arguments);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);  //在java编译器中打印.py文件的执行结果
        }
        in.close();
        BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String errLine = null;
        while ((errLine = err.readLine()) != null) {
            System.err.println(errLine); //在java编译器中打印错误信息
        }
        err.close();
        int re = process.waitFor();//因为是process这个进程调用.py文件， 所以要将当前进程阻塞等待.py文件执行完毕， 若果.py文件成功运行完毕，此方法将返回0，代表执行成功
        System.out.println(re); //执行成功的话这里会打印一个0，否则会打印1，2或者其他数字
        return line;
    }

}

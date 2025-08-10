package com.itheima;

import cn.hutool.core.io.FileUtil;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootTest
class SpringbootWebTests {

    @Autowired
    private ApplicationContext applicationContext;//IOC容器

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @Autowired
    private Gson gson;

    @Test
    public void tsetJson(){
        System.out.println(gson.toJson(Result.success("Hello Gson")));    }

    @Test
    public void testScope(){
        for(int i = 0; i < 1000; i++){
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }

    @Test
    public void testUpload() throws Exception {
        File file = new File("D:\\桌面\\456.png");
        String url = aliyunOSSOperator.upload(FileUtil.readBytes(file), "456.png");
        System.out.println(url);
    }

//    @Autowired
//    private TokenParser tokenParser;
//
//    @Test
//    public void testTokenParser(){
//        tokenParser.parse();
//    }

    @Autowired
    private HeaderParser headerParser;
    @Test
    public void testHeaderParser(){
        headerParser.parse();
    }
}

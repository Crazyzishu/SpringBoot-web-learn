package com.itheima;

import cn.hutool.core.io.FileUtil;
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
    private ApplicationContext applicationContext;

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

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
}

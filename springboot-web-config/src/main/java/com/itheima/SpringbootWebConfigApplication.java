package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//自动配置实现方案一：@Component + @Configuration
//@ComponentScan(basePackages = {"com.example","com.itheima"})

//自动配置方案二：@Import
//@Import(TokenParser.class)//导入普通类
//@Import(HeaderConfig.class)//导入0配置类
//@Import(MyImportSelector.class)//批量导入

@EnableHeaderConfig
@SpringBootApplication//具备组件扫描的功能，但是扫描的是启动类所在包及其子包
public class SpringbootWebConfigApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }
}

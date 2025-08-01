package com.itheima.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OSS配置属性类
 * 用于读取并封装阿里云OSS相关配置信息
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    /**
     * OSS服务的终端节点
     * 对应配置文件中的 aliyun.oss.endpoint
     */
    private String endpoint;
    
    /**
     * OSS存储空间名称
     * 对应配置文件中的 aliyun.oss.bucketName
     */
    private String bucketName;
    
    /**
     * OSS服务所在区域
     * 对应配置文件中的 aliyun.oss.region
     */
    private String region;
}
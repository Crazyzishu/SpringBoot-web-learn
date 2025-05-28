package org.zishu.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")// prefix:可有效绑定到此对象的属性的前缀
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}

package com.hendisantika.springboots3demo2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/01/21
 * Time: 08.10
 */
@Data
@ConfigurationProperties("app")
@Configuration
public class ApplicationProperties {

    private AwsServices awsServices;

    @Data
    public static class AwsServices {

        private String bucketName;
    }
}
package com.hendisantika.springboots3demo2.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/01/21
 * Time: 08.09
 */
@Slf4j
@Configuration
public class ApplicationConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public AmazonS3 amazonS3Client(AWSCredentialsProvider credentialsProvider,
                                   @Value("${cloud.aws.region.static}") String region) {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(credentialsProvider)
                .withRegion(region)
                .build();
    }
}

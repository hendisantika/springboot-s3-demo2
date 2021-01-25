package com.hendisantika.springboots3demo2.service;

import com.amazonaws.services.s3.AmazonS3;
import com.hendisantika.springboots3demo2.config.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/01/21
 * Time: 08.08
 */
@Slf4j
@Service
public class DocumentManagementService {
    @Autowired
    private AmazonS3 amazonS3Client;

    @Autowired
    private ApplicationProperties applicationProperties;
}

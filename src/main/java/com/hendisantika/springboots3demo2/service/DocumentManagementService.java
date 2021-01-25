package com.hendisantika.springboots3demo2.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.hendisantika.springboots3demo2.config.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

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

    public void uploadMultipleFiles(List<MultipartFile> files) {
        if (files != null) {
            files.forEach(multipartFile -> {
                File file = convertMultiPartFileToFile(multipartFile);
                String uniqueFileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
                uploadFileToS3bucket(uniqueFileName, file, applicationProperties.getAwsServices().getBucketName());
            });
        }
    }

    private void uploadFileToS3bucket(String fileName, File file, String bucketName) {
        amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
    }

    private S3Object downloadFileFromS3bucket(String fileName, String bucketName) {
        S3Object object = amazonS3Client.getObject(bucketName, fileName);
        return object;
    }
}

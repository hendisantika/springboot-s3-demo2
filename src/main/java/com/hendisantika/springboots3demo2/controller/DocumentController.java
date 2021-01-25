package com.hendisantika.springboots3demo2.controller;

import com.hendisantika.springboots3demo2.service.DocumentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-s3-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/01/21
 * Time: 08.14
 */
@RestController
public class DocumentController {

    @Autowired
    private DocumentManagementService documentManagementService;

    @PostMapping("${app.endpoint.uploadFiles}")
    public void uploadMultipleFiles(@ModelAttribute List<MultipartFile> files) {
        documentManagementService.uploadMultipleFiles(files);
    }
}

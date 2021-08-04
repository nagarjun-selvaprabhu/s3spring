package com.nagarjun.s3example.controller;

import com.nagarjun.s3example.service.AmazonS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/aws/s3/")
public class controller {

    @Autowired
    AmazonS3Service amazonS3Service;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        String result = amazonS3Service.uploadFileToBucket(file);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteFile")
    public ResponseEntity<String> deleteFile(@RequestPart(value = "key") String key) {
        String result = amazonS3Service.deleteFileFromBucket(key);
        return ResponseEntity.ok(result);
    }
}

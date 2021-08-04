package com.nagarjun.s3example.service;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3Service {

    String uploadFileToBucket(MultipartFile multipartFile);
    String deleteFileFromBucket(String key);
}

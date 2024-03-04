package com.cryptogramming.apirest.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IBucket {

     BucketObject uploadFile(MultipartFile multipartFile) throws IOException;

}

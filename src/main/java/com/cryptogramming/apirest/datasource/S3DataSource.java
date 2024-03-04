package com.cryptogramming.apirest.datasource;

import com.cryptogramming.apirest.domain.BucketObject;
import com.cryptogramming.apirest.domain.IBucket;
import com.cryptogramming.apirest.infrastructure.remote.S3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
@EnableConfigurationProperties
public class S3DataSource implements IBucket {


    @Value("${bucket.name}")
    private String bucketName;

    @Value("${bucket.accessKeyId}")
    private String accessKeyId;

    @Value("${bucket.accessSecKey}")
    private String accessSecKey;
    S3Client s3Client;

    public S3DataSource() {
        this.s3Client = new S3Client();
    }

    public BucketObject uploadFile(MultipartFile multipartFile) throws IOException {

        String fileName = multipartFile.getOriginalFilename();
        s3Client.getClientAWS(accessKeyId,accessSecKey).putObject(
                bucketName,
                fileName,
                convertMultipartFileToFile(multipartFile));


        return new BucketObject(fileName,bucketName);
 }

    private static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());
        outputStream.close();
        return file;
    }
}

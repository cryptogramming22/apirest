package com.cryptogramming.apirest.domain;

import lombok.Getter;

@Getter
public class BucketObject {

    private String fileName;
    private String bucket;

    public BucketObject(String fileName, String bucket) {
        this.fileName = fileName;
        this.bucket = bucket;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}

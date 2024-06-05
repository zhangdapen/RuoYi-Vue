package com.ruoyi.common.core.domain.entity;

/**
 * @author Grand
 * @Description
 * @since 2024/6/5
 */
public class UploadEntity {

    public UploadEntity(String bucket, String key) {
        this.bucket = bucket;
        this.key = key;
    }

    public UploadEntity() {
    }

    private String bucket;

    private String key;

    private String fileName;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

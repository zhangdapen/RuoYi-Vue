package com.ruoyi.system.domain.vo;

import com.ruoyi.common.core.domain.entity.UploadEntity;

public class UploadEntityVO extends UploadEntity {

    private String url;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

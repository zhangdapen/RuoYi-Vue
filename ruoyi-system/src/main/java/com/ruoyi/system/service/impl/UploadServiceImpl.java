package com.ruoyi.system.service.impl;

import com.ruoyi.common.config.MinioConfig;
import com.ruoyi.common.utils.minio.MinioUtils;
import com.ruoyi.common.core.domain.entity.UploadEntity;
import com.ruoyi.system.domain.vo.UploadEntityVO;
import com.ruoyi.system.service.UploadService;
import io.minio.ObjectWriteResponse;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidExpiresRangeException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Grand
 * @Description
 * @since 2024/6/5
 */
@Service
public class UploadServiceImpl implements UploadService {

    private MinioUtils minioUtils;

    private MinioConfig minioConfig;

    public UploadServiceImpl(MinioUtils minioUtils, MinioConfig minioConfig) {
        this.minioUtils = minioUtils;
        this.minioConfig = minioConfig;
    }

    @Override
    public UploadEntityVO upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidBucketNameException, InvalidExpiresRangeException {
        //文件名
        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
        //类型
        String contentType = file.getContentType();
        ObjectWriteResponse objectWriteResponse = minioUtils.uploadFile(
                minioConfig.getBucketName(),
                file,
                newFileName,
                contentType
        );
        String bucket = objectWriteResponse.bucket();
        String key = newFileName;
        UploadEntityVO uploadEntityVO = new UploadEntityVO();
        uploadEntityVO.setBucket(bucket);
        uploadEntityVO.setFileName(fileName);
        uploadEntityVO.setKey(newFileName);
        uploadEntityVO.setUrl(minioUtils.getPresignedObjectUrl(bucket, key));
        return uploadEntityVO;
    }
}

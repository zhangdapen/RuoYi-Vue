package com.ruoyi.system.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.dto.CoatingDataDTO;
import com.ruoyi.common.core.domain.entity.CoatingData;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.minio.MinioUtils;
import com.ruoyi.common.core.domain.entity.UploadEntity;
import com.ruoyi.system.mapper.CoatingDataMapper;
import com.ruoyi.system.service.ICoatingDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoatingDataServiceImpl implements ICoatingDataService {

    private static final Logger log = LoggerFactory.getLogger(CoatingDataServiceImpl.class);

    @Autowired
    private CoatingDataMapper coatingDataMapper;

    @Autowired
    private MinioUtils minioUtils;

    @Override
    public int insertCoatingData(CoatingDataDTO coatingDataDTO) throws JsonProcessingException {
        CoatingData coatingData = coatingDataDTO.toCoatingData();
        return coatingDataMapper.insertCoatingData(coatingData);
    }

    @Override
    public List<CoatingData> getCoatingDataList() {
        List<CoatingData> coatingData = coatingDataMapper.selectCoatingDataList();
        coatingData.forEach(this::generateImageUrl);
        return coatingData;
    }

    @Override
    public List<CoatingData> getCoatingDataByAirPlane(String airplane) {
        List<CoatingData> coatingData = coatingDataMapper.selectCoatingDataByAirPlane(airplane);
        coatingData.forEach(this::generateImageUrl);
        return coatingData;
    }

    private CoatingData generateImageUrl(CoatingData data) {
        String coatingImage = data.getCoatingImage();
        String coatingIdentifyImage = data.getCoatingIdentifyImage();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (!StringUtils.isEmpty(coatingImage)) {
                UploadEntity coatingImageUploadEntity = objectMapper.readValue(coatingImage, UploadEntity.class);
                data.setCoatingImage(minioUtils.getPresignedObjectUrl(coatingImageUploadEntity.getBucket(), coatingImageUploadEntity.getKey()));

            }
            if (!StringUtils.isEmpty(coatingIdentifyImage)) {
                UploadEntity coatingIdentifyImageUploadEntity = objectMapper.readValue(coatingIdentifyImage, UploadEntity.class);
                data.setCoatingIdentifyImage(minioUtils.getPresignedObjectUrl(coatingIdentifyImageUploadEntity.getBucket(), coatingIdentifyImageUploadEntity.getKey()));
            }
        } catch (Exception e) {
            log.error("解析图片出错", e);
        }
        return data;
    }

    @Override
    public CoatingData getCoatingData(Long id) {
        CoatingData coatingData = coatingDataMapper.selectById(id);
        return this.generateImageUrl(coatingData);
    }

    @Override
    public int updateCoatingData(CoatingDataDTO coatingDataDTO) throws JsonProcessingException {
        CoatingData coatingData = coatingDataDTO.toCoatingData();
        return coatingDataMapper.updateCoatingData(coatingData);
    }

    @Override
    public int deleteCoatingDataById(Long id) {
        return coatingDataMapper.deleteCoatingDataById(id);
    }

    @Override
    public int deleteCoatingDataByIds(Long[] ids) {
        return coatingDataMapper.deleteCoatingDataByIds(ids);
    }
}

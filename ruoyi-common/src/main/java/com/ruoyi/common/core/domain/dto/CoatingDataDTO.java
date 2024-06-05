package com.ruoyi.common.core.domain.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.CoatingData;
import com.ruoyi.common.core.domain.entity.UploadEntity;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 涂层数据
 * 
 * @author grand
 */
public class CoatingDataDTO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 飞机编号 */
    private String airplane;

    /** 涂层位置信息 */
    private String coatingLocation;

    /** 补光情况 */
    private String fillLightInfo;

    /** 文件存储位置 */
    private String coatingFileLocation;

    /** 涂层图像 */
    private UploadEntity coatingImage;

    /** 涂层识别结果图像 */
    private UploadEntity coatingIdentifyImage;

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getCoatingLocation() {
        return coatingLocation;
    }

    public void setCoatingLocation(String coatingLocation) {
        this.coatingLocation = coatingLocation;
    }

    public String getFillLightInfo() {
        return fillLightInfo;
    }

    public void setFillLightInfo(String fillLightInfo) {
        this.fillLightInfo = fillLightInfo;
    }

    public String getCoatingFileLocation() {
        return coatingFileLocation;
    }

    public void setCoatingFileLocation(String coatingFileLocation) {
        this.coatingFileLocation = coatingFileLocation;
    }

    public UploadEntity getCoatingImage() {
        return coatingImage;
    }

    public void setCoatingImage(UploadEntity coatingImage) {
        this.coatingImage = coatingImage;
    }

    public UploadEntity getCoatingIdentifyImage() {
        return coatingIdentifyImage;
    }

    public void setCoatingIdentifyImage(UploadEntity coatingIdentifyImage) {
        this.coatingIdentifyImage = coatingIdentifyImage;
    }

    public CoatingData toCoatingData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CoatingData data = new CoatingData();
        data.setAirplane(this.airplane);
        data.setCoatingLocation(this.coatingLocation);
        data.setFillLightInfo(this.fillLightInfo);
        data.setCoatingFileLocation(this.coatingFileLocation);
        if (ObjectUtils.isNotEmpty(this.coatingImage)) {
            data.setCoatingImage(objectMapper.writeValueAsString(this.coatingImage));
        }
        if (ObjectUtils.isNotEmpty(this.coatingIdentifyImage)) {
            data.setCoatingIdentifyImage(objectMapper.writeValueAsString(this.coatingIdentifyImage));
        }
        data.setCreateBy(getCreateBy());
        data.setUpdateBy(getUpdateBy());
        data.setUpdateTime(getUpdateTime());
        data.setCreateTime(getCreateTime());
        return data;
    }
}

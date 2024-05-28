package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 涂层数据
 * 
 * @author grand
 */
public class CoatingData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据id */
    private Long id;

    /** 飞机编号 */
    private String airplane;

    /** 涂层位置信息 */
    private String coatingLocation;

    /** 补光情况 */
    private String fillLightInfo;

    /** 文件存储位置 */
    private String coatingFileLocation;

    /** 涂层图像 */
    private String coatingImage;

    /** 涂层识别结果图像 */
    private String coatingIdentifyImage;

    /** 状态:1正常,0停用 */
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCoatingImage() {
        return coatingImage;
    }

    public void setCoatingImage(String coatingImage) {
        this.coatingImage = coatingImage;
    }

    public String getCoatingIdentifyImage() {
        return coatingIdentifyImage;
    }

    public void setCoatingIdentifyImage(String coatingIdentifyImage) {
        this.coatingIdentifyImage = coatingIdentifyImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

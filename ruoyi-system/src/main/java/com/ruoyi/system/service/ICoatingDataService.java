package com.ruoyi.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.core.domain.dto.CoatingDataDTO;
import com.ruoyi.common.core.domain.entity.CoatingData;

import java.util.List;

public interface ICoatingDataService {

    int insertCoatingData(CoatingDataDTO coatingData) throws JsonProcessingException;

    List<CoatingData> getCoatingDataList();

    CoatingData getCoatingData(Long id);


    int updateCoatingData(CoatingDataDTO coatingDataDTO) throws JsonProcessingException;

    int deleteCoatingDataById(Long id);

    int deleteCoatingDataByIds(Long[] ids);
}

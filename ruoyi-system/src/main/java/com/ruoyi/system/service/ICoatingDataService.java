package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.CoatingData;

import java.util.List;

public interface ICoatingDataService {

    int insertCoatingData(CoatingData coatingData);

    List<CoatingData> getCoatingDataList();

    CoatingData getCoatingData(Long id);


    int updateCoatingData(CoatingData coatingData);

    int deleteCoatingDataById(Long id);

    int deleteCoatingDataByIds(Long[] ids);
}

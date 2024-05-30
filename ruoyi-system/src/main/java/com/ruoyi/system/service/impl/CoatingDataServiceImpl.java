package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.CoatingData;
import com.ruoyi.system.mapper.CoatingDataMapper;
import com.ruoyi.system.service.ICoatingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoatingDataServiceImpl implements ICoatingDataService {

    @Autowired
    private CoatingDataMapper coatingDataMapper;

    @Override
    public int insertCoatingData(CoatingData coatingData) {
        return coatingDataMapper.insertCoatingData(coatingData);
    }

    @Override
    public List<CoatingData> getCoatingDataList() {
        return coatingDataMapper.selectCoatingDataList();
    }

    @Override
    public int updateCoatingData(CoatingData coatingData) {
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

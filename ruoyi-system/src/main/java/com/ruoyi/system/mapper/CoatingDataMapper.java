package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.CoatingData;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图层数据 数据层
 * 
 * @author ruoyi
 */
public interface CoatingDataMapper
{
    /**
     * 根据条件分页查询数据列表
     * 
     * @param coatingData 数据信息
     * @return 数据集合信息
     */
    List<CoatingData> seleselectCoatingDataListctCoatingDataList(CoatingData coatingData);
}

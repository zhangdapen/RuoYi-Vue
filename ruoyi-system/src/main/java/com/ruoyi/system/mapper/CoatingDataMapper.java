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
     * @return 数据集合信息
     */
    List<CoatingData> selectCoatingDataList();

    /**
     * 根据id查询数据
     * @return 数据详情
     */
    CoatingData selectById(Long id);


    /**
     * 新增涂层数据
     * @param coatingData 涂层数据
     * @return
     */
    int insertCoatingData(CoatingData coatingData);

    /**
     * 修改涂层数据
     * @param coatingData
     * @return
     */
    int updateCoatingData(CoatingData coatingData);


    /**
     * 根据id删除涂层数据
     * @param id
     * @return
     */
    int deleteCoatingDataById(Long id);

    /**
     * 批量删除涂层数据
     *
     * @param ids 涂层数据id列表
     * @return 结果
     */
     int deleteCoatingDataByIds(Long[] ids);
}

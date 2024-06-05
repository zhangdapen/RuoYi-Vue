package com.ruoyi.web.controller.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.dto.CoatingDataDTO;
import com.ruoyi.common.core.domain.entity.CoatingData;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.system.service.ICoatingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CoatingDataController extends BaseController {

    @Autowired
    private ICoatingDataService coatingDataService;

    /**
     * 获取用户列表
     */
    @PostMapping("/create")
    @Anonymous
    public AjaxResult create(@RequestBody CoatingDataDTO coatingData) {
        try {
            int i = coatingDataService.insertCoatingData(coatingData);
            if (i > 0) {
                return success("添加成功");
            }
            return error("添加失败，请重新尝试");
        } catch (JsonProcessingException e) {
            return error("添加失败，请重新尝试");
        }
    }

    @PostMapping("/update")
    @Anonymous
    public AjaxResult update(@RequestBody CoatingDataDTO coatingData) {
        try {
            int i = coatingDataService.updateCoatingData(coatingData);
            if (i > 0) {
                return success("更新成功");
            }
            return error("更新失败，请重新尝试");
        } catch (JsonProcessingException e) {
            return error("更新失败，请重新尝试");
        }
    }

    @GetMapping("/list")
    @Anonymous
    public TableDataInfo list() {
        startPage();
        List<CoatingData> coatingDataList = coatingDataService.getCoatingDataList();
        return getDataTable(coatingDataList);
    }

    @GetMapping("/data")
    @Anonymous
    public CoatingData selectOne() {
        Long id = Convert.toLong(ServletUtils.getParameter("id"));
        return coatingDataService.getCoatingData(id);
    }

    @GetMapping("/search")
    @Anonymous
    public TableDataInfo search() {
        String airplane = Convert.toStr(ServletUtils.getParameter("airplane"));
        List<CoatingData> coatingDataByAirPlane = coatingDataService.getCoatingDataByAirPlane(airplane);
        return getDataTable(coatingDataByAirPlane);
    }

    @GetMapping("/delete")
    @Anonymous
    public AjaxResult delete() {
        Long id = Convert.toLong(ServletUtils.getParameter("id"));
        int i = coatingDataService.deleteCoatingDataById(id);
        if (i > 0) {
            return success("删除成功");
        }
        return error("删除失败，请重新尝试");
    }
}

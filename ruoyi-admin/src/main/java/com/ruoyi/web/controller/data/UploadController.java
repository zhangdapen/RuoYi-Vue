package com.ruoyi.web.controller.data;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.UploadEntity;
import com.ruoyi.system.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Grand
 * @Description
 * @since 2024/6/5
 */
@RestController
public class UploadController extends BaseController {

    @Autowired
    private UploadService uploadService;

    /**
     * 文件上传
     *
     * @param file
     */
    @PostMapping("/upload")
    @Anonymous
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {
        try {
            UploadEntity upload = uploadService.upload(file);
            return success(upload);
        } catch (Exception e) {
            return success("上传失败，请重试");
        }
    }
}

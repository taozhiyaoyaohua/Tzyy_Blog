package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.services.UploadService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@Api(tags = "上传",description = "上传相关接口")
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    @SystemLog(businessName = "更新头像")
    public ResponseResultUtils upload(MultipartFile img){
        return uploadService.upload(img);
    }
}

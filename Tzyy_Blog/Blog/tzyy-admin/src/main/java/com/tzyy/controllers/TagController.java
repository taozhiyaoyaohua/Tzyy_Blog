package com.tzyy.controllers;

import com.tzyy.services.TagService;
import com.tzyy.tools.ResponseResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    TagService tagService;
    @GetMapping("/list")
    public ResponseResultUtils list(){
        return ResponseResultUtils.okResult(tagService.list());
    }
}

package com.tzyy.controllers;

import com.tzyy.annotation.SystemLog;
import com.tzyy.constants.SystemConstants;
import com.tzyy.pojo.Comment;
import com.tzyy.services.CommentService;
import com.tzyy.tools.ResponseResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "评论",description = "评论相关接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/commentList")
    @SystemLog(businessName = "获取评论列表")
    public ResponseResultUtils getCommentList(Long articleId,Integer pageNum,Integer pageSize){
        return commentService.getCommentList(SystemConstants.ARTICLE_COMMENT,articleId, pageNum, pageSize);
    }
    @PostMapping
    @SystemLog(businessName = "新增评论")
    public ResponseResultUtils addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
    @GetMapping("/linkCommentList")
    @SystemLog(businessName = "获取友链评论列表")
    public ResponseResultUtils linkCommentList(Integer pageNum,Integer pageSize){
        return commentService.getCommentList(SystemConstants.LINK_COMMENT,null,pageNum,pageSize);
    }
}

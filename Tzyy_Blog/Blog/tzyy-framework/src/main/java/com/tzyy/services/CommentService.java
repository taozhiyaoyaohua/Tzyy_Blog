package com.tzyy.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzyy.pojo.Comment;
import com.tzyy.tools.ResponseResultUtils;

/**
 * 评论表(Comment)表服务接口
 *
 * @author tzyy
 * @since 2022-10-21 21:26:06
 */
public interface CommentService extends IService<Comment> {

    ResponseResultUtils getCommentList(String type,Long articleId, Integer pageNum, Integer pageSize);

    ResponseResultUtils addComment(Comment comment);
}


package com.tzyy.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.constants.CommentConstants;
import com.tzyy.constants.SystemConstants;
import com.tzyy.enums.AppHttpCodeEnum;
import com.tzyy.exception.SystemException;
import com.tzyy.mappers.CommentMapper;
import com.tzyy.pojo.Article;
import com.tzyy.pojo.Comment;
import com.tzyy.services.CommentService;
import com.tzyy.services.UserService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.vo.CommentVo;
import com.tzyy.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author tzyy
 * @since 2022-10-21 21:26:06
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    UserService userService;
    @Override
    public ResponseResultUtils getCommentList(String type,Long articleId, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(type),Comment::getArticleId,articleId);
        lambdaQueryWrapper.eq(Comment::getType,type);
        lambdaQueryWrapper.eq(Comment::getRootId, CommentConstants.ROOT_COMMENT);
        Page<Comment> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);
        List<Comment> records = page.getRecords();
        List<CommentVo> commentVos = toCommentVoList(records);
        for (CommentVo commentVo : commentVos) {
            commentVo.setChildren(getChildren(commentVo.getId()));
        }
        return ResponseResultUtils.okResult(new PageVo(commentVos,page.getTotal()));
    }

    @Override
    public ResponseResultUtils addComment(Comment comment) {
        if(!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);
        return ResponseResultUtils.okResult();
    }

    private List<CommentVo> toCommentVoList(List<Comment> list){
        list.stream().map(new Function<Comment, Comment>() {
            @Override
            public Comment apply(Comment comment) {
                comment.setUsername(userService.getById(comment.getCreateBy()).getNickName());
                if(comment.getToCommentUserId()==-1){
                    comment.setToCommentUserName(null);
                }else{
                    comment.setToCommentUserName(userService.getById(comment.getToCommentUserId()).getNickName());
                }
                return comment;
            }
        }).collect(Collectors.toList());
        return BeanCopyUtils.copyBeanList(list, CommentVo.class);
    }
    private List<CommentVo> getChildren(Long id){
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getRootId,id);
        lambdaQueryWrapper.orderByAsc(Comment::getCreateTime);
        List<Comment> list = list(lambdaQueryWrapper);
        return toCommentVoList(list);
    }
}


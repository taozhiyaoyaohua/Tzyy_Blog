package com.tzyy.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 评论表(Comment)表实体类
 *
 * @author tzyy
 * @since 2022-10-21 21:26:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tzyy_comment")
@SuppressWarnings("serial")
public class Comment {
    @TableId
    
    private Long id;
    //评论类型（0代表文章评论，1代表友链评论）
    private String type;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    @TableField(exist = false)
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
    @TableField(exist = false)
    private String username;
}


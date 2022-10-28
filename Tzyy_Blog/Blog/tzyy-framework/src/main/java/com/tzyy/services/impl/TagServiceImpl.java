package com.tzyy.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.mappers.TagMapper;
import com.tzyy.pojo.Tag;
import com.tzyy.services.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签(Tag)表服务实现类
 *
 * @author tzyy
 * @since 2022-10-25 19:01:59
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}


package com.tzyy.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzyy.constants.SystemConstants;
import com.tzyy.mappers.LinkMapper;
import com.tzyy.pojo.Link;
import com.tzyy.services.LinkService;
import com.tzyy.tools.BeanCopyUtils;
import com.tzyy.tools.ResponseResultUtils;
import com.tzyy.vo.LinkVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author tzyy
 * @since 2022-10-20 14:34:57
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResultUtils getAllLink() {
        LambdaQueryWrapper<Link> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //正式发布的友链
        lambdaQueryWrapper.eq(Link::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Link> linkList = list(lambdaQueryWrapper);
        //封装成vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(linkList, LinkVo.class);
        return ResponseResultUtils.okResult(linkVos);
    }
}


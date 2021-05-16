package com.cdx.passjava.study.service.impl;

import cdx.common.utils.PageUtils;
import cdx.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cdx.passjava.study.dao.ViewLogDao;
import com.cdx.passjava.study.entity.ViewLogEntity;
import com.cdx.passjava.study.service.ViewLogService;


@Service("viewLogService")
public class ViewLogServiceImpl extends ServiceImpl<ViewLogDao, ViewLogEntity> implements ViewLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ViewLogEntity> page = this.page(
                new Query<ViewLogEntity>().getPage(params),
                new QueryWrapper<ViewLogEntity>()
        );

        return new PageUtils(page);
    }

}
package com.cdx.passjava.content.service;

import cdx.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.passjava.content.entity.NewsEntity;

import java.util.Map;

/**
 * 内容-资讯表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:14:50
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


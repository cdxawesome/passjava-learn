package com.cdx.passjava.content.service;

import cdx.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.passjava.content.entity.BannerEntity;

import java.util.Map;

/**
 * 内容-横幅广告表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:14:50
 */
public interface BannerService extends IService<BannerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


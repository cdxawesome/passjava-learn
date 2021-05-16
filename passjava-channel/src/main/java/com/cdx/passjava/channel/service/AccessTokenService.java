package com.cdx.passjava.channel.service;

import cdx.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.passjava.channel.entity.AccessTokenEntity;

import java.util.Map;

/**
 * 渠道-认证表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:09:29
 */
public interface AccessTokenService extends IService<AccessTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


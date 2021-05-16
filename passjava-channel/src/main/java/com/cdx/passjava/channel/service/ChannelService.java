package com.cdx.passjava.channel.service;

import cdx.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.passjava.channel.entity.ChannelEntity;

import java.util.Map;

/**
 * 渠道-渠道表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:09:29
 */
public interface ChannelService extends IService<ChannelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


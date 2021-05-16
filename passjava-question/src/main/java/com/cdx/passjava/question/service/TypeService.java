package com.cdx.passjava.question.service;

import cdx.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.passjava.question.entity.TypeEntity;

import java.util.Map;

/**
 * 题目-题目类型表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 16:52:01
 */
public interface TypeService extends IService<TypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


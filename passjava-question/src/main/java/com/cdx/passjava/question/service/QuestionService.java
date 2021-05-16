package com.cdx.passjava.question.service;

import cdx.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.passjava.question.entity.QuestionEntity;

import java.util.Map;

/**
 * 
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 16:52:01
 */
public interface QuestionService extends IService<QuestionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.cdx.passjava.question.dao;

import com.cdx.passjava.question.entity.TypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目-题目类型表
 * 
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 16:52:01
 */
@Mapper
public interface TypeDao extends BaseMapper<TypeEntity> {
	
}

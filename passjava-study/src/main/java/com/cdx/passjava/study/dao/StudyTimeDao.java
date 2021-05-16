package com.cdx.passjava.study.dao;

import com.cdx.passjava.study.entity.StudyTimeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学习-用户学习时常表
 * 
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:27:09
 */
@Mapper
public interface StudyTimeDao extends BaseMapper<StudyTimeEntity> {
	
}

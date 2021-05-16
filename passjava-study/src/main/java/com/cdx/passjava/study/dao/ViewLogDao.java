package com.cdx.passjava.study.dao;

import com.cdx.passjava.study.entity.ViewLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学习-用户学习浏览记录表
 * 
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:27:09
 */
@Mapper
public interface ViewLogDao extends BaseMapper<ViewLogEntity> {
	
}

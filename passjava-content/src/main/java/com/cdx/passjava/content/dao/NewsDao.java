package com.cdx.passjava.content.dao;

import com.cdx.passjava.content.entity.NewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 内容-资讯表
 * 
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:14:50
 */
@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {
	
}

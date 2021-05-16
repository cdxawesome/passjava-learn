package com.cdx.passjava.channel.dao;

import com.cdx.passjava.channel.entity.AccessTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道-认证表
 * 
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:09:29
 */
@Mapper
public interface AccessTokenDao extends BaseMapper<AccessTokenEntity> {
	
}

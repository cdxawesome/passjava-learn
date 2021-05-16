package com.cdx.passjava.member.dao;

import com.cdx.passjava.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员-会员表
 * 
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:22:06
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

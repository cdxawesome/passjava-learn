package com.cdx.passjava.channel.controller;

import java.util.Arrays;
import java.util.Map;

import cdx.common.utils.PageUtils;
import cdx.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdx.passjava.channel.entity.AccessTokenEntity;
import com.cdx.passjava.channel.service.AccessTokenService;



/**
 * 渠道-认证表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:09:29
 */
@RestController
@RequestMapping("channel/accesstoken")
public class AccessTokenController {
    @Autowired
    private AccessTokenService accessTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accessTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		AccessTokenEntity accessToken = accessTokenService.getById(id);

        return R.ok().put("accessToken", accessToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AccessTokenEntity accessToken){
		accessTokenService.save(accessToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AccessTokenEntity accessToken){
		accessTokenService.updateById(accessToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		accessTokenService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

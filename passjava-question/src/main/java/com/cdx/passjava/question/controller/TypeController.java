package com.cdx.passjava.question.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cdx.common.utils.Constant;
import cdx.common.utils.PageUtils;
import cdx.common.utils.R;
import cn.hutool.json.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdx.passjava.question.entity.TypeEntity;
import com.cdx.passjava.question.service.TypeService;


/**
 * 题目-题目类型表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 16:52:01
 */
@RestController
@RequestMapping("question/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = typeService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        TypeEntity type = typeService.getById(id);

        return R.ok().put("type", type);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TypeEntity type) {
        typeService.save(type);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TypeEntity type) {
        typeService.updateById(type);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        typeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /*
    以下的方法用于测试
    =====================================================================================
     */
    @RequestMapping("/list/test")
    public R getTypeEntityList() {
        // 初始化redis组件
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // 从缓存中读取数据
        String typeEntityListCache = ops.get("typeEntityList");
        if (StringUtils.isEmpty(typeEntityListCache)) {
            System.out.println("The cache is empty!");
            // 从数据库中查询数据
            Map<String,Object> params=new HashMap<>();
            params.put(Constant.PAGE,"1");
            params.put(Constant.LIMIT,"10");
            R list = this.list(params);
            // 将数据序列化成json字符串
            typeEntityListCache = JSONUtil.toJsonStr(list);
            // 将序列化后的数据存进redis
            ops.set("typeEntityList", typeEntityListCache);
            return list;
        }
        // 如果缓存中有数据，则将数据拿出来，并序列化成对象
        return JSONUtil.toBean(typeEntityListCache, R.class);
    }

}

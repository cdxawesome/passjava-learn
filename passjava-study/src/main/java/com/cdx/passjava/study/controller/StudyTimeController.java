package com.cdx.passjava.study.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import cdx.common.utils.PageUtils;
import cdx.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdx.passjava.study.entity.StudyTimeEntity;
import com.cdx.passjava.study.service.StudyTimeService;


/**
 * 学习-用户学习时常表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:27:09
 */
@RestController
@RequestMapping("study/studytime")
public class StudyTimeController {
    @Autowired
    private StudyTimeService studyTimeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = studyTimeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        StudyTimeEntity studyTime = studyTimeService.getById(id);

        return R.ok().put("studyTime", studyTime);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudyTimeEntity studyTime) {
        studyTimeService.save(studyTime);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StudyTimeEntity studyTime) {
        studyTimeService.updateById(studyTime);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        studyTimeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 测试openfeign的调用,下面这个方法将被member服务调用
     */
    @RequestMapping("/list/test/{id}")
    public R getStudyTimeListByIdTest(@PathVariable("id") Long id) {
        // 下面这里是创建一个测试数据
        StudyTimeEntity timeEntity = new StudyTimeEntity();
        timeEntity.setTotalTime(100);   // 设置学习时间为100分钟
        timeEntity.setQuesType(1L);     // 设置题目类型为id为1的类型
        // 将结果放进R中，且键设置为“studyTime”。调用方可以根据键获取值
        return R.ok().put("studyTime", Collections.singletonList(timeEntity));  // 返回一个List类型的值
    }

}

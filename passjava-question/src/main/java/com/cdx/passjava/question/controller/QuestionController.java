package com.cdx.passjava.question.controller;

import java.util.Arrays;
import java.util.Map;

import cdx.common.to.es.QuestionEsModel;
import cdx.common.utils.PageUtils;
import cdx.common.utils.R;
import com.cdx.passjava.question.entity.TypeEntity;
import com.cdx.passjava.question.feign.SearchFeignService;
import com.cdx.passjava.question.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cdx.passjava.question.entity.QuestionEntity;
import com.cdx.passjava.question.service.QuestionService;

import javax.validation.Valid;

/**
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 16:52:01
 */
@RestController
@RequestMapping("/question/v1/admin/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private SearchFeignService searchFeignService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = questionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        QuestionEntity question = questionService.getById(id);

        return R.ok().put("question", question);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuestionEntity question) {
        questionService.save(question);
        this.saveEs(question);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QuestionEntity question) {
        questionService.updateById(question);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        questionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    private boolean saveEs(QuestionEntity question) {
        try {
            // 1.创建ES model
            QuestionEsModel esModel = new QuestionEsModel();
            // 2.复制属性
            BeanUtils.copyProperties(question, esModel);
            // 3.获取题目类型名称，赋值给esModel(因为QuestionEntity中只有题目类型id，没有题目类型)
            TypeEntity typeEntity = typeService.getById(question.getType());
            esModel.setTypeName(typeEntity.getType());
            // 4.调用search微服务保存数据到es中
            return searchFeignService.esSave(esModel);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /*
    下面的方法用于测试
    =====================================================================================
     */
    @RequestMapping("/testSave")
    public R testSave(@Valid @RequestBody QuestionEntity question) {
        System.out.println(question.getDisplayOrder());
        questionService.save(question);

        return R.ok();
    }



}

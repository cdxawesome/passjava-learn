package com.cdx.passjava.member.controller;

import java.util.Arrays;
import java.util.Map;

import cdx.common.utils.PageUtils;
import cdx.common.utils.R;
import com.cdx.passjava.member.service.TestOpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdx.passjava.member.entity.MemberEntity;
import com.cdx.passjava.member.service.MemberService;


/**
 * 会员-会员表
 *
 * @author cdx
 * @email hoktextbox@aliyun.com
 * @date 2021-05-11 17:22:06
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TestOpenFeignService testOpenFeignService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member) {
        memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member) {
        memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 测试OpenFeign的调用，下面这个方法将调用study服务的方法
     */
    @RequestMapping("/studyTime/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(id);
        memberEntity.setNickname("面条大师");
        // 获取到学习时间
        R memberStudyTimeListTest = testOpenFeignService.getMemberStudyTimeListTest(id);
        // 将该会员的信息和学习时间的数据放进R中返回
        return R.ok().put("member", memberEntity).put("studyTime", memberStudyTimeListTest.get("studyTime"));
    }

}

package com.cdx.passjava.member.service;

import cdx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("passjava-study")
public interface TestOpenFeignService {

    @RequestMapping("study/studytime/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id);
}

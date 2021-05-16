package com.cdx.passjava.question.feign;

import cdx.common.to.es.QuestionEsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("passjava-search")
public interface SearchFeignService {

    @RequestMapping("/search/esSave")
    public boolean esSave(@RequestBody QuestionEsModel questionEsModel);
}

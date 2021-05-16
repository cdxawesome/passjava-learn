package com.cdx.passjavasearch.controller;

import com.cdx.passjavasearch.service.EsQuestionSearchService;
import com.cdx.passjavasearch.vo.SearchParam;
import com.cdx.passjavasearch.vo.SearchQuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/search")
@RestController
public class EsQuestionSearchController {

    @Autowired
    EsQuestionSearchService questionSearchService;

    @PostMapping("/question/list")
    public SearchQuestionResponse list(SearchParam param) {
        System.out.println(param);
        return questionSearchService.search(param);
    }
}

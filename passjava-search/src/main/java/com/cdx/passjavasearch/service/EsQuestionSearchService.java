package com.cdx.passjavasearch.service;


import com.cdx.passjavasearch.vo.SearchParam;
import com.cdx.passjavasearch.vo.SearchQuestionResponse;

public interface EsQuestionSearchService {

    SearchQuestionResponse search(SearchParam param);
}

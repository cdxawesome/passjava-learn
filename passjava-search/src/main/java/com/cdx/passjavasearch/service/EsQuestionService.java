package com.cdx.passjavasearch.service;


import cdx.common.to.es.QuestionEsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


public interface EsQuestionService {

    @RequestMapping()
    public boolean saveEs(QuestionEsModel questionEsModel) throws IOException;
}

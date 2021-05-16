package com.cdx.passjavasearch.controller;

import cdx.common.to.es.QuestionEsModel;
import com.cdx.passjavasearch.service.EsQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/search")
public class EsQuestionController {
    @Autowired
    EsQuestionService esQuestionService;

    @RequestMapping("/esSave")
    public boolean esSave(@RequestBody QuestionEsModel questionEsModel) throws IOException {
        return esQuestionService.saveEs(questionEsModel);
    }
}

package com.cdx.passjavasearch.service.impl;

import cdx.common.to.es.QuestionEsModel;
import cn.hutool.json.JSONUtil;
import com.cdx.passjavasearch.config.EsConstant;
import com.cdx.passjavasearch.service.EsQuestionService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EsQuestionServiceImpl implements EsQuestionService {

    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean saveEs(QuestionEsModel questionEsModel) throws IOException {
        // 创建数据保存到es中
        IndexRequest indexRequest=new IndexRequest(EsConstant.QUESTION_INDEX);
        indexRequest.id(questionEsModel.getId().toString());
        indexRequest.source(JSONUtil.toJsonStr(questionEsModel), XContentType.JSON);
        IndexResponse response=client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
        return true;
    }
}

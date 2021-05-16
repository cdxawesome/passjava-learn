package com.cdx.passjavaquestion;

import com.aliyun.oss.OSSClient;
import com.cdx.passjava.question.entity.TypeEntity;
import com.cdx.passjava.question.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

@SpringBootTest
class PassjavaQuestionApplicationTests {

    @Autowired
    TypeService typeService;

    @Autowired
    OSSClient ossClient;

    // 创建题目类型
    @Test
    void testCreateType() {
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setType("javaBasic");
        typeService.save(typeEntity);
        System.out.println("创建成功");
    }

    /**
     * 测试阿里云OSS的文件上传
     */
    @Test
    void testUploadByAliCloudOSS() throws FileNotFoundException {
        String bucketName="cdx-passjava";
        String localFile="D:\\wallpaper\\4yyll4.jpg";
        String fileKeyName="4yyll4.jpg";
        InputStream inputStream=new FileInputStream(localFile);
        ossClient.putObject(bucketName,fileKeyName,inputStream);
        ossClient.shutdown();
    }

    @Test
    public void testTime()
    {
        System.out.println(new Date());
    }
}

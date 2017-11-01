package com.zzsong.study.orange.user.web.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.zzsong.study.orange.user.web.service.FileService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 七牛文件存储服务
 * Created by zzsong on 2017/11/1.
 */
public class QiNiuFileService implements FileService {
    private final QiniuConfig qiniuConfig;

    public QiNiuFileService(QiniuConfig qiniuConfig) {
        this.qiniuConfig = qiniuConfig;
    }

    public String uploadHeadPortrait(byte[] uploadBytes, String fileName) {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
        String upToken = auth.uploadToken(qiniuConfig.getBucket(), fileName);
        try {
            Response response = uploadManager.put(uploadBytes, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return qiniuConfig.getDomain() + fileName + "?" + qiniuConfig.getModel();
    }

    @Getter
    @Setter
    @Component
    @RefreshScope
    @ConfigurationProperties(prefix = "qiniu")
    public static class QiniuConfig {
        private String accessKey;
        private String secretKey;
        private String domain;
        private String bucket;
        private String model;
    }
}

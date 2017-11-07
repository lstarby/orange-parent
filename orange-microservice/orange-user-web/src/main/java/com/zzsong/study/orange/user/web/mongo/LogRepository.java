package com.zzsong.study.orange.user.web.mongo;


import com.zzsong.study.orange.user.web.pojo.LogObject;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zzsong on 2017/10/26.
 */
public interface LogRepository extends MongoRepository<LogObject.OrangeLog, String> {
}

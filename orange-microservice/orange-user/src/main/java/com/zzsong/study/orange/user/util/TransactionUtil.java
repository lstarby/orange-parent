package com.zzsong.study.orange.user.util;

import org.apache.log4j.Logger;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by zzsong on 2017/9/20.
 */
public class TransactionUtil {
    private static Logger logger = Logger.getLogger(TransactionUtil.class);

    private TransactionUtil() {
    }

    /**
     * 手动回滚事务
     */
    public static void rollback() {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        logger.debug("已手动回滚事务");
    }


}
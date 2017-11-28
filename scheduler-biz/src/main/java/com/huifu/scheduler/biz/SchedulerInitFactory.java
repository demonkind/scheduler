/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.huifu.scheduler.service.core.SchedulerRecord;
import com.huifu.scheduler.service.repo.SchedulerRecordRepository;

/**
 * 用来创建和初始化调度任务的工厂
 * @author su.zhang
 * @version $Id$
 */
public class SchedulerInitFactory {

    protected static final Log        logger = LogFactory.getLog(SchedulerInitFactory.class);
    @Autowired
    private SchedulerManager          schedulerManager;
    @Autowired
    private SchedulerRecordRepository schedulerRecordRepository;

    /**
     */
    public void init() throws ConfigurationException, IOException {
        try {
            List<SchedulerRecord> records = schedulerRecordRepository.listAllSchedulerRecords(null,
                null);
            for (SchedulerRecord record : records) {
                if (schedulerManager.STATUS_ON.equals(record.getStatus())) {
                    schedulerManager.addScheduler(record.getSystemName(), record.getTaskName(),
                        record.getCronExp());
                }

            }
            logger.info("初始化SchedulerInitFactory工厂成功...");
        } catch (Exception e) {
            logger.error("加载SchedulerInitFactory报错.", e);
        }
    }

}

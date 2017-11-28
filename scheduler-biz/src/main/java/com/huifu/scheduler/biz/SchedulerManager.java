/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.huifu.scheduler.service.core.SchedulerRecord;
import com.huifu.scheduler.service.repo.SchedulerRecordRepository;

/**
 * @author su.zhang
 * @version $Id: SchedulerAddManager.java, v 0.1 2012-8-27 下午04:29:13 su.zhang Exp $
 */
@Service("schedulerManager")
public class SchedulerManager {
    private static final Log logger = LogFactory.getLog(SchedulerManager.class);
    
    public static final String       STATUS_ON  = "on";
    public static final String       STATUS_OFF = "off";
    @Autowired
    private SaturnSchedulerFactory    saturnSchedulerFactory;
    @Autowired
    private SchedulerRecordRepository schedulerRecordRepository;

    @Autowired
    TransactionTemplate               transactionTemplate;
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addScheduler(final String systemName, final String taskName, final String cronExp) {

        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                SchedulerRecord schedulerRecord = schedulerRecordRepository
                    .getSchedulerRecordByIndex(systemName, taskName);
                if (schedulerRecord == null) {
                    SchedulerRecord sr = new SchedulerRecord();
                    sr.setCronExp(cronExp);
                    sr.setStatus(STATUS_ON);
                    sr.setSystemName(systemName);
                    sr.setTaskName(taskName);
                    schedulerRecordRepository.insert(sr);
                } else {
                    schedulerRecordRepository.updateSchedulerStatusRecordByIndex(systemName,
                        taskName,cronExp, STATUS_ON);
                }
                saturnSchedulerFactory.addScheduler(constructSchedulerName(systemName, taskName),
                    cronExp);
                return null;
            }
        });

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void passiveScheduler(final String systemName, final String taskName) {

        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                SchedulerRecord schedulerRecord = schedulerRecordRepository
                    .getSchedulerRecordByIndex(systemName, taskName);
                if (schedulerRecord == null) {
                    return null;
                } else {
                    schedulerRecordRepository.updateSchedulerStatusRecordByIndex(systemName,
                        taskName,null, STATUS_OFF);
                }
                saturnSchedulerFactory.delScheduler(constructSchedulerName(systemName, taskName));
                return null;
            }
        });
    }

    private String constructSchedulerName(String systemName, String taskName) {
        return "TP_SC_" + systemName + "_" + taskName;
    }

    /**
     * Setter method for property <tt>saturnSchedulerFactory</tt>.
     * 
     * @param saturnSchedulerFactory value to be assigned to property saturnSchedulerFactory
     */
    public void setSaturnSchedulerFactory(SaturnSchedulerFactory saturnSchedulerFactory) {
        this.saturnSchedulerFactory = saturnSchedulerFactory;
    }

    /**
     * Getter method for property <tt>saturnSchedulerFactory</tt>.
     * 
     * @return property value of saturnSchedulerFactory
     */
    public SaturnSchedulerFactory getSaturnSchedulerFactory() {
        return saturnSchedulerFactory;
    }

    /**
     * Setter method for property <tt>schedulerRecordRepository</tt>.
     * 
     * @param schedulerRecordRepository value to be assigned to property schedulerRecordRepository
     */
    public void setSchedulerRecordRepository(SchedulerRecordRepository schedulerRecordRepository) {
        this.schedulerRecordRepository = schedulerRecordRepository;
    }

    /**
     * Getter method for property <tt>schedulerRecordRepository</tt>.
     * 
     * @return property value of schedulerRecordRepository
     */
    public SchedulerRecordRepository getSchedulerRecordRepository() {
        return schedulerRecordRepository;
    }

}

/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.huifu.saturn.runtime.mq.listener.SaturnMessageListener;
import com.huifu.scheduler.service.core.SchedulerRecord;

/**
 * 
 * @author su.zhang
 * @version $Id: SchedulerMessageListener.java, v 0.1 2012-8-27 下午07:41:13 su.zhang Exp $
 */
public class SchedulerMessageListener extends SaturnMessageListener {
    @Autowired
    private SchedulerManager schedulerManager;
    /** 
     * @see com.chinapnr.saturn.runtime.mq.listener.SaturnMessageListener#handleMessage(java.lang.Object)
     */
    @Override
    protected void handleMessage(Object obj) {
        SchedulerRecord sr= (SchedulerRecord)obj;
        if(SchedulerManager.STATUS_ON.equals(sr.getStatus())){
            schedulerManager.addScheduler(sr.getSystemName(), sr.getTaskName(), sr.getCronExp());
        }else if(SchedulerManager.STATUS_OFF.equals(sr.getStatus())){
            schedulerManager.passiveScheduler(sr.getSystemName(), sr.getTaskName());
        }
       
    }
        /**
         * Setter method for property <tt>schedulerManager</tt>.
         * 
         * @param schedulerManager value to be assigned to property schedulerManager
         */
    public void setSchedulerManager(SchedulerManager schedulerManager) {
        this.schedulerManager = schedulerManager;
    }
        /**
         * Getter method for property <tt>schedulerManager</tt>.
         * 
         * @return property value of schedulerManager
         */
    public SchedulerManager getSchedulerManager() {
        return schedulerManager;
    }

}

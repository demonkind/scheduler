/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huifu.saturn.runtime.mq.sender.MessageSender;
import com.huifu.scheduler.service.core.SchedulerRecord;

/**
 * 
 * @author su.zhang
 * @version $Id: SchedulerMessageSender.java, v 0.1 2012-8-27 下午07:48:26 su.zhang Exp $
 */
@Service("schedulerMessageSender")
public class SchedulerMessageSender {
    
    public static final String SCHEDULER_TOPIC="TP_SC_SCHEDULER";
    
    @Autowired
    private MessageSender messageSender;
    
    public void sendSchedulerMessage(String systemName,String taskName,String status,String cronExp){
        SchedulerRecord sr = new SchedulerRecord();
        sr.setCronExp(cronExp);
        sr.setStatus(status);
        sr.setSystemName(systemName);
        sr.setTaskName(taskName);
        messageSender.send(SCHEDULER_TOPIC, sr);
    }

}

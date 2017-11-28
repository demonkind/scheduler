/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huifu.saturn.runtime.mq.sender.MessageSender;

/**
 * 
 * @author su.zhang
 * @version $Id: MessageSendJob.java, v 0.1 2012-8-28 上午10:55:10 su.zhang Exp $
 */
public class MessageSendJob implements Job {
    private static final Log logger = LogFactory.getLog(MessageSendJob.class);
    
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        
        MessageSender messageSender= (MessageSender)jobExecutionContext.getJobDetail().getJobDataMap().get("messageSender");
        messageSender.send(jobExecutionContext.getJobDetail().getName(), jobExecutionContext.getJobDetail().getName());
        logger.info(new Date() + "给topic="
            + jobExecutionContext.getJobDetail().getName() + "发送调度消息...");
       
    }
}

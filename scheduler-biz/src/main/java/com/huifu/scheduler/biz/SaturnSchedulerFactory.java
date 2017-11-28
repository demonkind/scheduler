/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import java.text.ParseException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huifu.saturn.runtime.mq.sender.MessageSender;

/**
 * 调度框架工厂类
 * @author su.zhang
 * @version $Id: SaturnSchedulerFactory.java, v 0.1 2012-8-27 下午03:42:03 su.zhang Exp $
 */
@Service("saturnSchedulerFactory")
public class SaturnSchedulerFactory {
    private static final Log logger = LogFactory.getLog(SaturnSchedulerFactory.class);

    private static Scheduler scheduler;

    @Autowired
    private MessageSender messageSender;
    
    private Scheduler getScheduler() {
        if (scheduler == null) {
            SchedulerFactory sf = new StdSchedulerFactory();
            try {
                scheduler = sf.getScheduler();
                scheduler.start();
                logger.info("调度框架启动成功！");
            } catch (SchedulerException e) {
                logger.error("调度框架启动失败", e);
            }
        }

        return scheduler;
    }

    public void addScheduler(String schedulerName, String cronExp) {
        try {
            getScheduler().deleteJob(schedulerName, schedulerName);

            JobDetail jobDetail = new JobDetail();
            jobDetail.setJobClass(MessageSendJob.class);
            jobDetail.setName(schedulerName);
            jobDetail.setGroup(schedulerName);
            
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("messageSender", messageSender);
            jobDetail.setJobDataMap(jobDataMap);

            CronTrigger cronTrigger = null;
            try {
                cronTrigger = new CronTrigger(schedulerName, schedulerName, cronExp);
            } catch (ParseException e) {
                logger.error(schedulerName + "表达式错误", e);
            }
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            logger.error("添加调度任务出错", e);
        }
        logger.info("添加调度任务"+schedulerName+"成功，cron="+cronExp);
    }

    public void delScheduler(String schedulerName) {
        try {
            getScheduler().deleteJob(schedulerName, schedulerName);

        } catch (SchedulerException e) {
            logger.error("删除调度任务出错", e);
        }
    }


}

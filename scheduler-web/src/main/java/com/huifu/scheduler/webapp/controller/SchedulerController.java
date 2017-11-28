/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huifu.scheduler.biz.SchedulerManager;
import com.huifu.scheduler.biz.SchedulerMessageSender;
import com.huifu.scheduler.service.core.SchedulerRecord;
import com.huifu.scheduler.service.repo.SchedulerRecordRepository;

/**
 * @author su.zhang
 * @version $Id: SchedulerController.java, v 0.1 2012-8-27 下午08:00:52 su.zhang Exp $
 */
@Controller
public class SchedulerController {
    @Autowired
    private SchedulerMessageSender    schedulerMessageSender;
    @Autowired
    private SchedulerRecordRepository schedulerRecordRepository;

    @RequestMapping("/schedulerAdd")
    public String addScheduler(ModelMap model, SchedulerRecord schedulerRecord ,BindingResult result) {
        if("off".equals(schedulerRecord.getStatus())){ 
            schedulerMessageSender
            .sendSchedulerMessage(schedulerRecord.getSystemName(), schedulerRecord.getTaskName(),
                SchedulerManager.STATUS_OFF, schedulerRecord.getCronExp());
        }else{
        schedulerMessageSender
            .sendSchedulerMessage(schedulerRecord.getSystemName(), schedulerRecord.getTaskName(),
                SchedulerManager.STATUS_ON, schedulerRecord.getCronExp());
        
        }

        return "redirect:schedulerList";
    }

    @RequestMapping("/schedulerList")
    public String listSchedulers(ModelMap model,String systemName,String taskName) {
        if("".equals(systemName)){
            systemName=null;
        }
        if("".equals(taskName)){
            taskName=null;
        }
        List<SchedulerRecord> schedulerList = schedulerRecordRepository.listAllSchedulerRecords(systemName,taskName);
        model.put("schedulerList", schedulerList);
        return "schedulerList";
    }

    @RequestMapping("schedulerStop")
    public String stopScheduler(ModelMap model, SchedulerRecord schedulerRecord) {
        schedulerMessageSender.sendSchedulerMessage(schedulerRecord.getSystemName(),
            schedulerRecord.getTaskName(), SchedulerManager.STATUS_OFF,
            schedulerRecord.getCronExp());

        return "redirect:/schedulerList";
    }

    /**
     * Setter method for property <tt>schedulerMessageSender</tt>.
     * 
     * @param schedulerMessageSender value to be assigned to property schedulerMessageSender
     */
    public void setSchedulerMessageSender(SchedulerMessageSender schedulerMessageSender) {
        this.schedulerMessageSender = schedulerMessageSender;
    }

    /**
     * Getter method for property <tt>schedulerMessageSender</tt>.
     * 
     * @return property value of schedulerMessageSender
     */
    public SchedulerMessageSender getSchedulerMessageSender() {
        return schedulerMessageSender;
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

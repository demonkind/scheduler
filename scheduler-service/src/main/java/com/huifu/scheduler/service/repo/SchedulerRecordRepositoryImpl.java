/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.service.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huifu.scheduler.common.dal.dao.SchedulerRecordMapper;
import com.huifu.scheduler.common.dal.model.SchedulerRecordDO;
import com.huifu.scheduler.service.convert.SchedulerRecordConverter;
import com.huifu.scheduler.service.core.SchedulerRecord;

/**
 * 
 * @author su.zhang
 * @version $Id: SchedulerRecordRepositoryImpl.java, v 0.1 2012-8-27 下午05:34:12 su.zhang Exp $
 */
@Service("schedulerRecordRepository")
public class SchedulerRecordRepositoryImpl implements SchedulerRecordRepository {
    @Autowired
    private SchedulerRecordMapper schedulerRecordMapper;

    /** 
     * @see com.huifu.scheduler.service.repo.SchedulerRecordRepository#insert(com.huifu.scheduler.service.core.SchedulerRecord)
     */
    @Override
    public void insert(SchedulerRecord schedulerRecord) {
        schedulerRecordMapper.insert(SchedulerRecordConverter
            .convertSchedulerRecord(schedulerRecord));
    }

    /** 
     * @see com.huifu.scheduler.service.repo.SchedulerRecordRepository#getSchedulerRecordByIndex(java.util.Map)
     */
    @Override
    public SchedulerRecord getSchedulerRecordByIndex(String systemName, String taskName) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systemName", systemName);
        param.put("taskName", taskName);
        return SchedulerRecordConverter.convertSchedulerRecordDO(schedulerRecordMapper
            .getSchedulerRecordByIndex(param));
    }

    /** 
     * @see com.huifu.scheduler.service.repo.SchedulerRecordRepository#updateSchedulerRecordByIndex(java.util.Map)
     */
    @Override
    public void updateSchedulerStatusRecordByIndex(String systemName, String taskName,String cronExp,String status) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systemName", systemName);
        param.put("taskName", taskName);
        param.put("cronExp", cronExp);
        param.put("status", status);
        schedulerRecordMapper.updateSchedulerRecordByIndex(param);
    }
    
    public List<SchedulerRecord> listAllSchedulerRecords(String systemName,String taskName){
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systemName", systemName);
        param.put("taskName", taskName);
        List list =schedulerRecordMapper.listAllSchedulerRecords(param);
        List<SchedulerRecord> targetList = new ArrayList<SchedulerRecord>();
        for(Object o:list){
            SchedulerRecordDO sr =(SchedulerRecordDO)o;
            targetList.add(SchedulerRecordConverter.convertSchedulerRecordDO(sr)); 
        }
        return targetList;
    }

    /**
     * Setter method for property <tt>schedulerRecordMapper</tt>.
     * 
     * @param schedulerRecordMapper value to be assigned to property schedulerRecordMapper
     */
    public void setSchedulerRecordMapper(SchedulerRecordMapper schedulerRecordMapper) {
        this.schedulerRecordMapper = schedulerRecordMapper;
    }

    /**
     * Getter method for property <tt>schedulerRecordMapper</tt>.
     * 
     * @return property value of schedulerRecordMapper
     */
    public SchedulerRecordMapper getSchedulerRecordMapper() {
        return schedulerRecordMapper;
    }

}

/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.service.repo;

import java.util.List;

import com.huifu.scheduler.service.core.SchedulerRecord;

/**
 * 
 * @author su.zhang
 * @version $Id: SchedulerRecordRepo.java, v 0.1 2012-8-27 下午05:31:04 su.zhang Exp $
 */
public interface SchedulerRecordRepository {

    public void insert(SchedulerRecord schedulerRecord);

    public SchedulerRecord getSchedulerRecordByIndex(String systemName,String taskName);

    public void updateSchedulerStatusRecordByIndex(String systemName,String taskName,String cronExp,String status);
    
    public List<SchedulerRecord> listAllSchedulerRecords(String systemName,String taskName);
}

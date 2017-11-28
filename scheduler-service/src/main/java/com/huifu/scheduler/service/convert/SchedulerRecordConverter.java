/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.service.convert;

import org.springframework.beans.BeanUtils;

import com.huifu.scheduler.common.dal.model.SchedulerRecordDO;
import com.huifu.scheduler.service.core.SchedulerRecord;

/**
 * 
 * @author su.zhang
 * @version $Id: SchedulerRecordConverter.java, v 0.1 2012-8-27 下午05:36:59 su.zhang Exp $
 */
public class SchedulerRecordConverter {

    public static SchedulerRecord convertSchedulerRecordDO(SchedulerRecordDO schedulerRecordDO) {
        if(schedulerRecordDO ==null){
            return null;
        }
        SchedulerRecord schedulerRecord = new SchedulerRecord();
        BeanUtils.copyProperties(schedulerRecordDO, schedulerRecord);
        return schedulerRecord;
    }

    public static SchedulerRecordDO convertSchedulerRecord(SchedulerRecord schedulerRecord) {
        if(schedulerRecord ==null){
            return null;
        }
        SchedulerRecordDO schedulerRecordDO = new SchedulerRecordDO();
        BeanUtils.copyProperties(schedulerRecord, schedulerRecordDO);
        return schedulerRecordDO;
    }

}

/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.common.dal.dao;

import java.util.List;
import java.util.Map;

import com.huifu.scheduler.common.dal.model.SchedulerRecordDO;

public interface SchedulerRecordMapper {

    public void insert(SchedulerRecordDO schedulerRecord);

    public SchedulerRecordDO getSchedulerRecordByIndex(Map<String, Object> param);

    public void updateSchedulerRecordByIndex(Map<String, Object> param);
    
    public List listAllSchedulerRecords(Map<String, Object> param);

}

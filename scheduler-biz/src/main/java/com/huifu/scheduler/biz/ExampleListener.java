/**
 * 汇付天下有限公司
 * Copyright (c) 2006-2012 ChinaPnR,Inc.All Rights Reserved.
 */
package com.huifu.scheduler.biz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huifu.saturn.runtime.mq.listener.SaturnMessageListener;

public class ExampleListener extends SaturnMessageListener {
    private final Log log = LogFactory.getLog("SATURN-TEST-LOG");

    /** 
     * @see com.chinapnr.saturn.runtime.mq.listener.SaturnMessageListener#handleMessage(java.lang.Object)
     */
    @Override
    protected void handleMessage(Object o) {
        log.info("example收到消息啦："+o.toString());
    }
}
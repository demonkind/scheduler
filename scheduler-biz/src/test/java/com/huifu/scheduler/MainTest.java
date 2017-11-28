/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler;

import com.huifu.scheduler.biz.SaturnSchedulerFactory;

/**
 * 
 * @author Administrator
 * @version $Id: MainTest.java, v 0.1 2012-8-28 上午10:36:38 Administrator Exp $
 */
public class MainTest {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        SaturnSchedulerFactory s = new SaturnSchedulerFactory();
        s.addScheduler("saf", "0/4 * * * * ?");
        System.out.println("end "); 
    }

}

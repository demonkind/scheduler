/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.service.core;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author su.zhang
 * @version $Id: SchedulerRecord.java, v 0.1 2012-8-27 下午04:30:59 su.zhang Exp $
 */
public class SchedulerRecord implements Serializable {

    /**  */
    private static final long serialVersionUID = -5815688713547303721L;

    private String            systemName;
    private String            taskName;
    private String            cronExp;
    //on 表示开启 off表示关闭
    private String            status;

    private Date              modifiedTime;
    private Date              createTime;

    /**
     * Getter method for property <tt>systemName</tt>.
     * 
     * @return property value of systemName
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * Setter method for property <tt>systemName</tt>.
     * 
     * @param systemName value to be assigned to property systemName
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * Getter method for property <tt>taskName</tt>.
     * 
     * @return property value of taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Setter method for property <tt>taskName</tt>.
     * 
     * @param taskName value to be assigned to property taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Getter method for property <tt>cronExp</tt>.
     * 
     * @return property value of cronExp
     */
    public String getCronExp() {
        return cronExp;
    }

    /**
     * Setter method for property <tt>cronExp</tt>.
     * 
     * @param cronExp value to be assigned to property cronExp
     */
    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>modifiedTime</tt>.
     * 
     * @return property value of modifiedTime
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * Setter method for property <tt>modifiedTime</tt>.
     * 
     * @param modifiedTime value to be assigned to property modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * Getter method for property <tt>createTime</tt>.
     * 
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     * 
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

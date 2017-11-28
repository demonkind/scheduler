/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.webapp.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.StringUtil;

/**
 * @author bruce.zhang
 * @version $Id: SaturnConfig.java, v 0.1 2012-8-9 下午03:42:59 Administrator Exp $
 */
public class SaturnConfig implements TemplateMethodModel {

    private Set<String> param;
    private Map<String,String> map = new HashMap<String,String>();;

    /** 
     * @see freemarker.template.TemplateMethodModel#exec(java.util.List)
     */
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (arguments == null || arguments.isEmpty()) {
            throw new RuntimeException("缺少saturn config key值");
        }
        return map.get(arguments.get(0));
    }

    /**
     * Getter method for property <tt>param</tt>.
     * 
     * @return property value of param
     */
    public Set<String> getParam() {
        return param;
    }

    /**
     * Setter method for property <tt>param</tt>.
     * 
     * @param param value to be assigned to property param
     */
    public void setParam(Set<String> param) {
        this.param = param;
        if(param!=null && !param.isEmpty()){
            for(String s:param){
               String[] arr = StringUtil.split(s, '^');
                map.put(arr[0], arr[1]);
            }
        }
    }

    /**
     * Getter method for property <tt>map</tt>.
     * 
     * @return property value of map
     */
    public Map<String, String> getMap() {
        return map;
    }

    /**
     * Setter method for property <tt>map</tt>.
     * 
     * @param map value to be assigned to property map
     */
    public void setMap(Map<String, String> map) {
        this.map = map;
    }


}

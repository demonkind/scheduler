/**
 * Chinapnr.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.huifu.scheduler.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author su.zhang
 * @version $Id: SchedulerController.java, v 0.1 2012-8-27 下午08:00:52 su.zhang Exp $
 */
@Controller
public class DemoController {

    @RequestMapping("ajax")
    @ResponseBody
    public String listSchedulers(ModelMap model,HttpSession session,HttpServletRequest request) {
        //new Your object or list and so on
        return "yourObject";
        
    }

}

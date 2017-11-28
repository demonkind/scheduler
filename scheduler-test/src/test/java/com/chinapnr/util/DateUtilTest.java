package com.chinapnr.util;

import java.text.ParseException;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtilTest extends TestCase {
    //~ Instance fields ========================================================

    private final Log log = LogFactory.getLog(DateUtilTest.class);

    //~ Constructors ===========================================================

    public DateUtilTest(String name) {
        super(name);
    }


    public void testGetDate() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("db date to convert: " + new Date());
        }

        String date = DateUtil.getDate(new Date());

        if (log.isDebugEnabled()) {
            log.debug("converted ui date: " + date);
        }

        assertTrue(date != null);
    }
    
    public void testGetDateTime() {
        if (log.isDebugEnabled()) {
            log.debug("entered 'testGetDateTime' method");
        }
        String now = DateUtil.getTimeNow(new Date());
        assertTrue(now != null);
        log.debug(now);
    }
    public void testGetDateWithNull() {
        final String date = DateUtil.getDate(null);
        assertEquals("", date);
    }

    public void testGetDateTimeWithNull() {
        final String date = DateUtil.getDateTime(null, null);
        assertEquals("", date);
    }

    public void testGetToday() throws ParseException {
        assertNotNull(DateUtil.getToday());
    }
}

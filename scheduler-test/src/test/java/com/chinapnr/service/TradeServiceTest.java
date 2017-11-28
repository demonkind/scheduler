package com.chinapnr.service;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinapnr.service.domain.Trade;

public class TradeServiceTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(TradeServiceTest.class);
    @Autowired
    private TradeService tradeService; 

    @Test
    public void testSaveGetUser() throws Exception {
    	Trade trade = new Trade();
    	trade.setTradeNo("001");
    	trade.setGoodsInfo("001");
        String pk = tradeService.insert(trade);
        assertEquals("001", pk);

    }
}

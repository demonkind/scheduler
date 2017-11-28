package com.chinapnr.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;

import com.chinapnr.dao.TradeMapper;
import com.chinapnr.model.TradeDO;


public class TradeServiceImplTest extends BaseManagerMockTestCase {
    private TradeServiceImpl tradeService = new TradeServiceImpl();
    private TradeMapper tradeDao;

    @Before
    public void setUp() throws Exception {
    	tradeDao = context.mock(TradeMapper.class);
    	tradeService.tradeDao = tradeDao;
    }

    @Test
    public void testGetAllTrades() {
        log.debug("entered 'testGetAllTrades' method");

        // set expected behavior on dao
        TradeDO tradeDO = new TradeDO();
        final List<TradeDO> list = new ArrayList<TradeDO>();
        list.add(tradeDO);
        context.checking(new Expectations() {{
        	 one(tradeDao).getTrade();
            will(returnValue(list));
        }});

        List retList = tradeService.getTrade();
        assertTrue(retList.size() > 0);
    }
}

package com.chen.lottery.service;

import java.util.Calendar;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.spring.annotation.SpringBeanByType;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.test.support.UnitilsJUnit4Support;

public class LotteryTicketServiceTest extends UnitilsJUnit4Support
{
    @TestedObject
    @SpringBeanByType
    private LotteryTicketService lotteryService;
    
    @Override
    public void setUp()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Test
    public void testAddLotteryTicket()
    {
        try
        {
            LotteryTicket lottery = new LotteryTicket();
            lottery.setLotteryRunTime(Calendar.getInstance().getTime());
            lottery.setLotteryPeriodNum(2014131);
            lotteryService.addLotteryTicket(lottery);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertEquals(1, 0);
        }
    }

}

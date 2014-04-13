package com.chen.lottery.service;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.spring.annotation.SpringBeanByType;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.test.support.UnitilsJUnit4Support;

public class AutoInitLotteryDataServiceTest extends UnitilsJUnit4Support
{
    @TestedObject
    @SpringBeanByType
    private AutoInitLotteryDataService lotteryDataService;
    
    
    @Override
    public void setUp()
    {
        // TODO Auto-generated method stub
        
    }
    
    public void test()
    {
    }
    
    @Test
    public void testAutoInitLotterData()
    {
        try
        {
            this.lotteryDataService.autoInitLotterData();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            assertEquals(1, 0);
        }
    }
    
    
    @Test
    public void testParseTr2Bean()
    {
        String trStr = " <tr class=\"bgcolor1\">                        <td class=\"td1\">2013-09-05</td>                        <td class=\"td2\">                                                <a href=\"/lottery/draw/view/50?phase=2013104\">2013104</a>                                                </td>                        <td class=\"td3\"><span class=\"result\">                        <span class=\"ball_1\">01</span>                    <span class=\"ball_1\">02</span>                    <span class=\"ball_1\">04</span>                    <span class=\"ball_1\">15</span>                    <span class=\"ball_1\">17</span>                    <span class=\"ball_1\">28</span>                        <span class=\"ball_2\">11</span>            </span></td>                        <td class=\"td4\">339,771,188</td>                    </tr>   ";
        try
        {
            LotteryTicket lottery = this.lotteryDataService.parseTr2Bean(trStr);
            System.out.println(lottery);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertEquals(1, 0);
        }
    }

}

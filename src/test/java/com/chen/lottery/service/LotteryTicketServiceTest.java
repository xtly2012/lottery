package com.chen.lottery.service;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.spring.annotation.SpringBeanByType;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.domain.expend.LotterySectionQuery;
import com.chen.lottery.domain.expend.LotteryTicketQuery;
import com.chen.lottery.service.bo.BlueBallColumnBO;
import com.chen.lottery.service.bo.RedBallColumnBO;
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
    
    @Test
    public void testRedBallColumnBO()
    {
        try
        {
            LotterySectionQuery query = new LotterySectionQuery();
            query.setOrderStr("LOTTERY_PERIOD_NUM asc");
            List<LotteryTicket> dataList = this.lotteryService.querySection(query);
            
            RedBallColumnBO redColumnBO = new RedBallColumnBO(dataList.size());
            for(int i = 1; i < dataList.size(); i++)
            {
                LotteryTicket ticket =  dataList.get(i);
                redColumnBO.addRedBall(1, i, Integer.valueOf(ticket.getLotteryRedFirst()));
                redColumnBO.addRedBall(2, i, Integer.valueOf(ticket.getLotteryRedSecond()));
                redColumnBO.addRedBall(3, i, Integer.valueOf(ticket.getLotteryRedThird()));
                redColumnBO.addRedBall(4, i, Integer.valueOf(ticket.getLotteryRedFourth()));
                redColumnBO.addRedBall(5, i, Integer.valueOf(ticket.getLotteryRedFifth()));
                redColumnBO.addRedBall(6, i, Integer.valueOf(ticket.getLotteryRedSixth()));
            }
            
            System.out.println(redColumnBO.countToString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertEquals(0, 1);
        }
    }
    
    @Test
    public void testQueryRedBallColumn()
    {
    	try
    	{
    		int count = 0;
    		int totalCount = 0;
    		RedBallColumnBO redBallCol = this.lotteryService.queryRedBallColumn();
    		String[][][] redDataArr = redBallCol.getRedDataArr();
    		String[][] firstDataArr = redDataArr[1];
//    		for (int i = 1; i < firstDataArr.length; i++)
//    		{
//    			totalCount++;
//    			if (firstDataArr[i][1] != null && 1 == Integer.valueOf(firstDataArr[i][1]))
//    			{
//    				count++;
//    			}
//    			else if (firstDataArr[i][2] != null && 1 == Integer.valueOf(firstDataArr[i][2]))
//    			{
//    				count++;
//    			}
//    			else if (firstDataArr[i][3] != null && 1 == Integer.valueOf(firstDataArr[i][3]))
//    			{
//    				count++;
//    			}
//    			else if (firstDataArr[i][4] != null && 1 == Integer.valueOf(firstDataArr[i][4]))
//    			{
//    				count++;
//    			}
//    			else if (firstDataArr[i][5] != null && 1 == Integer.valueOf(firstDataArr[i][5]))
//    			{
//    				count++;
//    			}
//    			else if (firstDataArr[i][6] != null && 1 == Integer.valueOf(firstDataArr[i][6]))
//    			{
//    				count++;
//    			}
//    			
//    			if (i % 10 == 0)
//    			{
//    				System.out.println("count = " +count +", totalCount=" +totalCount +",abc=" +((double)count/totalCount));
//    			}
//    		}
    		
    		StringBuffer strBuf = new StringBuffer();
    		for (int j = 0; j < redDataArr[1].length; j++)
            {
                for (int k = 0; k < 7; k++)
                {
                    String temp = redDataArr[1][j][k];
                    strBuf.append(String.format("%1$6s", temp == null ? "0" : temp));
                }
                strBuf.append("\r\n");
                
                if (j % 6 == 0)
                {
                	 strBuf.append("---------------------------------------------\r\n");
                }
            }
    		
//    		System.out.println(strBuf.toString());
    		
    		System.out.println(redBallCol.countToString());
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertEquals(0, 1);
    	}
    }
    
    @Test
    public void testQueryBlueBallColumn()
    {
    	try
    	{
    		BlueBallColumnBO blueBallCol = this.lotteryService.queryBlueBallColumn();
    		System.out.println(blueBallCol.countToString());
    		
    		// 1  01    02    03    04    05    06
    		// 2  04    05    06    07    08    09    10
    		// 3  13    14    15    16    17    18
    		// 4  17    18    19    20    21    22    23
    		// 5  24    25    26    27    28    29    30
    		// 6  28    29    30    31    32    33
    		// 7 
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertEquals(0, 1);
    	}
    }
    
    @Test
    public void testQuerySelective()
    {
    	try
    	{
    		LotteryTicketQuery lottery = new LotteryTicketQuery();
    		lottery.setLotteryRedFirst("01");
    		List<LotteryTicket> dataList = this.lotteryService.querySelective(lottery);
    		System.out.println(dataList);
    		
//    		lottery = new LotteryTicket();
//    		lottery.setLotteryRedFirst("01");
//    		lottery.setLotteryRedSecond("04");
//    		dataList = this.lotteryService.querySelective(lottery);
//    		System.out.println(dataList);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertEquals(1, 0);
    	}
    	
    }
}

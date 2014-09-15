package com.chen.lottery.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.spring.annotation.SpringBeanByType;

import com.chen.lottery.controller.to.BallLineTO;
import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.service.bo.BallCountBO;
import com.chen.test.support.UnitilsJUnit4Support;

public class LotteryAnalyzeServiceTest extends UnitilsJUnit4Support
{
    @TestedObject
    @SpringBeanByType
    private LotteryAnalyzeService analyzeService;
    
    @Override
    public void setUp()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Test
    public void testAnalyzeBallLine()
    {
        try
        {
            Date startTime = null;
            Date endTime = null;
            List<BallCountBO> countList = this.analyzeService.analyzeBallLine(startTime, endTime);
            assertEquals(false, countList.isEmpty());
            
            Integer[][] valueArr = new Integer[33][countList.size()];
            String[] labels = new String[countList.size()];
            Iterator<BallCountBO> countIter = countList.iterator();
            for (int i = 0; i < countList.size(); i++)
            {
                BallCountBO countBO = countIter.next();
                for (int j = 0; j < valueArr.length; j++)
                {
                    valueArr[j][i] = countBO.getRedFirstCount()[0];
                }
                labels[i] = String.valueOf(countBO.getPeriodNum());
            }
            
            BallLineTO[] dataArr = new BallLineTO[valueArr.length];
            BallLineTO lineTO = null;
            for (int i = 0; i < dataArr.length; i++)
            {
                lineTO = new BallLineTO();
                lineTO.setColor("#FFFFF");
                lineTO.setLine_width(2);
                lineTO.setValue(valueArr[i]);
                lineTO.setName(BallCountBO.redLotteryNum[i]);
                
                dataArr[i] = lineTO;
            }
            
            JSONArray dataJson = JSONArray.fromObject(dataArr);
            System.out.println(dataJson.toString());
            
            JSONArray labelJson = JSONArray.fromObject(labels);
            System.out.println(labelJson.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertEquals(1, 0);
        }
    }
    
    @Test
    public void testAnalyzeBallColumn()
    {
        try
        {
            Date startTime = null;
            Date endTime = null;
            List<BallCountBO> countList = this.analyzeService.analyzeBallLine(startTime, endTime);
            assertEquals(false, countList.isEmpty());
            
            Integer[][] valueArr = new Integer[33][countList.size()];
            String[] labels = new String[countList.size()];
            Iterator<BallCountBO> countIter = countList.iterator();
            for (int i = 0; i < countList.size(); i++)
            {
                BallCountBO countBO = countIter.next();
                for (int j = 0; j < valueArr.length; j++)
                {
                    valueArr[j][i] = countBO.getRedFirstCount()[0];
                }
                labels[i] = String.valueOf(countBO.getPeriodNum());
            }
            
            BallLineTO[] dataArr = new BallLineTO[valueArr.length];
            BallLineTO lineTO = null;
            for (int i = 0; i < dataArr.length; i++)
            {
                lineTO = new BallLineTO();
                lineTO.setColor("#FFFFF");
                lineTO.setLine_width(2);
                lineTO.setValue(valueArr[i]);
                lineTO.setName(BallCountBO.redLotteryNum[i]);
                
                dataArr[i] = lineTO;
            }
            
            JSONArray dataJson = JSONArray.fromObject(dataArr);
            System.out.println(dataJson.toString());
            
            JSONArray labelJson = JSONArray.fromObject(labels);
            System.out.println(labelJson.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            assertEquals(1, 0);
        }
    }
    
    @Test
    public void testAnalyzeProbabilityBall()
    {
    	try
    	{
    		this.analyzeService.analyzeProbabilityBall();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertEquals(1, 0);
    	}
    }
    
    @Test
    public void testAnalyzeLike()
    {
    	try
    	{
    		List<List<LotteryTicket>> resultList = this.analyzeService.analyzeLike();
    		System.out.println(resultList.size());
    		System.out.println(resultList.get(0));
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		assertEquals(1, 0);
    	}
    }
    
}

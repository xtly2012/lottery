package com.chen.lottery.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.listener.BaseException;
import com.chen.lottery.service.LotteryAnalyzeService;
import com.chen.lottery.service.LotteryTicketService;
import com.chen.lottery.service.bo.BallCountBO;
import com.chen.lottery.service.bo.BlueBallColumnBO;
import com.chen.lottery.service.bo.LotterySectionQuery;
import com.chen.lottery.service.bo.LotteryTicketQuery;
import com.chen.lottery.service.bo.RedBallColumnBO;

@Service(value="LotteryAnalyzeService")
public class LotteryAnalyzeServiceImpl implements LotteryAnalyzeService
{
    @Autowired
    private LotteryTicketService lotteryService;
    
    private static final int LIKE_LEVER = 4;
    
    public List<BallCountBO> analyzeBallLine(Date startTime, Date endTime) throws BaseException
    {
        LotterySectionQuery query = new LotterySectionQuery();
        query.setStartTime(startTime);
        query.setEndTime(endTime);
        query.setOrderStr("LOTTERY_PERIOD_NUM asc");
        List<LotteryTicket> dataList = this.lotteryService.querySection(query);
        
        BallCountBO preCountBO = null;
        BallCountBO curCountBO = null;
        List<BallCountBO> countList = new ArrayList<BallCountBO>();
        Iterator<LotteryTicket> lotteryIter = dataList.iterator();
        while(lotteryIter.hasNext())
        {
            LotteryTicket ticket =  lotteryIter.next();
            if (preCountBO == null)
            {
                curCountBO = new BallCountBO();
            }
            else
            {
                curCountBO = preCountBO;
            }
            curCountBO.setPeriodNum(ticket.getLotteryPeriodNum());
            curCountBO.setRedFirstCount(ticket.getLotteryRedFirst());
            curCountBO.setRedSecondCount(ticket.getLotteryRedSecond());
            curCountBO.setRedThirdCount(ticket.getLotteryRedThird());
            curCountBO.setRedFourthCount(ticket.getLotteryRedFourth());
            curCountBO.setRedFifthCount(ticket.getLotteryRedFifth());
            curCountBO.setRedSixthCount(ticket.getLotteryRedSixth());
            curCountBO.setBlueFirstCount(ticket.getLotteryBlueFirst());
            countList.add(curCountBO);
            preCountBO = curCountBO.clone();
        }
        
        return countList;
    }
    
    public List<List<LotteryTicket>> analyzeLike() throws BaseException
    {
		LotteryTicketQuery query = new LotteryTicketQuery();
	    query.setOrderStr("LOTTERY_PERIOD_NUM asc");
	    
	    LotteryTicket ticket = null;
	    List<List<LotteryTicket>> resultList = new ArrayList<List<LotteryTicket>>();
	    List<LotteryTicket> dataList = this.lotteryService.querySelective(query);
	    Iterator<LotteryTicket> lotteryIter = dataList.iterator();
	    while(lotteryIter.hasNext())
	    {
	    	 ticket = lotteryIter.next();
	    	 
	    	 for (List<LotteryTicket> list : resultList)
	    	 {
	    		 for (LotteryTicket temp : list)
	    		 {
		    		 int count = this.likeCount(temp, ticket);
		    		 if (count >= LIKE_LEVER)
		    		 {
		    			 list.add(ticket);
		    			 ticket = null;
		    			 break;
		    		 }
	    		 }
	    		 
	    		 if (ticket == null)
	    		 {
	    			 break;
	    		 }
	    	 }
	    	 
	    	 if (ticket != null)
	    	 {
	    		 List<LotteryTicket> ticketList = new ArrayList<LotteryTicket>();
	    		 ticketList.add(ticket);
	    		 resultList.add(ticketList);
	    	 }
	    }
	    
    	return resultList;
    }
    
    private int likeCount(LotteryTicket ticket, LotteryTicket otherTicket)
    {
    	 int count = 0;
		 if (ticket.getLotteryRedFirst().equals(otherTicket.getLotteryRedFirst()))
		 {
			 count++;
		 }
		 if (ticket.getLotteryRedSecond().equals(otherTicket.getLotteryRedSecond()))
		 {
			 count++;
		 }
		 if (ticket.getLotteryRedThird().equals(otherTicket.getLotteryRedThird()))
		 {
			 count++;
		 }
		 if (ticket.getLotteryRedFourth().equals(otherTicket.getLotteryRedFourth()))
		 {
			 count++;
		 }
		 if (ticket.getLotteryRedFifth().equals(otherTicket.getLotteryRedFifth()))
		 {
			 count++;
		 }
		 if (ticket.getLotteryRedSixth().equals(otherTicket.getLotteryRedSixth()))
		 {
			 count++;
		 }
		 if (ticket.getLotteryBlueFirst().equals(otherTicket.getLotteryBlueFirst()))
		 {
			 count++;
		 }
		 
		 return count;
    }

    public int[][] analyzeProbabilityBall() throws BaseException
    {
    	RedBallColumnBO redBallCol = this.lotteryService.queryRedBallColumn();
    	BlueBallColumnBO blueBallCol = this.lotteryService.queryBlueBallColumn();
        
//    	int[][] redCountArr = redBallCol.getRedCountArr();
//    	Map<String, List<Integer>> dataMap = new HashMap<String, List<Integer>>();
//    	
//    	for (int i = 1; i < redCountArr.length; i++)
//    	{
//    		for (int j = 1; j < redCountArr[i].length; j++)
//    		{
//    			if (topCountArr[i][1] < redCountArr[i][j])
//    			{
//    				topCountArr[i][1] = redCountArr[i][j];
//    			}
//    			else if (topCountArr[2][i] < redCountArr[i][j])
//    			{
//    				topCountArr[i][2] = redCountArr[i][j];
//    			}
//    			else if (topCountArr[i][3] < redCountArr[i][j])
//    			{
//    				topCountArr[i][3] = redCountArr[i][j];
//    			}
//    		}
//    	}
//    	
//    	
//    	int[][] blueCountArr = blueBallCol.getBlueCountArr();
//    	for (int i = 1; i < blueCountArr[i].length; i++)
//		{
//			if (topCountArr[7][1] < blueCountArr[7][i])
//			{
//				topCountArr[1][1] = blueCountArr[7][i];
//			}
//			else if (topCountArr[7][2] < blueCountArr[7][i])
//			{
//				topCountArr[7][2] = blueCountArr[7][i];
//			}
//			else if (topCountArr[7][3] < redCountArr[7][i])
//			{
//				topCountArr[7][3] = blueCountArr[7][i];
//			}
//		}
    	
        return null;
    }
    
}

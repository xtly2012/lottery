package com.chen.lottery.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lottery.dao.LotteryTicketDAO;
import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.listener.BaseException;
import com.chen.lottery.service.LotteryTicketService;
import com.chen.lottery.service.bo.BlueBallColumnBO;
import com.chen.lottery.service.bo.LotterySectionQuery;
import com.chen.lottery.service.bo.LotteryTicketQuery;
import com.chen.lottery.service.bo.RedBallColumnBO;

@Service(value="LotteryTicketService")
public class LotteryTicketServiceImpl implements LotteryTicketService
{
    Logger logger = LoggerFactory.getLogger(LotteryTicketServiceImpl.class);
    
    @Autowired
    private LotteryTicketDAO lotteryTicketDao;
    
    public void addLotteryTicket(LotteryTicket lottery) throws BaseException
    {
        if (lottery == null)
        {
            logger.warn("参数为空：lottery=null");
            throw new IllegalArgumentException();
        }
        
        LotteryTicket queryTicket =this.queryByPeriodNum(lottery.getLotteryPeriodNum());
        if (queryTicket != null)
        {
            return;
        }
        
        logger.debug("add lottery");
        this.lotteryTicketDao.addSelective(lottery);
    }
    

    public LotteryTicket queryByPeriodNum(Integer lotteryPeriodNum) throws BaseException
    {
       LotteryTicketQuery query = new LotteryTicketQuery();
       query.setLotteryPeriodNum(lotteryPeriodNum);
       List<LotteryTicket> lotteryList = this.lotteryTicketDao.querySelective(query);
       if (!lotteryList.isEmpty() && lotteryList.size() != 1)
       {
           logger.warn("查询结果不等于1：lotteryPeriodNum={}", lotteryPeriodNum);
           throw new BaseException("查询结果不等于1");
       }
       
       if (lotteryList.isEmpty())
       {
           return null;
       }
       else
       {
           return lotteryList.get(0);
       }
    }

    public List<LotteryTicket> querySelective(LotteryTicketQuery query) throws BaseException
    {
    	return this.lotteryTicketDao.querySelective(query);
    }

    public List<LotteryTicket> querySection(LotterySectionQuery query) throws BaseException
    {
        return this.lotteryTicketDao.querySection(query);
    }
    
    public RedBallColumnBO queryRedBallColumn() throws BaseException
    {
        LotterySectionQuery query = new LotterySectionQuery();
        query.setOrderStr("LOTTERY_PERIOD_NUM asc");
        List<LotteryTicket> dataList = this.querySection(query);
        
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
        
        return redColumnBO;
    }
    
    public BlueBallColumnBO queryBlueBallColumn() throws BaseException
    {
        LotterySectionQuery query = new LotterySectionQuery();
        query.setOrderStr("LOTTERY_PERIOD_NUM asc");
        List<LotteryTicket> dataList = this.querySection(query);
        
        BlueBallColumnBO blueColumnBO = new BlueBallColumnBO(dataList.size());
        for(int i = 1; i < dataList.size(); i++)
        {
            LotteryTicket ticket =  dataList.get(i);
            blueColumnBO.addBlueBall(i, Integer.valueOf(ticket.getLotteryBlueFirst()));
        }
        
        return blueColumnBO;
    }
}

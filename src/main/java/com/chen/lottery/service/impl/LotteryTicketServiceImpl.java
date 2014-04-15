package com.chen.lottery.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lottery.dao.LotteryTicketDAO;
import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.domain.expend.LotterySectionQuery;
import com.chen.lottery.listener.BaseException;
import com.chen.lottery.service.LotteryTicketService;

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
       LotteryTicket query = new LotteryTicket();
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


    public List<LotteryTicket> querySection(LotterySectionQuery query) throws BaseException
    {
        return this.lotteryTicketDao.querySection(query);
    }
    
    
}

package com.chen.lottery.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.domain.expend.LotterySectionQuery;
import com.chen.lottery.listener.BaseException;
import com.chen.lottery.service.LotteryAnalyzeService;
import com.chen.lottery.service.LotteryTicketService;
import com.chen.lottery.service.bo.BallCountBO;

@Service(value="LotteryAnalyzeService")
public class LotteryAnalyzeServiceImpl implements LotteryAnalyzeService
{
    @Autowired
    private LotteryTicketService lotteryService;
    
    public List<BallCountBO> analyzeBallLine() throws BaseException
    {
        LotterySectionQuery query = new LotterySectionQuery();
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
    
}

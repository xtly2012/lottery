package com.chen.lottery.service;

import java.util.List;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.listener.BaseException;
import com.chen.lottery.service.bo.BlueBallColumnBO;
import com.chen.lottery.service.bo.LotterySectionQuery;
import com.chen.lottery.service.bo.LotteryTicketQuery;
import com.chen.lottery.service.bo.RedBallColumnBO;

/**
 * 采票服务类
 * 
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.service
 * @author chen
 * @since 2014-3-29
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public interface LotteryTicketService
{
    void addLotteryTicket(LotteryTicket lottery) throws BaseException;
    
    LotteryTicket queryByPeriodNum(Integer lotteryPeriodNum) throws BaseException;
    
    List<LotteryTicket> querySection(LotterySectionQuery query) throws BaseException;
    
    List<LotteryTicket> querySelective(LotteryTicketQuery query) throws BaseException;
    
    RedBallColumnBO queryRedBallColumn() throws BaseException;
    
    BlueBallColumnBO queryBlueBallColumn() throws BaseException;
}

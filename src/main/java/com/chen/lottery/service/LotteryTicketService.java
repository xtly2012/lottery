package com.chen.lottery.service;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.listener.BaseException;

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
    
    LotteryTicket querySelective(Integer lotteryPeriodNum) throws BaseException;
}

package com.chen.lottery.dao;

import java.util.List;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.service.bo.LotterySectionQuery;
import com.chen.lottery.service.bo.LotteryTicketQuery;

/**
 * 彩票信息数据操作类
 * 
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.dao
 * @author chen
 * @since 2014-3-29
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public interface LotteryTicketDAO
{
    /**
     * 添加一条彩票信息
     */
    public void addSelective(LotteryTicket lottery);
    
    public List<LotteryTicket> querySelective(LotteryTicketQuery lotteryQuery);
    
    public List<LotteryTicket> querySection(LotterySectionQuery query);
}

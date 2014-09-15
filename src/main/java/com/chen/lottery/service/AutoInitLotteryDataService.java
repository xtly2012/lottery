package com.chen.lottery.service;

import java.util.List;

import com.chen.lottery.domain.LotteryTicket;

/**
 * 将互联网上的彩票信息同步到数据库
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
public interface AutoInitLotteryDataService
{
    void autoInitLotterData();
    
    List<LotteryTicket> parseHtml2Beans(String htmlStr);
    
    LotteryTicket parseTr2Bean(String trStr);
}

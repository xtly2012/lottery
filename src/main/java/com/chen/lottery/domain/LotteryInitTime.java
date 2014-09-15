package com.chen.lottery.domain;

import java.util.Date;


/**
 * 彩票数据同步信息
 * 
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.domain
 * @author chen
 * @since 2014-4-13
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public class LotteryInitTime
{
    /**
     * 彩票数据同步时间
     */
    private Date lotteryInitTime;

    public Date getLotteryInitTime()
    {
        return lotteryInitTime;
    }

    public void setLotteryInitTime(Date lotteryInitTime)
    {
        this.lotteryInitTime = lotteryInitTime;
    }
    
}

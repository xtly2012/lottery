package com.chen.lottery.dao;

import java.util.Date;
import java.util.List;

import com.chen.lottery.domain.LotteryInitTime;

public interface LotteryInitTimeDAO
{
    void addSelective(LotteryInitTime time);
    
    List<LotteryInitTime> querySelective(LotteryInitTime time);
    
    Date queryMaxInitTime();
    
}

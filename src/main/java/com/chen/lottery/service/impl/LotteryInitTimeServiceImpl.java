package com.chen.lottery.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lottery.dao.LotteryInitTimeDAO;
import com.chen.lottery.domain.LotteryInitTime;
import com.chen.lottery.service.LotteryInitTimeService;

@Service(value="LotteryInitTimeService")
public class LotteryInitTimeServiceImpl implements LotteryInitTimeService
{
    @Autowired
    private LotteryInitTimeDAO lotteryInitTimeDao; 
    
    public Date getLotteryInitTime()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = this.lotteryInitTimeDao.queryMaxInitTime();
        if (time != null && time.getTime() >= calendar.getTime().getTime())
        {
            return null;
        }
    
        LotteryInitTime initTime = new LotteryInitTime();
        initTime.setLotteryInitTime(calendar.getTime());
        this.lotteryInitTimeDao.addSelective(initTime);
        
        return initTime.getLotteryInitTime();
    }

}

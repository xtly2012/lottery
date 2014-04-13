package com.chen.lottery.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chen.lottery.dao.LotteryInitTimeDAO;
import com.chen.lottery.domain.LotteryInitTime;

@Component(value="LotteryInitTimeDAO")
public class LotteryInitTimeDAOImpl extends IbatisClientDaoSupport implements LotteryInitTimeDAO 
{

    public void addSelective(LotteryInitTime lottery)
    {
        this.getSqlMapClientTemplate().insert("LotteryInitTime.addSelective", lottery);
    }

    @SuppressWarnings("unchecked")
    public List<LotteryInitTime> querySelective(LotteryInitTime lottery)
    {
        return (List<LotteryInitTime>)this.getSqlMapClientTemplate().queryForList("LotteryInitTime.querySelective", lottery);
    }

    public LotteryInitTime queryMaxInitTime()
    {
        
        return (LotteryInitTime)this.getSqlMapClientTemplate().queryForObject("LotteryInitTime.queryMaxInitTime");
    }

}

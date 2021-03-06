package com.chen.lottery.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chen.lottery.dao.LotteryInitTimeDAO;
import com.chen.lottery.domain.LotteryInitTime;

@Component(value="LotteryInitTimeDAO")
public class LotteryInitTimeDAOImpl extends IbatisClientDaoSupport implements LotteryInitTimeDAO 
{

	@Override
    public void addSelective(LotteryInitTime lottery)
    {
        this.getSqlMapClientTemplate().insert("LotteryInitTime.addSelective", lottery);
    }

	@Override
    @SuppressWarnings("unchecked")
    public List<LotteryInitTime> querySelective(LotteryInitTime lottery)
    {
        return (List<LotteryInitTime>)this.getSqlMapClientTemplate().queryForList("LotteryInitTime.querySelective", lottery);
    }

	@Override
    public Date queryMaxInitTime()
    {
        
        return (Date)this.getSqlMapClientTemplate().queryForObject("LotteryInitTime.queryMaxInitTime");
    }

}

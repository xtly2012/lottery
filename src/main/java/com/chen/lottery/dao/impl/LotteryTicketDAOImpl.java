package com.chen.lottery.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chen.lottery.dao.LotteryTicketDAO;
import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.service.bo.LotterySectionQuery;
import com.chen.lottery.service.bo.LotteryTicketQuery;

@Component(value="LotteryTicketDAO")
public class LotteryTicketDAOImpl extends IbatisClientDaoSupport implements LotteryTicketDAO 
{

    public void addSelective(LotteryTicket lottery)
    {
        this.getSqlMapClientTemplate().insert("LotteryTicket.addSelective", lottery);
    }

    @SuppressWarnings("unchecked")
    public List<LotteryTicket> querySelective(LotteryTicketQuery lotteryQuery)
    {
        return (List<LotteryTicket>)this.getSqlMapClientTemplate().queryForList("LotteryTicket.querySelective", lotteryQuery);
    }

    @SuppressWarnings("unchecked")
    public List<LotteryTicket> querySection(LotterySectionQuery query)
    {
        return (List<LotteryTicket>)this.getSqlMapClientTemplate().queryForList("LotteryTicket.querySection", query);
    }
    
    
}

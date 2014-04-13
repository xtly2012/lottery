package com.chen.lottery.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chen.lottery.dao.LotteryTicketDAO;
import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.domain.expend.LotterySectionQuery;

@Component(value="LotteryTicketDAO")
public class LotteryTicketDAOImpl extends IbatisClientDaoSupport implements LotteryTicketDAO 
{

    public void addSelective(LotteryTicket lottery)
    {
        this.getSqlMapClientTemplate().insert("LotteryTicket.addSelective", lottery);
    }

    @SuppressWarnings("unchecked")
    public List<LotteryTicket> querySelective(LotteryTicket lottery)
    {
        return (List<LotteryTicket>)this.getSqlMapClientTemplate().queryForList("LotteryTicket.querySelective", lottery);
    }

    @SuppressWarnings("unchecked")
    public List<LotteryTicket> querySection(LotterySectionQuery query)
    {
        return (List<LotteryTicket>)this.getSqlMapClientTemplate().queryForList("LotteryTicket.querySection", query);
    }
    
    
}

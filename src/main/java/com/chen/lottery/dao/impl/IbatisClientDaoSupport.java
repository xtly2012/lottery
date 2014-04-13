package com.chen.lottery.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import javax.annotation.PostConstruct;

@Repository
@SuppressWarnings("restriction")
public abstract class IbatisClientDaoSupport extends SqlMapClientDaoSupport
{
    @Autowired
    private SqlMapClient sqlMapClient;

    @PostConstruct
    public void initSqlMapClient()
    {
        super.setSqlMapClient(sqlMapClient);
    }

}

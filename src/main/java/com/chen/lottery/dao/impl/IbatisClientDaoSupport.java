package com.chen.lottery.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
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

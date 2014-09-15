package com.chen.lottery.service.bo;

import java.util.Date;

public class LotterySectionQuery implements TimeQueryBean
{
    private Date startTime;
    
    private Date endTime;
    
    private Integer startPeriodNum;
    
    private Integer endPeriodNum;
    
    private String orderStr;

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Integer getStartPeriodNum()
    {
        return startPeriodNum;
    }

    public void setStartPeriodNum(Integer startPeriodNum)
    {
        this.startPeriodNum = startPeriodNum;
    }

    public Integer getEndPeriodNum()
    {
        return endPeriodNum;
    }

    public void setEndPeriodNum(Integer endPeriodNum)
    {
        this.endPeriodNum = endPeriodNum;
    }

	public String getOrderStr() {
		return this.orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}
    
}

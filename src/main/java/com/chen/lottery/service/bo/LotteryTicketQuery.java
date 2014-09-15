package com.chen.lottery.service.bo;

import java.util.Date;

import com.chen.lottery.domain.LotteryTicket;

public class LotteryTicketQuery extends LotteryTicket implements TimeQueryBean {
	
	private Date startTime;

	private Date endTime;

	private Integer startPeriodNum;

	private Integer endPeriodNum;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStartPeriodNum() {
		return startPeriodNum;
	}

	public void setStartPeriodNum(Integer startPeriodNum) {
		this.startPeriodNum = startPeriodNum;
	}

	public Integer getEndPeriodNum() {
		return endPeriodNum;
	}

	public void setEndPeriodNum(Integer endPeriodNum) {
		this.endPeriodNum = endPeriodNum;
	}

	public String getOrderStr() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOrderStr(String orderStr) {
		// TODO Auto-generated method stub
		
	}

}

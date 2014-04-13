package com.chen.lottery.service.bo;

public class BallCountBO
{
    private String ballName;
    
    private Integer countNum;
    
    private String countTime;

    public String getBallName()
    {
        return ballName;
    }

    public void setBallName(String ballName)
    {
        this.ballName = ballName;
    }

    public Integer getCountNum()
    {
        return countNum;
    }

    public void setCountNum(Integer countNum)
    {
        this.countNum = countNum;
    }

    public String getCountTime()
    {
        return countTime;
    }

    public void setCountTime(String countTime)
    {
        this.countTime = countTime;
    } 
    
}

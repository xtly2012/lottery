package com.chen.lottery.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 双色球彩票每期相关信息
 * 
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.domain
 * @author chen
 * @since 2014-3-29
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public class LotteryTicket
{
    /**
     * 彩票期数
     */
    private Integer lotteryPeriodNum;
    
    /**
     * 彩票开奖日期
     */
    private Date lotteryRunTime;
    
    /**
     * 红色球第一位数
     */
    private String lotteryRedFirst;
    
    /**
     * 红色球第二位数
     */
    private String lotteryRedSecond;
    
    /**
     * 红色球第三位数
     */
    private String lotteryRedThird;
    
    /**
     * 红色球第四位数
     */
    private String lotteryRedFourth;
    
    /**
     * 红色球第五位数
     */
    private String lotteryRedFifth;
    
    /**
     * 红色球第六位数
     */
    private String lotteryRedSixth;
    
    /**
     * 蓝色球第一位数
     */
    private String lotteryBlueFirst;
    
    /**
     * 彩票总销售数
     */
    private String lotterySaleVolume;

    public Date getLotteryRunTime()
    {
        return lotteryRunTime;
    }

    public void setLotteryRunTime(Date lotteryRunTime)
    {
        this.lotteryRunTime = lotteryRunTime;
    }

    public Integer getLotteryPeriodNum()
    {
        return lotteryPeriodNum;
    }

    public void setLotteryPeriodNum(Integer lotteryPeriodNum)
    {
        this.lotteryPeriodNum = lotteryPeriodNum;
    }

    public String getLotteryRedFirst()
    {
        return lotteryRedFirst;
    }

    public void setLotteryRedFirst(String lotteryRedFirst)
    {
        this.lotteryRedFirst = lotteryRedFirst;
    }

    public String getLotteryRedSecond()
    {
        return lotteryRedSecond;
    }

    public void setLotteryRedSecond(String lotteryRedSecond)
    {
        this.lotteryRedSecond = lotteryRedSecond;
    }

    public String getLotteryRedThird()
    {
        return lotteryRedThird;
    }

    public void setLotteryRedThird(String lotteryRedThird)
    {
        this.lotteryRedThird = lotteryRedThird;
    }

    public String getLotteryRedFourth()
    {
        return lotteryRedFourth;
    }

    public void setLotteryRedFourth(String lotteryRedFourth)
    {
        this.lotteryRedFourth = lotteryRedFourth;
    }

    public String getLotteryRedFifth()
    {
        return lotteryRedFifth;
    }

    public void setLotteryRedFifth(String lotteryRedFifth)
    {
        this.lotteryRedFifth = lotteryRedFifth;
    }

    public String getLotteryRedSixth()
    {
        return lotteryRedSixth;
    }

    public void setLotteryRedSixth(String lotteryRedSixth)
    {
        this.lotteryRedSixth = lotteryRedSixth;
    }

    public String getLotteryBlueFirst()
    {
        return lotteryBlueFirst;
    }

    public void setLotteryBlueFirst(String lotteryBlueFirst)
    {
        this.lotteryBlueFirst = lotteryBlueFirst;
    }

    public String getLotterySaleVolume()
    {
        return lotterySaleVolume;
    }

    public void setLotterySaleVolume(String lotterySaleVolume)
    {
        this.lotterySaleVolume = lotterySaleVolume;
    }
    
    @Override
    public String toString()
    {
        try
        {
            Class<?> cls = (Class<?>)this.getClass();
            Field[] fieldArr = cls.getDeclaredFields();
            StringBuffer strBuf = new StringBuffer("{");
            for (Field field : fieldArr)
            {
                if (!"{".equals(strBuf.toString()))
                {
                    strBuf.append(",");
                }
                StringBuffer methodBuf = new StringBuffer("get");
                methodBuf.append(field.getName().substring(0, 1).toUpperCase());
                methodBuf.append(field.getName().substring(1));
                Method method = cls.getMethod(methodBuf.toString());
                
                strBuf.append(field.getName());
                strBuf.append(":");
                strBuf.append("\"");
                strBuf.append(method.invoke(this));
                strBuf.append("\"");
            }
            strBuf.append("}");
            
            return strBuf.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

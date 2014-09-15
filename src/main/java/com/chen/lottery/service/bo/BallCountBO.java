package com.chen.lottery.service.bo;

import java.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.chen.lottery.constants.LotteryConstants;


public class BallCountBO implements Cloneable,Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static String[] redLotteryNum = LotteryConstants.RED_LOTTERY_NUM;
    
    public static String[] blueLotteryNum = LotteryConstants.BLUE_LOTTERY_NUM;

    /**
     * 彩票期数
     */
    private Integer periodNum = null;
    
    /**
     * 红色球第一位数
     */
    private Map<String,Integer> redFirstCount = new HashMap<String,Integer>();
    
    /**
     * 红色球第二位数
     */
    private Map<String,Integer> redSecondCount = new HashMap<String,Integer>();
    
    /**
     * 红色球第三位数
     */
    private Map<String,Integer> redThirdCount = new HashMap<String,Integer>();
    
    /**
     * 红色球第四位数
     */
    private Map<String,Integer> redFourthCount = new HashMap<String,Integer>();
    
    /**
     * 红色球第五位数
     */
    private Map<String,Integer> redFifthCount = new HashMap<String,Integer>();
    
    /**
     * 红色球第六位数
     */
    private Map<String,Integer> redSixthCount = new HashMap<String,Integer>();
    
    /**
     * 蓝色球第一位数
     */
    private Map<String,Integer> blueFirstCount = new HashMap<String,Integer>();

    public Integer getPeriodNum()
    {
        return periodNum;
    }
    
    public int[] getRedFirstCount()
    {
        int[] countArr = new int[redLotteryNum.length];
        for (int i = 0, j = this.redLotteryNum.length; i < j; i++)
        {
            Integer count = redFirstCount.get(redLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public int[] getRedSecondCount()
    {
        int[] countArr = new int[redLotteryNum.length];
        for (int i = 0, j = this.redLotteryNum.length; i < j; i++)
        {
            Integer count = redSecondCount.get(redLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public int[] getRedThirdCount()
    {
        int[] countArr = new int[redLotteryNum.length];
        for (int i = 0, j = this.redLotteryNum.length; i < j; i++)
        {
            Integer count = redThirdCount.get(redLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public int[] getRedFourthCount()
    {
        int[] countArr = new int[redLotteryNum.length];
        for (int i = 0, j = this.redLotteryNum.length; i < j; i++)
        {
            Integer count = redFourthCount.get(redLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public int[] getRedFifthCount()
    {
        int[] countArr = new int[redLotteryNum.length];
        for (int i = 0, j = this.redLotteryNum.length; i < j; i++)
        {
            Integer count = redFifthCount.get(redLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public int[] getRedSixthCount()
    {
        int[] countArr = new int[redLotteryNum.length];
        for (int i = 0, j = this.redLotteryNum.length; i < j; i++)
        {
            Integer count = redSixthCount.get(redLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public int[] getBlueFirstCount()
    {
        int[] countArr = new int[blueLotteryNum.length];
        for (int i = 0, j = this.blueLotteryNum.length; i < j; i++)
        {
            Integer count = blueFirstCount.get(blueLotteryNum[i]);
            if (count == null)
            {
                countArr[i] = 0;
            }
            else
            {
                countArr[i] = count;
            }
        }
        
        return countArr;
    }

    public void setPeriodNum(Integer periodNum)
    {
        this.periodNum = periodNum;
    }

    public void setRedFirstCount(String lotteryNum)
    {
        Integer count = this.redFirstCount.get(lotteryNum);
        if (count == null)
        {
            this.redFirstCount.put(lotteryNum, 1);   
        }
        else
        {
            this.redFirstCount.put(lotteryNum, count + 1);  
        }
    }

    public void setRedSecondCount(String lotteryNum)
    {
        Integer count = this.redSecondCount.get(lotteryNum);
        if (count == null)
        {
            this.redSecondCount.put(lotteryNum, 1);   
        }
        else
        {
            this.redSecondCount.put(lotteryNum, count + 1);  
        }
    }

    public void setRedThirdCount(String lotteryNum)
    {
        Integer count = this.redThirdCount.get(lotteryNum);
        if (count == null)
        {
            this.redThirdCount.put(lotteryNum, 1);   
        }
        else
        {
            this.redThirdCount.put(lotteryNum, count + 1);  
        }
    }

    public void setRedFourthCount(String lotteryNum)
    {
        Integer count = this.redFourthCount.get(lotteryNum);
        if (count == null)
        {
            this.redFourthCount.put(lotteryNum, 1);   
        }
        else
        {
            this.redFourthCount.put(lotteryNum, count + 1);  
        }
    }

    public void setRedFifthCount(String lotteryNum)
    {
        Integer count = this.redFifthCount.get(lotteryNum);
        if (count == null)
        {
            this.redFifthCount.put(lotteryNum, 1);   
        }
        else
        {
            this.redFifthCount.put(lotteryNum, count + 1);  
        }
    }

    public void setRedSixthCount(String lotteryNum)
    {
        Integer count = this.redSixthCount.get(lotteryNum);
        if (count == null)
        {
            this.redSixthCount.put(lotteryNum, 1);   
        }
        else
        {
            this.redSixthCount.put(lotteryNum, count + 1);  
        }
    }

    public void setBlueFirstCount(String lotteryNum)
    {
        Integer count = this.blueFirstCount.get(lotteryNum);
        if (count == null)
        {
            this.blueFirstCount.put(lotteryNum, 1);   
        }
        else
        {
            this.blueFirstCount.put(lotteryNum, count + 1);  
        }
    }
    
    @Override
    public BallCountBO clone()
    {
        try
        {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
            objOut.writeObject(this);
            
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream objIn = new ObjectInputStream(byteIn);
            return (BallCountBO)objIn.readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

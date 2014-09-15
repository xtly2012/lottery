package com.chen.lottery.service.bo;

import com.chen.lottery.constants.LotteryConstants;

/**
 * 红色球柱状分析BO
 * 
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.service.bo
 * @author chen
 * @since 2014-4-24
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public class RedBallColumnBO
{
    private static String[] redLotteryNum = LotteryConstants.RED_LOTTERY_NUM;
    
    /**
     * 第一位放序号
     */
    private String[][][] redDataArr = null;
    
    /**
     * 每个数字出现的次数
     */
    private int[][] redCountArr = null;
    
    public RedBallColumnBO(int length)
    {
    	redCountArr = new int[7][redLotteryNum.length];
    	
        redDataArr = new String[7][length+1][redLotteryNum.length];
        redDataArr[1][0] = redLotteryNum;
        redDataArr[2][0] = redLotteryNum;
        redDataArr[3][0] = redLotteryNum;
        redDataArr[4][0] = redLotteryNum;
        redDataArr[5][0] = redLotteryNum;
        redDataArr[6][0] = redLotteryNum;
        
        for (Integer i = 1; i < length+1; i++)
        {
            redDataArr[1][i][0] = i.toString();
            redDataArr[2][i][0] = i.toString();
            redDataArr[3][i][0] = i.toString();
            redDataArr[4][i][0] = i.toString();
            redDataArr[5][i][0] = i.toString();
            redDataArr[6][i][0] = i.toString();
        }
        
    }
    
    public void addRedBall(int index, int len, int lotteryNum)
    {
        redDataArr[index][len][lotteryNum] = "1";
        redCountArr[index][lotteryNum] += 1;
    }

    public String[][][] getRedDataArr()
    {
        return redDataArr;
    }

    public void setRedDataArr(String[][][] redDataArr)
    {
        this.redDataArr = redDataArr;
    }
    
    public int[][] getRedCountArr() {
		return redCountArr;
	}

	public void setRedCountArr(int[][] redCountArr) {
		this.redCountArr = redCountArr;
	}

	@Override
    public String toString()
    {
        StringBuffer strBuf = new StringBuffer();
        
        for (int i = 1; i < this.redDataArr.length; i++)
        {
            strBuf.append("                第");
            strBuf.append(i);
            strBuf.append("号球\r\n");
            for (int j = 0; j < this.redDataArr[i].length; j++)
            {
                for (int k = 0; k < this.redDataArr[i][j].length; k++)
                {
                    String temp = this.redDataArr[i][j][k];
                    strBuf.append(String.format("%1$6s", temp == null ? "0" : temp));
                }
                strBuf.append("\r\n");
            }
            
            strBuf.append("\r\n\r\n");
        }
        
        return strBuf.toString();
    }
	
	public String countToString()
	{
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("红球号码");
		for (int i = 1; i < redLotteryNum.length; i++)
		{
            strBuf.append(String.format("%1$6s", redLotteryNum[i]));
		}
		strBuf.append("\r\n");
		
		for (int i = 1; i < this.redCountArr.length; i++)
		{
			strBuf.append("第");
            strBuf.append(i);
            strBuf.append("号球");
            
            for (int j = 1; j < this.redCountArr[i].length; j++)
            {
            	int temp = this.redCountArr[i][j];
                strBuf.append(String.format("%1$6s", temp));
            }
            
            strBuf.append("\r\n");
		}
		
		return strBuf.toString();
	}
}

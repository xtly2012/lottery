package com.chen.lottery.service.bo;

import com.chen.lottery.constants.LotteryConstants;

public class BlueBallColumnBO
{
    private static String[] blueLotteryNum = LotteryConstants.BLUE_LOTTERY_NUM;

    /**
     * 第一位放序号
     */
    private String[][][] blueDataArr = null;
    
    /**
     * 每个数字出现的次数
     */
    private int[][] blueCountArr = null;
    
    public BlueBallColumnBO(int length)
    {
    	blueCountArr = new int[2][blueLotteryNum.length];
    	
        blueDataArr = new String[2][length+1][blueLotteryNum.length];
        
        for (Integer i = 1; i < length+1; i++)
        {
            blueDataArr[1][i][0] = i.toString();
        }
        
    }
    
    public void addBlueBall(int len, int lotteryNum)
    {
        blueDataArr[1][len][lotteryNum] = "1";
        blueCountArr[1][lotteryNum] += 1; 
    }

    public String[][][] getBlueDataArr()
    {
        return blueDataArr;
    }

    public void setBlueDataArr(String[][][] redDataArr)
    {
        this.blueDataArr = redDataArr;
    }
    
    public int[][] getBlueCountArr() {
		return blueCountArr;
	}

	public void setBlueCountArr(int[][] blueCountArr) {
		this.blueCountArr = blueCountArr;
	}

	@Override
    public String toString()
    {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 1; i < this.blueDataArr.length; i++)
        {
            strBuf.append("                第");
            strBuf.append(i);
            strBuf.append("号球\r\n");
            for (int j = 0; j < this.blueDataArr[i].length; j++)
            {
                for (int k = 0; k < this.blueDataArr[i][j].length; k++)
                {
                    String temp = this.blueDataArr[i][j][k];
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
		strBuf.append("蓝球号码");
		for (int i = 1; i < blueLotteryNum.length; i++)
		{
            strBuf.append(String.format("%1$6s", blueLotteryNum[i]));
		}
		strBuf.append("\r\n");
		
		for (int i = 1; i < this.blueCountArr.length; i++)
		{
			strBuf.append("第");
            strBuf.append(i);
            strBuf.append("号球");
            
            for (int j = 1; j < this.blueCountArr[i].length; j++)
            {
            	int temp = this.blueCountArr[i][j];
                strBuf.append(String.format("%1$6s", temp));
            }
            
            strBuf.append("\r\n");
		}
		
		return strBuf.toString();
	}
}

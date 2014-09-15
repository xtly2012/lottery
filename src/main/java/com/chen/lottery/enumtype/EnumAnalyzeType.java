package com.chen.lottery.enumtype;

/**
 * 彩票分析类型
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.type
 * @author chen
 * @since 2014-4-25
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public enum EnumAnalyzeType
{
    SPACE(0, "间隔性分析"), SUCCESSION(1, "连续性分析");
    
    private final int analyzeType;
    
    private final String analyzeName;
    
    private EnumAnalyzeType(int analyzeType, String analyzeName)
    {
        this.analyzeType = analyzeType;
        this.analyzeName = analyzeName;
    }

    public int getAnalyzeType()
    {
        return analyzeType;
    }

    public String getAnalyzeName()
    {
        return analyzeName;
    }
    
}
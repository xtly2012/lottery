package com.chen.lottery.service;

import java.util.List;

import com.chen.lottery.listener.BaseException;
import com.chen.lottery.service.bo.BallCountBO;

/**
 * 双色球分析类
 * 
 * @project lottery
 * @module  lottery
 * @comments
 * @nameSpace com.chen.lottery.service
 * @author chen
 * @since 2014-4-13
 * @see
 * @modifier
 * @date
 * @reason 
 * @version
 */
public interface LotteryAnalyzeService
{
    /**
     * 双色球彩线性分析
     * 
     * @return 分析结果
     */
    List<BallCountBO> analyzeBallLine() throws BaseException;
}

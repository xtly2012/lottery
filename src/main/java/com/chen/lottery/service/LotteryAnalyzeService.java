package com.chen.lottery.service;

import java.util.List;

import com.chen.lottery.service.bo.BallCountBO;

public interface LotteryAnalyzeService
{
    List<BallCountBO> analyzeBallLine();
}

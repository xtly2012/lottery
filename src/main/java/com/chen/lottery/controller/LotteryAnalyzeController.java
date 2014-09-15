package com.chen.lottery.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.lottery.controller.to.BallLineTO;
import com.chen.lottery.service.LotteryAnalyzeService;
import com.chen.lottery.service.bo.BallCountBO;

@Controller
public class LotteryAnalyzeController
{
    @Autowired
    private LotteryAnalyzeService analyzeService;
    
    private static String[] ballNameArr = {"red first", "red second", "red third", "red fourth", "red fifth", "red sixth","blue first" }; 
    
    @RequestMapping(value="/analyze/ballLine")
    public String analyzeBallLine(HttpServletRequest request)
    {
        try
        {
            String startTimeStr = request.getParameter("startTime");
            String endTimeStr = request.getParameter("endTime");
            Date startTime = null;
            Date endTime = null;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (startTimeStr != null)
            {
                startTime = dateFormat.parse(startTimeStr);
            }
            
            if (endTimeStr != null)
            {
                endTime = dateFormat.parse(endTimeStr);
            }
            
            List<BallCountBO> countList = this.analyzeService.analyzeBallLine(startTime, endTime);
            countList = this.filterData(countList, 20);
            
            Integer[][] valueArr = new Integer[33][countList.size()];
            String[] labelArr = new String[countList.size()];
            Iterator<BallCountBO> countIter = countList.iterator();
            for (int i = 0; i < countList.size(); i++)
            {
                BallCountBO countBO = countIter.next();
                for (int j = 0; j < valueArr.length; j++)
                {
                    valueArr[j][i] = countBO.getRedFirstCount()[j];
                }
                labelArr[i] = String.valueOf(countBO.getPeriodNum());
            }
            
            BallLineTO[] dataArr = new BallLineTO[BallCountBO.redLotteryNum.length];
            BallLineTO lineTO = null;
            for (int i = 0; i < dataArr.length; i++)
            {
                lineTO = new BallLineTO();
                lineTO.setColor("#000000");
                lineTO.setLine_width(2);
                lineTO.setValue(valueArr[i]);
                lineTO.setName(BallCountBO.redLotteryNum[i]);
                
                dataArr[i] = lineTO;
            }
            
            JSONArray dataJson = JSONArray.fromObject(dataArr);
            JSONArray labelJson = JSONArray.fromObject(labelArr);
            
            request.setAttribute("data", dataJson.toString());
            request.setAttribute("label", labelJson.toString());
            
            return "/view/chart/line.jsp";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "/view/error/error.jsp";
        }
    }
    
    private List<BallCountBO> filterData(List<BallCountBO> countList, int model)
    {
        List<BallCountBO> dataList = new ArrayList<BallCountBO>();
        int size = countList.size();
        for (int i = 0; i < size; i++)
        {
            if (i % model == 0)
            {
                dataList.add(countList.get(i));
            }
            else if (i == size-1)
            {
                dataList.add(countList.get(i));
            }
        }
        
        return dataList;
    }
}

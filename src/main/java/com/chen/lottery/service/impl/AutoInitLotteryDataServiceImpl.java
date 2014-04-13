package com.chen.lottery.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.lottery.domain.LotteryTicket;
import com.chen.lottery.service.AutoInitLotteryDataService;
import com.chen.lottery.service.LotteryInitTimeService;
import com.chen.lottery.service.LotteryTicketService;

@Service(value="AutoInitLotteryDataService")
public class AutoInitLotteryDataServiceImpl implements AutoInitLotteryDataService
{
    private static Logger logger = LoggerFactory.getLogger(AutoInitLotteryDataServiceImpl.class);
    
    @Autowired
    private LotteryTicketService lotteryService;
    
    @Autowired
    private LotteryInitTimeService initTimeService;

    public void autoInitLotterData()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date initTime = initTimeService.getLotteryInitTime();
        if (initTime == null)
        {
            logger.info("不需要初始化：{}", dateFormat.format(Calendar.getInstance().getTime()));
            return;
        }
        
        StringBuffer urlBuf = new StringBuffer("http://baidu.lecai.com/lottery/draw/list/50?d=");
        urlBuf.append(dateFormat.format(initTime));
        String htmlStr = this.getLotteryHtmlFromHttp(urlBuf.toString());
        List<LotteryTicket> lotteryList = this.parseHtml2Beans(htmlStr);
        
        try
        {
            LotteryTicket lottery = null;
            Iterator<LotteryTicket> lotteryIter = lotteryList.iterator();
            while (lotteryIter.hasNext())
            {
                lottery = lotteryIter.next();
                this.lotteryService.addLotteryTicket(lottery);
                Thread.currentThread();
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
    public List<LotteryTicket> parseHtml2Beans(String htmlStr)
    {
        try
        {
            Pattern pattern = Pattern.compile(regexTr);
            Matcher matcher = pattern.matcher(htmlStr.toString());
            List<String> trList = new ArrayList<String>();
            while (matcher.find())
            {
                String matchStr = matcher.group();
                trList.add(matchStr);
            }

            String trStr = null;
            LotteryTicket lottery = null;
            List<LotteryTicket> lotteryList = new ArrayList<LotteryTicket>();
            Iterator<String> trIter = trList.iterator();
            while (trIter.hasNext())
            {
                trStr = trIter.next();
                logger.info("解析tr:{}",trStr);
                lottery = this.parseTr2Bean(trStr);
                lotteryList.add(lottery);
            }
            
            return lotteryList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public LotteryTicket parseTr2Bean(String trStr)
    {
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LotteryTicket lottery = new LotteryTicket();
            Pattern td1Pattern = Pattern.compile(regexTd1);
            Matcher td1Matcher = td1Pattern.matcher(trStr);
            if (td1Matcher.find())
            {
                Pattern datePattern = Pattern.compile(regexDate);
                Matcher dateMatcher = datePattern.matcher(td1Matcher.group());
                if (dateMatcher.find())
                {
                    lottery.setLotteryRunTime(dateFormat.parse(dateMatcher.group()));
                }
            }
            
            Pattern td2Pattern = Pattern.compile(regexTd2);
            Matcher td2Matcher = td2Pattern.matcher(trStr);
            if (td2Matcher.find())
            {
                Pattern periodPattern = Pattern.compile(regexPeriodNum);
                Matcher periodMatcher = periodPattern.matcher(td2Matcher.group());
                if (periodMatcher.find())
                {
                    lottery.setLotteryPeriodNum(Integer.valueOf(periodMatcher.group().substring(1)));
                }
            }
            
            Pattern td3Pattern = Pattern.compile(regexTd3);
            Matcher td3Matcher = td3Pattern.matcher(trStr);
            if (td3Matcher.find())
            {
                String lotteryStr = td3Matcher.group();
                
                Pattern ballNumPattern = Pattern.compile(regexBallNum);
                
                Pattern redBallPattern = Pattern.compile(regexRedBall);
                Matcher redBallMatcher = redBallPattern.matcher(lotteryStr);
                int i = 1;
                while (redBallMatcher.find())
                {
                    Matcher ballNumMatcher = ballNumPattern.matcher(redBallMatcher.group());
                    ballNumMatcher.find();
                    if (i == 1)
                    {
                        
                        lottery.setLotteryRedFirst(ballNumMatcher.group());
                    }
                    else if (i == 2)
                    {
                        lottery.setLotteryRedSecond(ballNumMatcher.group());
                    }
                    else if (i == 3)
                    {
                        lottery.setLotteryRedThird(ballNumMatcher.group());
                    }
                    else if (i == 4)
                    {
                        lottery.setLotteryRedFourth(ballNumMatcher.group());
                    }
                    else if (i == 5)
                    {
                        lottery.setLotteryRedFifth(ballNumMatcher.group());
                    }
                    else if (i == 6)
                    {
                        lottery.setLotteryRedSixth(ballNumMatcher.group());
                    }
                        
                    i++;
                }
                
                Pattern blueBallPattern = Pattern.compile(regexBlueBall);
                Matcher blueBallMatcher = blueBallPattern.matcher(lotteryStr);
                if (blueBallMatcher.find())
                {
                    Matcher ballNumMatcher = ballNumPattern.matcher(blueBallMatcher.group());
                    ballNumMatcher.find();
                    lottery.setLotteryBlueFirst(ballNumMatcher.group());
                }
            }
            
            Pattern td4Pattern = Pattern.compile(regexTd4);
            Matcher td4Matcher = td4Pattern.matcher(trStr);
            if (td4Matcher.find())
            {
                Pattern saleValumePattern = Pattern.compile(regexSaleVolume);
                Matcher saleValumeMatcher = saleValumePattern.matcher(td4Matcher.group());
                if (saleValumeMatcher.find())
                {
                    String saleValume = saleValumeMatcher.group();
                    lottery.setLotterySaleVolume(saleValume.substring(1).replaceAll(",", ""));
                }
            }
            
            return lottery;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private String getLotteryHtmlFromHttp(String urlPath)
    {
        try
        {
            URL url = new URL(urlPath);
            HttpURLConnection httpConnect = (HttpURLConnection) url.openConnection();
            httpConnect.setConnectTimeout(10000);
            httpConnect.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnect.getInputStream()));
            String lines;
            StringBuffer htmlBuf = new StringBuffer();
            while ((lines = reader.readLine()) != null)
            {
                htmlBuf.append(lines);
            }
            reader.close();
            
            System.out.println(htmlBuf.toString());

            return htmlBuf.toString();
        }
        catch (Exception e)
        {
            e.fillInStackTrace();
            return null;
        }

    }
    
    public final static String regexTr = "<tr\\s*class=\"bgcolor[1,2]{1}\">\\s*<td\\s*class=\"td1\">[\\d-]*</td>\\s*<td\\s*class=\"td2\">\\s*<a\\s*href=\"[/\\w?=]*\">\\d*</a>\\s*</td>\\s*<td\\s*class=\"td3\">\\s*<span\\s*class=\"result\">[\\s*<span\\s*class=\"\\w*\">\\d*</span>\\s*]*</span>\\s*</td>\\s*<td\\s*class=\"td4\">[\\d,]*</td>\\s*</tr>";

    public final static String regexTd1 = "<td\\s*class=\"td1\">[\\d-]*</td>";
    
    public final static String regexDate = "\\d{4}-\\d{2}-\\d{2}";

    public final static String regexTd2 = "<a\\s*href=\"[/\\w?=]*\">\\d*</a>";
    
    public final static String regexPeriodNum = ">\\d*";

    public final static String regexTd3 = "<td\\s*class=\"td3\">\\s*<span\\s*class=\"result\">[\\s*<span\\s*class=\"\\w*\">\\d*</span>\\s*]*</span>\\s*</td>";
    
    public final static String regexBallNum = "\\d{2}";
    
    public final static String regexRedBall = "<span\\s*class=\"ball_1\">\\d{2}</span>";
    
    public final static String regexBlueBall = "<span\\s*class=\"ball_2\">\\d{2}</span>";
    
    public final static String regexTd4 = "<td\\s*class=\"td4\">[\\d,]*</td>";
    
    public final static String regexSaleVolume = ">[\\d,]*";

}

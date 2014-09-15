package com.chen.lottery.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.chen.lottery.service.AutoInitLotteryDataService;

public class AutoInitLotteryDataListener implements ServletContextListener
{
    public static Logger logger = LoggerFactory.getLogger(AutoInitLotteryDataListener.class); 
    
    private static ServletContext context = null;
    
    public void contextDestroyed(ServletContextEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    public void contextInitialized(ServletContextEvent event)
    {
        context = event.getServletContext();
        Thread thread = new Thread(){
            public void run()
            {
                while(true)
                {
                    try
                    {
                        System.out.println("初始化：autoInitLotterData");
                        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);  
                        AutoInitLotteryDataService dataService = wac.getBean(AutoInitLotteryDataService.class);
                        dataService.autoInitLotterData();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        try
                        {
                            Thread.currentThread();
                            Thread.sleep(300000);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        
        thread.start();
            
    }

}

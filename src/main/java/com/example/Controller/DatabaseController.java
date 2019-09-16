package com.example.Controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.example.config.ApplicationContextUtil;
import com.example.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "/dbtest")
public class DatabaseController {

    @RequestMapping("/w")
    public String world(int cou,ModelMap map) {
        DruidDataSource ds = ApplicationContextUtil.getBean("jpaDataSource", DruidDataSource.class);
        ExecutorService threadPool = new ThreadPoolExecutor(cou, 2000,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        for(int i = 0 ;i < cou;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    DruidPooledConnection dpc = null;
                    try {
                        dpc = ds.getConnection();
                        Thread.sleep(100);
                        dpc.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        };
        map.addAttribute("host", "http://www.shanshan.com");
        return "world";
    }
}

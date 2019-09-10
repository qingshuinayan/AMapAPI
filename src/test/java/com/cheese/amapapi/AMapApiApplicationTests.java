package com.cheese.amapapi;

import com.cheese.amapapi.dao.DataCenter;
import com.cheese.amapapi.dao.RouteDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AMapApiApplicationTests {
    @Autowired
    RouteDao routeDao;
    @SpyBean
    DataCenter dataCenter;
    Random random = new Random();

    @Test
    public void contextLoads() throws InterruptedException {
        // 116.239555,40.024643
        // 116.520689,39.827219
        when(dataCenter.getPort()).thenReturn("1111");

        AtomicInteger failedNum = new AtomicInteger();
        AtomicInteger successNum = new AtomicInteger();
        Integer loopNum = 1000;
        Date startTime = new Date();

        CountDownLatch wait = new CountDownLatch(loopNum);
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < loopNum; i++) {
            threadPool.submit(() -> {
                try {
                    String result = routeDao.getDriverPlan(
                            randomNum(116.239555, 116.520689),
                            randomNum(39.827219, 40.024643),
                            randomNum(116.239555, 116.520689),
                            randomNum(39.827219, 40.024643),
                            "LEAST_DISTANCE"
                    );
                    successNum.addAndGet(1);
                } catch (Exception e) {
                    failedNum.addAndGet(1);
                    e.printStackTrace();
                } finally {
                    wait.countDown();
                }
            });
        }

        wait.await(200, TimeUnit.SECONDS);

        System.out.println("[All]: " + loopNum);
        System.out.println("[Failed]: " + failedNum.get());
        System.out.println("[Success]: " + successNum.get());
        System.out.println("[Using Time]: " + (new Date().getTime() - startTime.getTime()));
    }

    @Test
    public void testOnce () throws InterruptedException {
        when(dataCenter.getPort()).thenReturn("1111");
        String result = routeDao.getDriverPlan(
                randomNum(116.239555, 116.520689),
                randomNum(39.827219, 40.024643),
                randomNum(116.239555, 116.520689),
                randomNum(39.827219, 40.024643),
                "LEAST_DISTANCE"
        );
        System.out.println(result);
    }

    private Double randomNum (Double min, Double max) {
        return random.nextDouble() * (max - min) + min;
    }
}

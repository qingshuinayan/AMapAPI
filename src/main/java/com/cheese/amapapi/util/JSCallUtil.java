package com.cheese.amapapi.util;

import com.cheese.amapapi.bean.CallbackBean;
import com.cheese.amapapi.dao.DataCenter;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Icemap
 * @date 2019-09-09 15:56
 */
@Component
public class JSCallUtil {
    @Autowired
    DataCenter center;

    public String callJSFunc (HtmlPage routePage, String jsRunScript, String callbackId) throws InterruptedException {
        // Sync -> Async
        AtomicReference<String> data = new AtomicReference<>();
        CountDownLatch waitCount = new CountDownLatch(1);
        center.getWebClient().setAlertHandler((page, message) -> {
            CallbackBean callbackBean = new Gson().fromJson(message, CallbackBean.class);
            if (page.hashCode() == routePage.hashCode() && callbackBean.getId().equals(callbackId)) {
                data.set(callbackBean.getData());
                waitCount.countDown();
            }
        });

        routePage.executeJavaScript(jsRunScript);

        waitCount.await(20, TimeUnit.SECONDS);
        return data.get();
    }
}

package com.cheese.amapapi.dao;

import com.cheese.amapapi.bean.CallbackBean;
import com.cheese.amapapi.util.JSCallUtil;
import com.cheese.amapapi.util.SnowFlakeUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Icemap
 * @date 2019-09-06 16:33
 */
@Component
public class RouteDao {

    @Autowired
    DataCenter center;
    @Autowired
    SnowFlakeUtil snowFlakeUtil;
    @Autowired
    JSCallUtil jsCallUtil;

    public String getDriverPlan (Double sX, Double sY, Double eX, Double eY, String policy) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getRoutePage(client),
                buildDriverJSFunc(callbackId, policy, sX, sY, eX, eY), callbackId);
    }

    public String getBusPlan (Double sX, Double sY, Double eX, Double eY, String cityName, String policy) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getRoutePage(client), buildBusJSFunc(callbackId, policy, sX, sY, eX, eY, cityName), callbackId);
    }

    public String getWalkPlan (Double sX, Double sY, Double eX, Double eY) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getRoutePage(client), buildWalkJSFunc(callbackId, sX, sY, eX, eY), callbackId);
    }

    public String getRidePlan (Double sX, Double sY, Double eX, Double eY) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getRoutePage(client), buildRideJSFunc(callbackId, sX, sY, eX, eY), callbackId);
    }

    private String buildBusJSFunc (String callbackId, String policy, Double sX, Double sY, Double eX, Double eY, String cityName) {
        return "routeBus(\"" + callbackId + "\"" + sX + "," + sY + "," + eX + "," + eY + ",\"" + policy + "\",\"" + cityName + "\");";
    }

    private String buildDriverJSFunc (String callbackId, String policy, Double sX, Double sY, Double eX, Double eY) {
        return "routeDriver(\"" + callbackId + "\"," + sX + "," + sY + "," + eX + "," + eY + ",\"" + policy + "\");";
    }

    private String buildWalkJSFunc (String callbackId, Double sX, Double sY, Double eX, Double eY) {
        return "routeWalk(\"" + callbackId + "\"," + sX + "," + sY + "," + eX + "," + eY + ");";
    }

    private String buildRideJSFunc (String callbackId, Double sX, Double sY, Double eX, Double eY) {
        return "routeRide(\"" + callbackId + "\"," + sX + "," + sY + "," + eX + "," + eY + ");";
    }
}

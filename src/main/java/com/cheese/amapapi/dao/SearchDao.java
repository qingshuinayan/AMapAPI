package com.cheese.amapapi.dao;

import com.cheese.amapapi.util.JSCallUtil;
import com.cheese.amapapi.util.SnowFlakeUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Icemap
 * @date 2019-09-09 16:49
 */
@Component
public class SearchDao {
    @Autowired
    DataCenter center;
    @Autowired
    SnowFlakeUtil snowFlakeUtil;
    @Autowired
    JSCallUtil jsCallUtil;

    public String getAutoComplete (String keyword, String city) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildAutoCompleteJSFunc(callbackId, keyword, city), callbackId);
    }

    public String getPlaceSearch (String keyword, String city, String type) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildPlaceSearchJSFunc(callbackId, keyword, city, type), callbackId);
    }

    public String getPlaceSearchByCenter (String keyword, String type, Double x, Double y, Double r) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildPlaceSearchByCenterJSFunc(callbackId, keyword, type, x, y, r), callbackId);
    }

    public String getPlaceSearchByEnvelop (String keyword, String type, Double left, Double top, Double right, Double bottom) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildPlaceSearchByEnvelopJSFunc(callbackId, keyword, type, left, top, right, bottom), callbackId);
    }

    public String getDistrictSearch (String keyword, String level, Boolean border, Integer subLevel) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildDistrictSearchJSFunc(callbackId, keyword, level, border, subLevel), callbackId);
    }

    public String getBusLineSearch (String keyword, String city) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildBusLineSearchJSFunc(callbackId, keyword, city), callbackId);
    }

    public String getBusStationSearch (String keyword, String city) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getSearchPage(client), buildBusStationSearchJSFunc(callbackId, keyword, city), callbackId);
    }

    private String buildAutoCompleteJSFunc (String callbackId, String keyword, String city) {
        return "autoComplete(\"" + callbackId + "\",\"" + keyword + "\",\"" + city + "\");";
    }

    private String buildPlaceSearchJSFunc (String callbackId, String keyword, String city, String type) {
        return "placeSearch(\"" + callbackId + "\",\"" + keyword + "\",\"" + city + "\",\"" + type + "\");";
    }

    private String buildPlaceSearchByCenterJSFunc (String callbackId, String keyword, String type, Double x, Double y, Double r) {
        return "placeSearchByCenter(\"" + callbackId + "\",\"" + keyword + "\",\"" + type + "\"," + x + "," + y + "," + r + ");";
    }

    private String buildPlaceSearchByEnvelopJSFunc (String callbackId, String keyword, String type, Double left, Double top, Double right, Double bottom) {
        return "placeSearchByEnvelop(\"" + callbackId + "\",\"" + keyword + "\",\"" + type + "\"," + left + "," + top + "," + right + "," + bottom + ");";
    }

    private String buildDistrictSearchJSFunc (String callbackId, String keyword, String level, Boolean border, Integer subLevel) {
        return "districtSearch(\"" + callbackId + "\",\"" + keyword + "\",\"" + level + "\"," + border + "," + subLevel + ");";
    }

    private String buildBusLineSearchJSFunc (String callbackId, String keyword, String city) {
        return "busLineSearch(\"" + callbackId + "\",\"" + keyword + "\",\"" + city + "\");";
    }

    private String buildBusStationSearchJSFunc (String callbackId, String keyword, String city) {
        return "busStationSearch(\"" + callbackId + "\",\"" + keyword + "\",\"" + city + "\");";
    }
}

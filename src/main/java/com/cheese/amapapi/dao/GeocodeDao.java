package com.cheese.amapapi.dao;

import com.cheese.amapapi.util.JSCallUtil;
import com.cheese.amapapi.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Icemap
 * @date 2019-09-09 15:55
 */
@Component
public class GeocodeDao {
    @Autowired
    DataCenter center;
    @Autowired
    SnowFlakeUtil snowFlakeUtil;
    @Autowired
    JSCallUtil jsCallUtil;

    public String getGeocode (String address, String city) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        return jsCallUtil.callJSFunc(center.getGeoCodePage(), buildGeocodeJSFunc(callbackId, address, city), callbackId);
    }

    public String getReGeocode (Double x, Double y) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        return jsCallUtil.callJSFunc(center.getGeoCodePage(), buildReGeocodeJSFunc(callbackId, x, y), callbackId);
    }

    private String buildGeocodeJSFunc (String callbackId, String address, String city) {
        return "geocode(\"" + callbackId + "\",\"" + address + "\",\"" + city + "\");";
    }

    private String buildReGeocodeJSFunc (String callbackId, Double x, Double y) {
        return "reGeocode(\"" + callbackId + "\"," + x + "," + y + ");";
    }
}

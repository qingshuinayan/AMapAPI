package com.cheese.amapapi.service;

import com.cheese.amapapi.dao.RouteDao;
import com.cheese.amapapi.exception.JSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Icemap
 * @date 2019-09-06 14:46
 */
@Service
public class RouteService {
    @Autowired
    RouteDao routeDao;

    public String getDriverResult (Double sX, Double sY, Double eX, Double eY, String policy) {
        try {
            return routeDao.getDriverPlan(sX, sY, eX, eY, policy);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getBusResult (Double sX, Double sY, Double eX, Double eY, String cityName, String policy) {
        try {
            return routeDao.getBusPlan(sX, sY, eX, eY, cityName, policy);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getWalkResult (Double sX, Double sY, Double eX, Double eY) {
        try {
            return routeDao.getWalkPlan(sX, sY, eX, eY);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getRideResult (Double sX, Double sY, Double eX, Double eY) {
        try {
            return routeDao.getRidePlan(sX, sY, eX, eY);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }
}

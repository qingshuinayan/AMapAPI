package com.cheese.amapapi.controller;

import com.cheese.amapapi.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Icemap
 * @date 2019-09-06 15:05
 */
@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    /**
     * Get Driver Plan Result
     * @param sX Start Point Lat
     * @param sY Start Point Lon
     * @param eX End Point Lat
     * @param eY End Point Lon
     * @param policy Driver Policy, Enable Value: LEAST_TIME（Fast First）, LEAST_FEE（Cheap First）,
     *               LEAST_DISTANCE (Distance First), REAL_TRAFFIC (Real Time Traffic)
     * @return Plan Json
     */
    @GetMapping("/driver")
    public String getDriverPlan (Double sX, Double sY, Double eX, Double eY, String policy) {
        return routeService.getDriverResult(sX, sY, eX, eY, policy);
    }

    /**
     * Get Bus Plan Result
     * @param sX Start Point Lat
     * @param sY Start Point Lon
     * @param eX End Point Lat
     * @param eY End Point Lon
     * @param policy Bus Policy, Enable Value: LEAST_TIME（Fast First）, LEAST_FEE（Cheap First）,
     *               LEAST_TRANSFER (Transfer Num First), MOST_COMFORT (Comfortable Level First),
     *               NO_SUBWAY (Hate Subway), LEAST_WALK (Walk Distance First)
     * @return Plan Json
     */
    @GetMapping("/bus")
    public String getBusPlan (Double sX, Double sY, Double eX, Double eY, String cityName, String policy) {
        return routeService.getBusResult(sX, sY, eX, eY, cityName, policy);
    }

    /**
     * Get Walk Plan Result
     * @param sX Start Point Lat
     * @param sY Start Point Lon
     * @param eX End Point Lat
     * @param eY End Point Lon
     * @return Plan Json
     */
    @GetMapping("/walk")
    public String getWalkPlan (Double sX, Double sY, Double eX, Double eY) {
        return routeService.getWalkResult(sX, sY, eX, eY);
    }

    /**
     * Get Ride Plan Result
     * @param sX Start Point Lat
     * @param sY Start Point Lon
     * @param eX End Point Lat
     * @param eY End Point Lon
     * @return Plan Json
     */
    @GetMapping("/ride")
    public String getRidePlan (Double sX, Double sY, Double eX, Double eY) {
        return routeService.getRideResult(sX, sY, eX, eY);
    }
}

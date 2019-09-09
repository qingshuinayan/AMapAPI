package com.cheese.amapapi.controller;

import com.cheese.amapapi.service.GeocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Icemap
 * @date 2019-09-09 15:26
 */
@RestController
@RequestMapping("/geocode")
public class GeocodeController {
    @Autowired
    GeocodeService geocodeService;

    @GetMapping
    public String getGeocode (String address, String city) {
        return geocodeService.getGeocodeResult(address, city);
    }

    @GetMapping("/reverse")
    public String getReGeocode (Double x, Double y) {
        return geocodeService.getReGeocodeResult(x, y);
    }
}

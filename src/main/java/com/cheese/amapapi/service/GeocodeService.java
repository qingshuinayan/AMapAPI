package com.cheese.amapapi.service;

import com.cheese.amapapi.dao.GeocodeDao;
import com.cheese.amapapi.exception.JSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Icemap
 * @date 2019-09-09 16:04
 */
@Service
public class GeocodeService {
    @Autowired
    GeocodeDao geocodeDao;

    public String getGeocodeResult (String address, String city) {
        try {
            return geocodeDao.getGeocode(address, city);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getReGeocodeResult (Double x, Double y) {
        try {
            return geocodeDao.getReGeocode(x, y);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }
}

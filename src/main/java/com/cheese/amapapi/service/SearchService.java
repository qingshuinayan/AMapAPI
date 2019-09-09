package com.cheese.amapapi.service;

import com.cheese.amapapi.dao.SearchDao;
import com.cheese.amapapi.exception.JSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Icemap
 * @date 2019-09-09 17:04
 */
@Service
public class SearchService {
    @Autowired
    SearchDao searchDao;

    public String getAutoCompleteResult (String keyword, String city) {
        try {
            return searchDao.getAutoComplete(keyword, city);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getPlaceSearchResult (String keyword, String city, String type) {
        try {
            return searchDao.getPlaceSearch(keyword, city, type);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getPlaceSearchByCenterResult (String keyword, String type, Double x, Double y, Double r) {
        try {
            return searchDao.getPlaceSearchByCenter(keyword, type, x, y, r);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getPlaceSearchByEnvelopResult (String keyword, String type, Double left, Double top, Double right, Double bottom) {
        try {
            return searchDao.getPlaceSearchByEnvelop(keyword, type, left, top, right, bottom);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getDistrictSearchResult (String keyword, String level, Boolean border, Integer subLevel) {
        try {
            return searchDao.getDistrictSearch(keyword, level, border, subLevel);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getBusLineSearchResult (String keyword, String city) {
        try {
            return searchDao.getBusLineSearch(keyword, city);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }

    public String getBusStationSearchResult (String keyword, String city) {
        try {
            return searchDao.getBusStationSearch(keyword, city);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }
}

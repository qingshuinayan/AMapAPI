package com.cheese.amapapi.controller;

import com.cheese.amapapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Icemap
 * @date 2019-09-09 17:08
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService searchService;

    /**
     * Use By Searching Input
     * @param keyword Search Key Word
     * @param city City Name
     * @return Input Hint List Json
     */
    @GetMapping
    public String getAutoComplete (String keyword, String city) {
        return searchService.getAutoCompleteResult(keyword, city);
    }

    /**
     * Place Search By City
     * @param keyword Search Key Word
     * @param city City Name
     * @param type Place Type
     * @return Place List
     */
    @GetMapping("/place/byCity")
    public String getPlaceSearchResult (String keyword, String city, String type) {
        if (type == null || type.equals("")) {
            type = "餐饮服务|商务住宅|生活服务";
        }
        return searchService.getPlaceSearchResult(keyword, city, type);
    }

    /**
     * Place Search By Center
     * @param keyword Search Key Word
     * @param type Place Type
     * @param x Center X
     * @param y Center Y
     * @param r Search Radius
     * @return Place List
     */
    @GetMapping("/place/byCenter")
    public String getPlaceSearchByCenterResultResult (String keyword, String type, Double x, Double y, Double r) {
        if (type == null || type.equals("")) {
            type = "餐饮服务|商务住宅|生活服务";
        }
        return searchService.getPlaceSearchByCenterResult(keyword, type, x, y, r);
    }

    /**
     * Place Search By Envelop
     * @param keyword Search Key Word
     * @param type Place Type
     * @param left Left Border
     * @param top Top Border
     * @param right Right Border
     * @param bottom Bottom Border
     * @return Place List
     */
    @GetMapping("/place/byBound")
    public String getPlaceSearchResult (String keyword, String type, Double left, Double top, Double right, Double bottom) {
        if (type == null || type.equals("")) {
            type = "餐饮服务|商务住宅|生活服务";
        }
        return searchService.getPlaceSearchByEnvelopResult(keyword, type, left, top, right, bottom);
    }

    /**
     * District Search (行政区搜索)
     * @param keyword Search Key Word
     * @param level country / province / city / district / biz_area
     * @param border Return Border
     * @param subLevel Return Sub District Level
     * @return District List
     */
    @GetMapping("/district")
    public String getDistrictSearchResult (String keyword, String level, Boolean border, Integer subLevel) {
        return searchService.getDistrictSearchResult(keyword, level, border, subLevel);
    }

    /**
     * Bus Line Search
     * @param keyword Search Key Word
     * @param city City Name
     * @return Bus Line Search List
     */
    @GetMapping("/line")
    public String getBusLineSearchResult (String keyword, String city) {
        return searchService.getBusLineSearchResult(keyword, city);
    }

    /**
     * Bus Station Search
     * @param keyword Search Key Word
     * @param city City Name
     * @return Bus Line Search List
     */
    @GetMapping("/station")
    public String getBusStationSearchResult (String keyword, String city) {
        return searchService.getBusStationSearchResult(keyword, city);
    }
}
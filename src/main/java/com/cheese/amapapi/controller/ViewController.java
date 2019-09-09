package com.cheese.amapapi.controller;

import com.cheese.amapapi.conf.AMapAPIConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Icemap
 * @date 2019-09-09 14:08
 */
@Controller
@RequestMapping("/")
public class ViewController {
    @Autowired
    AMapAPIConf conf;

    @GetMapping("/route.html")
    public String route (Model model) {
        model.addAttribute("apiKey", conf.getKey());
        return "route";
    }

    @GetMapping("/geocode.html")
    public String geocode (Model model) {
        model.addAttribute("apiKey", conf.getKey());
        return "geocode";
    }

    @GetMapping("/search.html")
    public String search (Model model) {
        model.addAttribute("apiKey", conf.getKey());
        return "search";
    }
}

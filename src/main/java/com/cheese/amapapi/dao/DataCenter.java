package com.cheese.amapapi.dao;

import com.cheese.amapapi.exception.JSException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Icemap
 * @date 2019-09-06 16:32
 */
@Component
public class DataCenter {
    @Autowired
    Environment environment;
    private WebClient webClient;

    @PostConstruct
    public void onInit () {
        webClient = new WebClient();
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    }

    public String getPort (){
        return environment.getProperty("local.server.port");
    }

    public WebClient getWebClient () {
        return webClient;
    }

    public HtmlPage getRoutePage () {
        try {
            return webClient.getPage("http://localhost:" + getPort() + "/route.html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSException(e.getMessage());
        }
    }

    public HtmlPage getGeoCodePage () {
        try {
            return webClient.getPage("http://localhost:" + getPort() + "/geocode.html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSException(e.getMessage());
        }
    }

    public HtmlPage getSearchPage () {
        try {
            return webClient.getPage("http://localhost:" + getPort() + "/search.html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSException(e.getMessage());
        }
    }
}

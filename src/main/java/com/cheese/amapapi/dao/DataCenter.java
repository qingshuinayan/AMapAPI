package com.cheese.amapapi.dao;

import com.cheese.amapapi.exception.JSException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @author Icemap
 * @date 2019-09-06 16:32
 */
@Component
public class DataCenter {
    @Autowired
    Environment environment;

    public String getPort (){
        return environment.getProperty("local.server.port");
    }

    @PostConstruct
    public void onInit () {
        java.util.logging.Logger.getLogger("c.g.htmlunit").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

    }

    public HtmlPage getRoutePage (WebClient webClient) {
        try {
            return webClient.getPage("http://localhost:" + getPort() + "/route.html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSException(e.getMessage());
        }
    }

    public HtmlPage getGeoCodePage (WebClient webClient) {
        try {
            return webClient.getPage("http://localhost:" + getPort() + "/geocode.html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSException(e.getMessage());
        }
    }

    public HtmlPage getSearchPage (WebClient webClient) {
        try {
            return webClient.getPage("http://localhost:" + getPort() + "/search.html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new JSException(e.getMessage());
        }
    }
}

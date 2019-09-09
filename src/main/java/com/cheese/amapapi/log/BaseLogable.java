package com.cheese.amapapi.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseLogable implements Logable {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public Logger getLogger() {
        return logger;
    }
}

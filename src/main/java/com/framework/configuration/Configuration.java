package com.framework.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configuration.properties")
public interface Configuration extends Config {

    @DefaultValue("CHROME")
    String browserName();

    String applicationAddress();

    String gridHubURL();

}

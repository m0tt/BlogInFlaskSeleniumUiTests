package com.framework.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configuration.properties")
public interface Configuration extends Config {

    @DefaultValue("LOCAL")
    String driverType();

    @DefaultValue("CHROME")
    String browserType();

    String applicationAddress();

    String gridHubURL();

}

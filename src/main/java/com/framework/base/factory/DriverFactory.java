package com.framework.base.factory;

import com.framework.configuration.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverFactory{

    private static Configuration configuration = ConfigFactory.create(Configuration.class);
    private WebDriver webDriver;
    private LocalDriverFactory localDriverFactory = new LocalDriverFactory();
    private RemoteDriverFactory remoteDriverFactory = new RemoteDriverFactory();

    public WebDriver getDriverType() throws MalformedURLException {
        String driverType = configuration.driverType();

        switch (driverType) {
            case "LOCAL":
                webDriver = localDriverFactory.getLocalDriver();
                break;
            case "REMOTE":
                webDriver = remoteDriverFactory.getRemoteDriver();
                break;
        }
        return webDriver;

    }


}

package com.framework.base.factory;

import com.framework.configuration.Configuration;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class RemoteDriverFactory {
    private static Configuration configuration = ConfigFactory.create(Configuration.class);

    public WebDriver getDriver() throws MalformedURLException {
        DriverManagerType driverType;
        WebDriver driver;
        driverType = DriverManagerType.valueOf(configuration.browserName());
        URL gridHubURL = new URL(configuration.gridHubURL());

        switch (driverType) {
            case CHROME:
                driver = new RemoteWebDriver(gridHubURL, new ChromeOptions());
                break;
            case FIREFOX:
                driver = new RemoteWebDriver(gridHubURL, new FirefoxOptions());
                break;
            case EDGE:
                driver = new RemoteWebDriver(gridHubURL, new EdgeOptions());
                break;
            default:
                driver = new RemoteWebDriver(gridHubURL, new ChromeOptions());
                break;
        }
        return driver;
    }
}

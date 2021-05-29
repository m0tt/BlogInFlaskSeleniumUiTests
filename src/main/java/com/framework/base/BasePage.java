package com.framework.base;

import com.framework.base.factory.PageFactory;
import com.framework.configuration.Configuration;
import com.framework.pages.LoginPage;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private static Configuration configuration = ConfigFactory.create(Configuration.class);
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected PageFactory pageFactory;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        pageFactory = new PageFactory(driver);
    }

    public LoginPage open() {
        driver.get(configuration.applicationAddress());
        return pageFactory.createPage(LoginPage.class);
    }

}

package com.framework.base.factory;

import com.framework.base.BasePage;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    private WebDriver driver;

    public PageFactory(WebDriver driver){
        this.driver = driver;
    }

    public <T extends BasePage> T createPage(Class<T> pageClassToProxy){
        return org.openqa.selenium.support.PageFactory.initElements(driver, pageClassToProxy);
    }

}

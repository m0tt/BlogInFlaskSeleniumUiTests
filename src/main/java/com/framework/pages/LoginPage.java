package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) { super(driver); }

    @FindBy(id="username")
    WebElement userNameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(className = "alert-info")
    WebElement alertMessage;

    @FindBy(id = "remember_me")
    WebElement rememberMeInput;

    @FindBy(partialLinkText = "Click to Register")
    WebElement registerLink;

    public LoginPage setUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage submitWithoutSuccess() {
        submitButton.click();
        return this;
    }

    public LoginPage clickOnRememberMe() {
        rememberMeInput.click();
        return this;
    }

    public String getAlertText() {
        String alertText = alertMessage.getText();
        return alertText;
    }

    public boolean isAlertMessageDisplayed() {
        return webDriverWait.until(webDriver -> alertMessage.isDisplayed());
    }

    public RegisterPage clickOnRegisterLink(){
        registerLink.click();
        return pageFactory.createPage(RegisterPage.class);
    }
}

package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends LoginPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="username")
    WebElement userNameInput;

    @FindBy(id="email")
    WebElement emailInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(id="password2")
    WebElement repeatPasswordInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(className = "help-block")
    WebElement alertMessage;

    public RegisterPage setUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    public RegisterPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegisterPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage setRepeatPassword(String password) {
        repeatPasswordInput.sendKeys(password);
        return this;
    }

    public RegisterPage submitWithoutSuccess() {
        submitButton.click();
        return this;
    }

    public String getAlertText() {
        String alertText = alertMessage.getText();
        return alertText;
    }

}

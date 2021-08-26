package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends HomePage {
    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "title")
    WebElement titleInput;

    @FindBy(id = "body")
    WebElement bodyInput;

    @FindBy(id = "submit")
    WebElement createButton;

    @FindBy(xpath = ".//input[@value='Delete Post']")
    WebElement deleteButton;

    @FindBy(className = "alert-info")
    WebElement alertMessage;

    public CreatePostPage setTitle(String title) {
        titleInput.sendKeys(title);
        return this;
    }

    public String getTitle() {
        return titleInput.getAttribute("value");
    }

    public CreatePostPage setContent(String content) {
        bodyInput.sendKeys(content);
        return this;
    }

    public String getContent() {
        return bodyInput.getText();
    }

    public CreatePostPage clickCreateButtonWithSuccess() {
        createButton.click();
        return this;
    }

    public CreatePostPage clickDeleteButtonWithSuccess() {
        deleteButton.click();
        return this;
    }

    public HomePage clickDeleteConfirmationPopUpWithSuccess() {
        driver.switchTo().alert().accept();
        return pageFactory.createPage(HomePage.class);
    }

    public String getAlertText() {
        return alertMessage.getText();
    }
}
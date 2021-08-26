package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends LoginPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "label-danger")
    WebElement labelDangerMessage;

    @FindBy(partialLinkText = "Create")
    WebElement createLink;

    @FindBy(xpath = ".//p[@class='lead']/a[contains(text(),'Edit')]")
    WebElement editButton;

    /*@FindBy(xpath = ".//*[@class='col-lg-8']//*[@class='lead' or @class='mt-4']")*/
    @FindBy(xpath = ".//*[@class='col-lg-8']")
    List<WebElement> listOfPostDetails;

    public CreatePostPage clickCreateLink(){
        createLink.click();
        return pageFactory.createPage(CreatePostPage.class);
    }

    public CreatePostPage clickEditButton(){
        editButton.click();
        return pageFactory.createPage(CreatePostPage.class);
    }

    public String getLabelDangerText() {
        return labelDangerMessage.getText();
    }

    public List<String> getListOfPostDetails(){
        return listOfPostDetails.stream().map(WebElement::getText).map(s -> s.replaceAll("\n", " ")).collect(Collectors.toList());
    }
}

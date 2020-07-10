package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="inputUsername")
    private WebElement inputUsername;

    @FindBy(id="inputPassword")
    private WebElement inputPassword;

    @FindBy(id="submit-button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submit() {
        submitButton.submit();
    }

    public void enterUsername(String name) {
        inputUsername.sendKeys(name);
    }

    public void enterPassword(String name) {
        inputPassword.sendKeys(name);
    }

    public void login(String username, String password) {
        this.enterPassword(password);
        this.enterUsername(username);
        this.submit();
    }
}

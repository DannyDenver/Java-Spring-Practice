package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id="messageText")
    private WebElement inputMsageText;

    @FindBy(id="messageType")
    private WebElement selectedMessagetype;

    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(className = "chatMessageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void submit() {
        submitButton.submit();
    }

    public void enterMessage(String message) {
        inputMsageText.sendKeys(message);
    }

    public void selectMessagetype(String type){
        selectedMessagetype.sendKeys(type);
    }

    public ChatMessage getFirstMessage() {
        ChatMessage result = new ChatMessage();
        result.setMessagetext(firstMessageText.getText());
        result.setUsername(firstMessageUsername.getText());
        return result;
    }
}

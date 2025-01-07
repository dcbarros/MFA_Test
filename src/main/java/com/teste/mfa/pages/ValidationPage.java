package com.teste.mfa.pages;

import static com.teste.mfa.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.teste.mfa.core.BasePage;

public class ValidationPage extends BasePage{
    @FindBy(id = "validationCode")
    private WebElement validationCodeInput;

    @FindBy(xpath = "//button[.='Verify code']")
    private WebElement validateButton;

    private WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public ValidationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void setValidateCodeAndCompleteLogin(String validateCode){
        wait.until(ExpectedConditions.visibilityOf(validationCodeInput));
        setInputText(validationCodeInput, validateCode);
        wait.until(ExpectedConditions.elementToBeClickable(validateButton));
        validateButton.click();
    }
}

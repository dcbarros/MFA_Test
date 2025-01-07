package com.teste.mfa.pages;

import static com.teste.mfa.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.teste.mfa.core.BasePage;

public class RegisterPage extends BasePage{
    
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[.='Register']")
    private WebElement registerButton;
    @FindBy(id = "rememberMe")
    private WebElement checkbox2FA;

    private WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public RegisterPage(){
        PageFactory.initElements(getDriver(),this);
    }

    private void getRegisterPage(){
        getDriver().get("http://localhost:4200/register");
    }

    public void createNewUser(String firstname, String lastname, String email, String password) throws InterruptedException{
        
        getRegisterPage();
        setInputText(firstNameInput, firstname);
        setInputText(lastNameInput, lastname);
        setInputText(emailInput, email);
        setInputText(passwordInput, password);

        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        checkbox2FA.click();
        registerButton.click();

        Thread.sleep(4000);

    }
}

package com.teste.mfa.pages;

import static com.teste.mfa.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.teste.mfa.core.BasePage;

public class LoginPage extends BasePage{
    
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[.='Login']")
    private WebElement buttonLogin;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void doLogin(String email, String password){
        getLoginPage();
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    private void getLoginPage(){
        getDriver().get("http://localhost:4200/login");
    }
    
    private void setEmail(String email){
        setInputText(usernameInput, email);
    }

    private void setPassword(String password){
        setInputText(passwordInput, password);
    }

    private void clickLoginButton(){
        click(buttonLogin);
    }
}

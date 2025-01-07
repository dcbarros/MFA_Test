package com.teste.mfa.tests;

import static com.teste.mfa.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;

import com.teste.mfa.core.BaseTest;
import com.teste.mfa.pages.LoginPage;
import com.teste.mfa.pages.ValidationPage;
import com.teste.mfa.utils.TotpGenerator;

public class MFATest extends BaseTest {
    
    private LoginPage lp = new LoginPage();
    private ValidationPage vp = new ValidationPage();
    
    @Test
    public void test1() throws InterruptedException{

        lp.doLogin("test@example.com", "123456");

        try {
            vp.setValidateCodeAndCompleteLogin(TotpGenerator.generateTotpCode("Seu Segredo"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Thread.sleep(1000);

        Assert.assertTrue(
            getDriver().getCurrentUrl().contains("welcome")
        );
    }
        

}

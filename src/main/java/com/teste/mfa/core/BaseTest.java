package com.teste.mfa.core;

import static com.teste.mfa.core.DriverFactory.endDriver;

import org.junit.After;
// import org.junit.BeforeClass;

// import com.teste.mfa.pages.RegisterPage;

public class BaseTest {

    // private static RegisterPage rp = new RegisterPage();

    // @BeforeClass
    // public static void setup() throws InterruptedException{
    //     rp.createNewUser("teste", "teste", "test@example.com", "123456");
    // }

    @After
    public void endTest(){
        if(Properties.CLOSE_BROWSER){
            endDriver();
        }
    }

}

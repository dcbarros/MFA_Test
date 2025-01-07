package com.teste.mfa.core;

import org.openqa.selenium.WebElement;

public class BasePage {

	// TextInput

	protected void setInputText(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
	}

	// Button

	protected void click(WebElement button){
		button.click();
	}

    
}

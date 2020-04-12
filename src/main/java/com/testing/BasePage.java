package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	private final int timeOut =1000;
	public BasePage(WebDriver driver){
		this.driver=driver;

	}
	/*重写sendkes方法*/
	void sendkeys(WebElement element,String s){
		new WebDriverWait(driver,timeOut).until(ExpectedConditions.visibilityOf(element)); //加入显示等待
		element.clear();
		element.sendKeys(s);
	}
	/*重写click方法*/
	void click(WebElement element){
		new WebDriverWait(driver,timeOut).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
}

package com.testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WebElementsActionTest {
	WebDriver driver;
	@BeforeTest
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void clickTest(){
		driver.get("https://baidu.com");
		//定位元素-新闻链接
		WebElement newslink =driver.findElement(By.name("tj_trnews"));
		//操作元素-点击
		newslink.click();
		//获取结果-转到的URL
		String resultURL =driver.getCurrentUrl();
		//验证
		Assert.assertEquals(resultURL,"http://news.baidu.com/");

	}
	@Test
	public void sendkeysTest() throws InterruptedException{
		driver.get("https://baidu.com");
		//定位元素-输入框,输入内容
		//定位元素-button,点击
		WebElement keys =driver.findElement(By.id("kw"));
		keys.sendKeys("selenium");
		WebElement button = driver.findElement(By.id("su"));
		button.click();
		//等待时间，线程等待
		Thread.sleep(3000);
		//获取结果-获取页面title并验证
		Assert.assertEquals(driver.getTitle(),"selenium_百度搜索");

	}
	@Test
	public void clearTest() throws InterruptedException{
		driver.get("https://baidu.com");
		WebElement keys =driver.findElement(By.id("kw"));
		keys.sendKeys("selenium");
		Thread.sleep(3000);
		keys.clear();
		Thread.sleep(3000);
		Assert.assertEquals(keys.getText(),"");

	}
	@Test
	public void getTextTest(){
		driver.get("https://baidu.com");
		WebElement newslink =driver.findElement(By.name("tj_trnews"));		//获取 keys中的当前文本，验证是否为空
		String text1 =newslink.getText();
		Assert.assertEquals(text1,"新闻");
	}
	/*页面元素是否展示 isDisplayed*/
	@Test
	public void isDisplayedTest() {
		driver.get("https://baidu.com");
		//验证百度一下是否显示
		Assert.assertTrue(driver.findElement(By.id("su")).isDisplayed());
	}
	/*判断选择框是否被选中 isSelected*/
	@Test
	public void isSelectedTest() {
		driver.get("https://baidu.com");
		//验证百度一下是否显示
		Assert.assertTrue(driver.findElement(By.id("su")).isDisplayed());
	}

	/*判断元素是否被激活 isEnabled*/
	@Test
	public void isEnabledTest() {
		driver.get("https://baidu.com");
		//验证百度一下是否显示
		Assert.assertTrue(driver.findElement(By.id("su")).isEnabled());

	}

	/*Alert弹窗*/
	@Test
	public void alertTest() throws InterruptedException {
		driver.get("https://baidu.com");
		Alert alert =driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}

	/*iframe*/
	@Test
	public void iframeTest() throws InterruptedException {
		driver.get("https://baidu.com");
		Alert alert =driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
	}

	/*select*/
	@Test
	public void selectTest() throws InterruptedException {
		driver.get("https://baidu.com");
		WebElement selectEl = driver.findElement(By.id(""));
		Select select = new Select(selectEl);
		select.selectByIndex(2);
		select.selectByValue("optionValue");
		//select.selectByVisibleText();
	}
	@AfterTest
	public void after(){
		driver.close();
	}
}

package com.testing;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTestCase {

	//firefox 47及以下的不需要下载driver,selenium自带
	//private WebDriver driver = new FirefoxDriver();
	private WebDriver driver;

	/*@BeforeClass
	public void configDriver(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe");
		driver=new ChromeDriver(); //无参，打开一个空白浏览器
	}*/
	@BeforeClass
	public void configDriver(){
		System.setProperty("webdriver.gecko.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\geckodriver.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addPreference("browser.download.folderList","2");
		firefoxOptions.addPreference("browser.download.dir","d:\\soft");
		firefoxOptions.addPreference("browser.helperApps.neverAsk.SaveToDisk","application/octet-stream,application");
		//driver=new FirefoxDriver();
		driver = new FirefoxDriver(firefoxOptions);
	}
	@Test
	public void baidu_search(){

		UIDemoPage myPage = PageFactory.initElements(driver,UIDemoPage.class);
		driver.get("https://www.baidu.com");
		driver.manage().window().maximize();
		myPage.kw_sendkeys("火车票");
		myPage.su_click();
	}

	@Test
	public void f2(){
		Assert.assertEquals("b","b");
	}

	@Test
	public void browserAction(){
//		driver.manage().addCookie();

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://souhou.com");
//	设置浏览器窗口大学大小
		Dimension dimension = new Dimension(500,500);
		driver.manage().window().setSize(dimension);
		driver.manage().window().fullscreen();
		driver.manage().window().getPosition();

//		获取当前URL
		String url =driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url,"https://xxxx.com");
		driver.getTitle();
		driver.getWindowHandle();
	}


	@AfterClass
	public void after(){
		driver.close();
//		driver.quit();
	}

}

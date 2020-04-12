package com.testing;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExecuteJS {
	private WebDriver driver;

	@BeforeClass
	public void configDriver(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe");
		driver= new ChromeDriver(); //无参，打开一个空白浏览器
	}

	@Test
	public void executeJSTest() throws InterruptedException {
		driver.get("https://baidu.com");
		//将driver强转为一个JavascriptExecutor对象
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//执行一段JS代码
		js.executeScript("document.getElementById('kw').setAttribute('value'','aaa')");
		Thread.sleep(5000);
	}
	/*使用phantomJS打开无痕浏览器，做web测试
	*PhantomJSDriver
	*
	*  */
	@Test
	public void phantomJSTest()  {
		System.setProperty("phantomjs.binary.path","");
		WebDriver driver = new PhantomJSDriver();

		driver.get("https://baidu.com");
		//将driver强转为一个JavascriptExecutor对象
	}

}

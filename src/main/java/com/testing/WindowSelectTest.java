package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class WindowSelectTest
{
	WebDriver driver;
	@BeforeTest
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		/* 全局等待，隐士等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/
		WebDriverWait waitDriver = new WebDriverWait(driver,10);
		//显示等待
		waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));


	}
	/*open new window
	* switchTo new window handle
	* */
	@Test
	public void windowSwitchTest() {
		driver.get("https://baidu.com");
		WebElement windowTest = driver.findElement(By.linkText("open new window"));

		String handle1 = driver.getWindowHandle();//获取当前driver窗口句柄
		for (String handle:driver.getWindowHandles()){//获取当前所有窗口句柄
			if (handle.equals(handle1)){
				continue;//
			}else {
				driver.switchTo().window(handle);//转移到非当前窗口
			}
		}
		driver.findElement(By.linkText("new window's link"));
		driver.switchTo().window(handle1);//返回原来的窗口

	}


	@AfterTest
	public void after(){
		driver.close();
	}
}

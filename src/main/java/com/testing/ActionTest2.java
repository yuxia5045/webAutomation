package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest2 {
	WebDriver driver;
	String downloadfilepath;
	@BeforeTest
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe");
		HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups",0);
		chromePrefs.put("download.default_directory",downloadfilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs",chromePrefs);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

	@Test
	public void rightClickTest(){

		driver.get("https://baidu.com");
		WebElement buttonBaidu = driver.findElement(By.id("su"));
		// 初始化Actions 类对象
		Actions actions = new Actions(driver);
		//右键点击
		actions.contextClick().perform();
		//指定webElement对象上右键点击
		actions.contextClick(buttonBaidu).perform();
	}
	@Test
	public void doubleClickTest(){
		driver.get("https://baidu.com");
		WebElement buttonBaidu = driver.findElement(By.id("su"));
		// 初始化Actions 类对象
		Actions actions = new Actions(driver);
		//double click
		actions.doubleClick().perform();
		//指定webElement对象上右键点击
		actions.doubleClick(buttonBaidu).perform();
	}
	@Test
	public void moveToTest(){
		driver.get("https://baidu.com");
		WebElement buttonBaidu = driver.findElement(By.id("su"));
		// 初始化Actions 类对象
		Actions actions = new Actions(driver);
		//移动到指定webElement对象上
		actions.moveToElement(buttonBaidu).perform();
		//获取移动到某个元素上后的显示的文字
		String text = driver.findElement(By.xpath(".//*[text()='Hello World']")).getText();
		Assert.assertEquals(text,"Hello World");
	}
	@Test
	public void dragAndDropTest(){
		driver.get("https://baidu.com");
		WebElement source = driver.findElement(By.id("drag"));
		WebElement target =driver.findElement(By.id("target"));
		// 初始化Actions 类对象
		Actions actions = new Actions(driver);
		//先按住source,移动到target,然后放在target
		actions.clickAndHold(source)
				.moveToElement(target)
				.release()
				.perform();
		//拖拽source 到target
		actions.dragAndDrop(source,target).perform();
	}
	@Test
	public void multiSelectTest(){
		driver.get("https://baidu.com");
		WebElement element = driver.findElement(By.id("selectWithMultiElements"));
		List<WebElement> list =driver.findElements(By.xpath(""));
		Actions actions = new Actions(driver);
		//按住shift键，选择从0到2的选项
		actions.keyDown(Keys.SHIFT)
				.click(list.get(0))
				.click(list.get(2))
				.keyUp(Keys.SHIFT)
				.perform();

	}
	@Test
	public void saveASTest() throws AWTException, InterruptedException {
		driver.get("https://baidu.com");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);


	}

}

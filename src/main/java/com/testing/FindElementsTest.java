package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
	WebDriver webDriver;
	@BeforeMethod
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe\\");
		webDriver = new ChromeDriver();
	}

	@Test
	public void byIDTest(){
		webDriver.get("https://www.baidu.com");
		/** <span class="bg s_ipt_wr quickdelete-wrap">
		*  <span class="soutu-btn"></span><input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off">
		* <a href="javascript:;" id="quickdelete" title="清空" class="quickdelete" style="top: 0px; right: 0px; display: none;">
		* </a></span>
		* */
		//1.findElement(By.id(""))
		WebElement keyField =webDriver.findElement(By.id("kw") );//
		System.out.println(keyField.getTagName()+keyField.getLocation());

		//2.By.name

		WebElement keyField2 = webDriver.findElement(By.name("wd"));
		System.out.println(keyField2.getTagName());
		// 3.By.className
		webDriver.findElement(By.className(""));
		//4.By.linktext

		//5.By.partiallinktext

		//6.By.tagName j及findElements返回一个WebElements list
		List<WebElement> list = webDriver.findElements(By.tagName("input"));
		System.out.println(list.size());
		for (int i = 0; i <list.size() ; i++) {
			String text = list.get(i).getText();
			System.out.println(text);



		//7.xpath 重复标签下标从1开始
		WebElement keyField3 =webDriver.findElement(By.xpath(".//*[@id='kw']"));

		//8.css
		WebElement keyField4 =webDriver.findElement(By.cssSelector(""));
		}
	}

	}


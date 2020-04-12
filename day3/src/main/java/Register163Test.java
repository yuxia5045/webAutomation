import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register163Test {
	private WebDriver driver;

	@BeforeClass
	public void configDriver(){
		System.setProperty("webdriver.chrome.driver","E:\\Git\\workspace\\bili\\webAutomation\\drivers\\chromedriver.exe");
		driver=new ChromeDriver(); //无参，打开一个空白浏览器
	}

	@Test
	public void failedRegistertest1() throws InterruptedException {


		driver.get("https://www.163.com/");
		WebElement firstPage = driver.findElement(By.xpath("//*[@id='js_N_navLoginBefore']/div[2]/a"));
		firstPage.click();
		String handler1 = driver.getWindowHandle();
		for (String handler:driver.getWindowHandles())
			if (handler.equals(handler1))
				continue;
			else {
				driver.switchTo().window(handler);
			}
		String newURL = driver.getCurrentUrl();
		System.out.println(newURL);


		driver.findElement(By.id("username")).sendKeys("aaa");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		String errorTip =driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]")).getText();
		//String errorTip =driver.findElement(By.)
		Assert.assertEquals(errorTip,"长度应为6～18个字符");
		/*driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.className("j-register")).click();*/

	}
	@AfterClass
	public void after(){
		driver.close();
	}
}

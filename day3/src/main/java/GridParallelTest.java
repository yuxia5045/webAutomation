import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class GridParallelTest {
	private WebDriver dr;
	DesiredCapabilities dc;
	String baseurl;

	//使用parameters在testNg配置文件中指定浏览器类型和selenium grid 中的不同node，实现分发
	@BeforeMethod
	@Parameters({"browser","nodeUrl","webSite"})
	public void setup(String browser,String nodeUrl,String webSite){
		baseurl =webSite;
		if(browser.equals("ie")) dc =DesiredCapabilities.internetExplorer();
		else if(browser.equals("ff")) dc =DesiredCapabilities.firefox();
		else if (browser.equals("chrome")) dc =DesiredCapabilities.chrome();
		else System.out.println("browser参数有误，只能为ie,ff,chrome");

		String url =nodeUrl +"/wd/hub";
		URL urlInstance = null;
		try {
			urlInstance = new URL(url);
		}catch (MalformedURLException e)
		{
			e.printStackTrace();
			System.out.println("实例化url出错，检查url格式是否正确：http://192.168.40.67:5555");
		}
		dr = new RemoteWebDriver(urlInstance,dc);
		dr.get(webSite);
	}
	@Test
	public void test(){

		dr.get(baseurl);
		dr.findElement(By.id("kw")).sendKeys("selenimu");
		dr.findElement(By.id("su")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("title:"+dr.getTitle());
	}

	@AfterMethod
	public void quit(){
		dr.close();
	}




}


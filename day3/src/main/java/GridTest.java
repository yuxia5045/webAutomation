import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
	/*demo for Grid test using chrome driver*/
	@Test
	public void testGrid() throws InterruptedException {
		DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.100.131:4444/wd/hub"), chromeDC);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get("http://www.baidu.com");
		Thread.sleep(1000);
		driver.quit();
	}
/*using dataprovider of TestNG to implements multi-browser*/

	@Test(dataProvider = "data4")
	public void testGrid2(String browser,String url) throws InterruptedException, MalformedURLException {
		DesiredCapabilities dc = null;
		if (browser.equals("firefox")) {
			dc = DesiredCapabilities.firefox();
		} else if (browser.equals("chrome")) {
			dc = DesiredCapabilities.chrome();
		} else if (browser.equals("ie")) {
			dc = DesiredCapabilities.internetExplorer();
		} else {
			System.out.println("error");
		}
		WebDriver driver =new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
		driver.get("http://baidu.com");
		Thread.sleep(1000);
		driver.quit();


	}

	@DataProvider(name = "data4")
	public Object[][] test1() {
		return new Object[][]{
				{"firefox","http://192.168.3.102:5555"},
				{"chrome","http://192.168.3.102:6666"},
				{"ie","http://192.168.3.102:7777"}
		};
	}
}

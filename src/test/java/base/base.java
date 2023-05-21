package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class base<TakeScreenshot> {
	
	public static WebDriver driver;
	Properties prop;
	protected Logger log;
	
	
	
	@BeforeTest
	public void setup() throws IOException { 
		prop= new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/utilities/config.properties"); //file path
		prop.load(fis);  //to load property files

		String browser = prop.getProperty("browser"); //will get browser value from files and store it in browser
		
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		log = Logger.getLogger("my test logs");
		PropertyConfigurator.configure("log4j.properties");  //logfile
		log.info("opening url"+ prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		log.info("maximising window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
} 
	public void teardown() {
		driver.close();
	}
	public void captureScreen (String tname) throws IOException {
		TakeScreenshot ts = (TakeScreenshot) driver;
		File source = ((RemoteWebDriver) ts).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
}

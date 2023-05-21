package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.base;

public class helpermethods<TakeScreenshot> extends base {
	
	public String randomText() {	    //every time will give 4 different characters (for email)
		 return RandomStringUtils.randomAlphanumeric(4);
		
	}
	public void teardown() {
		driver.close();
	}
	public void captureScreen (String tname) throws IOException {
		TakeScreenshot ts = (TakeScreenshot) driver;
		File source = ((RemoteWebDriver) ts).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}

}

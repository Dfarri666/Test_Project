package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.base;

public class loginpage extends base {
    WebDriver driver;

    public loginpage(WebDriver ddr) {
       driver = ddr;
    }

    By username = By.xpath("//input[@name='uid']");
    By password = By.xpath("//input[@type='password']");
    By confirm = By.xpath("//input[@type='submit']");

    public void enterUsername(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String name) {
        driver.findElement(password).sendKeys(name);
    }

    public void clickLogin() {
        driver.findElement(confirm).click();
    }
}

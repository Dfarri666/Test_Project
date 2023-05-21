package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.base;

public class homepage extends base {

    WebDriver dr;

    // Constructor
    public homepage(WebDriver ddr) {
        dr = ddr;
    }
    By adButton = By.xpath("//div[@id='dismiss-button']");  // Locator for pop-up
    By frame1=By.xpath("//iframe[@id='ad_iframe']");

    public String getTitle() {
        return dr.getTitle();
    }

    public void selectab(String tabname) {
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        List<WebElement> tablist = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));

        for (WebElement tab : tablist) {
            try {
                if (tab.getText().equals(tabname)) {
                    wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
                    break; // Exit the loop after successfully clicking the element
                }
            } catch (StaleElementReferenceException e) {
                // Handle stale element reference exception if it occurs
                // Log a message or perform any necessary action
                System.out.println("Stale element reference: " + e.getMessage());
            }
        } 
    }
    public void dismissAd() {             // method for pop-up add if dispalyed dissmiss it 
    	dr.switchTo().frame(dr.findElement(frame1));
    	if(dr.findElement(adButton).isDisplayed()) {
    		dr.findElement(adButton).click();
    	}
    	dr.switchTo().defaultContent();
    }
}
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.base;

public class addCustomer extends base {
	
	WebDriver dr;
	
	public addCustomer(WebDriver ddr) {
		dr = ddr;
	}
	
	By customerName = By.xpath("//input[@name='name']");    // all elements 
	By dob = By.xpath("//input[@name='dob']");
	By add = By.xpath("//textarea[@rows='5']");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By pin = By.xpath("//input[@name='pinno']");
	By telno = By.xpath("//input[@name='telephoneno']");
	By email = By.xpath("//input[@name='emailid']");
	By pass = By.xpath("//input[@name='password']");
	By submit = By.xpath("//input[@value='Submit']");
	By msg = By.xpath("//p[text()='Customer Registered Successfully!!!']");
	
	public void entername(String name) {
		dr.findElement(customerName).sendKeys(name);
	}
	
	public void enterdob(String name) {
		dr.findElement(dob).sendKeys(name);
	}
	
	public void enteraddres(String name) {
		dr.findElement(add).sendKeys(name);
	}
	
	public void entercity(String name) {
		dr.findElement(city).sendKeys(name);
	}
	
	public void entertelno(String name) {
		dr.findElement(telno).sendKeys(name);
	}
	
	public void enterstate(String name) {
		dr.findElement(state).sendKeys(name);
	}
	
	public void enterpin(String name) {
		dr.findElement(pin).sendKeys(name);
	}
	
	public void enteremail(String name) {
		dr.findElement(email).sendKeys(name);
	}
	
	public void enterpass(String name) {
		dr.findElement(pass).sendKeys(name);
	}
	
	public void submit() {
		dr.findElement(submit).click();
	}
	public String successMsg() {
		return dr.findElement(msg).getText();
	}
}
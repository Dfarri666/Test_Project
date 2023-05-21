package tests;

import org.testng.Assert;
import pages.addCustomer;
import org.testng.annotations.Test;

import base.base;
import pages.homepage;
import pages.loginpage;
import utilities.helpermethods;

public class logintest extends base{
	
	loginpage lg;
	homepage hm;
	String uname="mngr503930";
	String pass="EmUvUnE";
	
	@Test
	public void login() {
		lg = new loginpage(driver);
		hm = new homepage(driver);
		log.info("entering username");    // logs used to organize the results showing in log box 
		lg.enterUsername(uname);
		log.info("entering Password");
		lg.enterPassword(pass);
		log.info("Clickg on Confirm ");
		lg.clickLogin();
		String temp= hm.getTitle();
		Assert.assertEquals(temp, "Guru99 Bank Manager HomePage");
	} 
	@Test
	public void newAccount() throws InterruptedException {
		hm = new homepage(driver);
		hm.selectab("New Customer");
	}
}

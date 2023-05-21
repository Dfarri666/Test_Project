package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.base;
import pages.addCustomer;
import pages.homepage;
import utilities.helpermethods;

public class addCustomerTest extends base {

	homepage hm;
	addCustomer ac;
	helpermethods hp = new helpermethods();
	String email = hp.randomText() + "@mailinator.com"; // Every time it will generates a new email
    String cus_name = "testname";
	String dobDate ="10/12/1990";
	String Address = "test address";
	String City = "test city";
	String State = "Texas";
	String Pin = "1244334";
	String Phone = "814564815";
	String Password = "test123!";
	
	@Test
	public void addCustomer() {
		ac = new addCustomer(driver);
		ac.entername(cus_name);
		ac.enterdob(dobDate);
		ac.enteraddres(Address);
		ac.entercity(City);
		ac.enterstate(State);
		ac.enterpin(Pin);
		ac.entertelno(Phone);
		ac.enteremail(email); // from object we created
		ac.enterpass(Password);
		ac.submit();
		Assert.assertEquals(ac.successMsg(), "Customer Registered Successfully!!!");
	}
}

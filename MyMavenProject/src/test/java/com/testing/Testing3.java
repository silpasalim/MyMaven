package com.testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	SoftAssert softAssert = new SoftAssert();
  @Test (priority=1)
  public void homeTest() {
	  System.out.println("I am in home test");
	  System.out.println("Before Assertion");
	  Assert.assertTrue(4>3,"Verifying Element");
	  System.out.println("After Assertion");
	  Assert.assertEquals("abc", "abc");
  }  
  
  @Test (priority=2, dependsOnMethods= {"homeTest"}, groups = {"smoke","sanity"})
  public void mainTest() {
	  System.out.println("I am in main test");
	  System.out.println("Before Assertion");
	  softAssert.assertTrue(4>3,"Verifying Element");
	  System.out.println("After Assertion");
	  softAssert.assertAll();//Similar to Error COLLECTOR
  }  
  @Test (priority=3, dependsOnMethods= {"mainTest"}, groups = {"xyz"})
  public void endTest() {
	  System.out.println("I am in end test");
	  System.out.println("Before Assertion");
	  Assert.assertTrue(4>3,"Verifying Element");
	  System.out.println("After Assertion");
	  Assert.assertEquals("abc", "abc");
	  System.out.println("After Second Assertion");
	  softAssert.assertAll();
  }  
  
}

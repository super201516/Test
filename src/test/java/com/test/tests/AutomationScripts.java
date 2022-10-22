package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.UserServiceHelper;

import simpleCRUD.CreateEmployee;
import simpleCRUD.GetAllEmployee;
import simpleCRUD.GetEmployee;

public class AutomationScripts extends UserServiceHelper {
	
	@Test(priority = 1)
	public static void TC01AllEmployeedata()
	{
		GetAllEmployee.getEmployees();
	}
		 
	@Test(priority = 2)
	 public static void TC02CreateEmployee() 
		 {
		 System.out.println("employee added"); 
		 CreateEmployee.AddEmployee();
		 }
		  
	@Test(priority = 3)
	 public static void TC05GetEmpWithId()
		  {
		  GetEmployee.getempwithid(); 
		  }
}
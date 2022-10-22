package com.test.helpers;

import java.util.Properties;

import org.testng.annotations.BeforeClass;

import com.test.constants.EndPoints;
import com.test.models.AddEmployeePOJO;
import com.test.utils.Util;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceHelper extends ReusableMethods{

	@BeforeClass
	public void setUp() {
		Util Ut = new Util();
		Properties PropertiesFile = Ut.loadfile("getdataProperties");
		RestAssured.baseURI = Ut.getProperty("baseuri",PropertiesFile);
	}
	
	public static Response getemployee() {
	Response res = RestAssured
	.given()
	.when()
	.get(EndPoints.GET_DATA);
	return res;
	}
	
	public static Response createemployee() {
		Util Ut = new Util();
		Properties PropertiesFile = Ut.loadfile("getdataProperties");
		AddEmployeePOJO createemp = new AddEmployeePOJO();
		createemp.setEmployee_name(Ut.getProperty("name",PropertiesFile));
		createemp.setEmployee_salary(Ut.getProperty("salary",PropertiesFile));
		createemp.setEmployee_age(Ut.getProperty("age",PropertiesFile));
		createemp.setProfile_image(Ut.getProperty("image",PropertiesFile));
		System.out.println("emp details");
		Response res = RestAssured
						.given()						
						.contentType(ContentType.JSON)
						.body(createemp)
						.when()
						.post(EndPoints.CREATE_DATA);
		System.out.println("response");
		return res;
		
	}
	
	public static Response getEmployeewithid() {
		Response res = RestAssured
				.given()
				.pathParam("id", 2)
				.contentType(ContentType.JSON)
				.when()
				.get(EndPoints.GET_SingleDATA);
		return res;
	}
}




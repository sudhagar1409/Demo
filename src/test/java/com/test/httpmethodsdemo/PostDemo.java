package com.test.httpmethodsdemo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDemo {

	/*
	 * URI: https://dev211370.service-now.com/api/now/table/incident
	 * 
	 * Body: {"description":"I am testing it"}
	 * 
	 * Header: Content-Type : application/json
	 */

	@Test(enabled=false)
	public void createIncident() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification respe = RestAssured.given().contentType(ContentType.JSON)
				.body("{\"description\":\"I am testing it from eclipse\"}");
		Response post = respe.post();
		post.prettyPrint();

	}
	
	@Test(enabled=true)
	public void createIncidentFile() {
		
		File file = new File("C:\\Users\\sudha\\eclipse-workspace\\restassured\\src\\test\\resources\\file.json");
		

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification respe = RestAssured.given().contentType(ContentType.JSON)
				.body(file);
		Response post = respe.post();
		post.prettyPrint();

	}

}

package com.test.jsontranspose;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONTransverse {
	
	
	@Test(enabled = true)
	public void getIncident() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		/*
		 * RequestSpecification reqspec =
		 * RestAssured.given().queryParam("sysparm_fields", "category");
		 */
		RequestSpecification reqspec = RestAssured.given();
		
		Response response = reqspec.get();
		
		  String category = response.jsonPath().get("result.category");
		  System.out.println(category);
		 
		 response.prettyPrint(); 

		List<String> category = response.jsonPath().getList("result.category"); // Its a optional one 
		
		String categ = response.jsonPath().get("result[2].category"); // Need to get the data from the list then need to use the index of the element
		int count = category.size();
		System.out.println(category);
		System.out.println(count);
		System.out.println(categ);
	}
	
	@Test(enabled=false)
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

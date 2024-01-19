package com.test.assertiondemo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class AssertionsDemo {

	@Test(enabled = false)
	public void assertcode() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident/9e66300a93133110ff7c74418bba105c";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification reqspec = RestAssured.given().queryParam("sysparm_fields", "category");
		Response response = reqspec.get();
		response.then().log().all();
		// It should be the latest in all the request that to validate the request code
		// at first afetr receiving the response for a send request
		ValidatableResponse statusCode = response.then().assertThat().statusCode(200);
		
	}

	@Test(enabled = false)
	public void assertContainsString() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident/9e66300a93133110ff7c74418bba105c";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get();
		response.then().log().all();
		// It should be the latest in all the request that to validate the request code
		// at first afetr receiving the response for a send request
		ValidatableResponse containsString = response.then().body("result.sys_domain.value",
				Matchers.containsString("global"));
		
		
	}

	@Test(enabled = false)
	public void assertComparesEqualTo() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident/9e66300a93133110ff7c74418bba105c";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get();
		response.then().log().all();
		// It should be the latest in all the request that to validate the request code
		// at first afetr receiving the response for a send request
		ValidatableResponse containsString = response.then().body("result.sys_domain.value",
				Matchers.comparesEqualTo("global"));

	}

	@Test(enabled = true)
	public void assertHasNext() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get();
		response.then().log().all();
		// It should be the latest in all the request that to validate the request code
		// at first afetr receiving the response for a send request
		ValidatableResponse containsString = response.then().body("result.task_effective_number",
				Matchers.hasItem("INC0000060"));

	}

}

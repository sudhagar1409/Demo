package com.test.httpmethodsdemo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDemo {

	/*
	 * Requirement, End Point with Resources , Create Request , Send Request ,
	 * Validata Request
	 */
	@Test(enabled = false)
	public void getRequestDemo() {

		String apiKey = "a754ee10d05c5c37be3dd55317eb060d";

		// RestAssured.baseURI =
		// "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.39";

		/*
		 * Response response = RestAssured.given().header("Authorization", "API Key " +
		 * apiKey)
		 * .get("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.39");
		 * response.prettyPrint();
		 */

		RestAssured.baseURI = ("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.39");
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("appid", "a754ee10d05c5c37be3dd55317eb060d");
		mp.put("lat", "44.34");
		mp.put("lon", "10.39");

		Response resp = RestAssured.given().queryParams(mp).get();
		resp.prettyPrint();

	}

	/*
	 * @Test public void getRequest() {
	 * 
	 * RestAssured.baseURI =
	 * "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.39&appid=a754ee10d05c5c37be3dd55317eb060d";
	 * Response response = RestAssured.get(); response.prettyPrint(); }
	 */

	@Test(enabled = false)
	public void getRequest() {

		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		Response response = RestAssured.get();
		response.prettyPrint();
	}

	@Test(enabled = true)
	public void getIncident() {

		RestAssured.baseURI = "https://dev211370.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "s0IRa*EaGh3$");
		RequestSpecification reqspec = RestAssured.given().queryParam("sysparm_fields");
		Response response = reqspec.get();
		response.prettyPrint();

	}

}

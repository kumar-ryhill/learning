package com.API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@Test
public class Post 
{
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
	JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "kumar"); // Cast
		requestParams.put("LastName", "marrireddy");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");
	 
		requestParams.put("Email",  "m.kumar@gmail.com");
		request.body(requestParams.toJSONString());
		io.restassured.response.Response response = request.get("/register");
		 
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
	 
		System.out.println("Response body: " + response.body().asString());
		
		
		/*io.restassured.response.Response response = request.post("/register");
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "200");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		//Response response = request.get("/register");
		 
		System.out.println("Response body: " + response.body().asString());*/
	}

}

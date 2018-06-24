package com.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Rawdata;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Files.Resources;

@SuppressWarnings("unused")
public class GetRequest extends Resources
{
	
	@Test

	void postrequest() {
		//String b = Payload.payLoadDatajson();
		RestAssured.baseURI = "https://maps.googleapis.com/";
		// "https://maps.googleapis.com";

		//RequestSpecification res = RestAssured.given();

		Response res =given().param("location","-33.8670522,151.1957362").param("radius", "1500").param("key", "AIzaSyDP5LB0SEny3chp-ZemPnxHtpGGd55j2f0")
		.param("type","restaurant").param("keyword","cruise")
       .when().
       get("maps/api/place/nearbysearch/json").then().assertThat().statusCode(200).and()
       .body("results[0].name",equalTo("Cruise Bar, Restaurant & Events")).and().header("server", "scaffolding on HTTPServer2").extract()
       .response();
		
		JsonPath js = Rawdata.rawDatajson(res);
		int count =js.get("results.size()");
		for(int i=0;i<=count;i++)
		{
			//System.out.print(js.get("results[i].name"));
		}
		System.out.println(count);
		
		
		
		
		//.contentType(ContentType.JSON).and().body("status", equalTo("OK"));
	
	}      
	
}

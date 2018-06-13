package com.API;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import Files.Payload;
import Files.Resources;

import Files.Rawdata;

public class APIXML extends Resources {
	Properties prop = new Properties();

	@BeforeTest
	public void getdata() throws IOException {

		FileInputStream fi = new FileInputStream("D:\\Automation\\learning\\src\\main\\java\\Files\\env.properties");
		prop.load(fi);
	}

	@Test

	void postrequest() throws IOException {
		String postdata = GenerateStringFromResource("C:\\Users\\Aceturtle-005\\Desktop\\postdata.xml");
		// String b = Payload.payLoadDataxml();
		RestAssured.baseURI = prop.getProperty("HOST");
		// "https://maps.googleapis.com";

		// RequestSpecification request = RestAssured.given();

		Response res = given().queryParam("key", prop.getProperty("KEY")).body(postdata).when()
				.post(Resources.placeResourceDataxml()).then().assertThat().statusCode(200).and()
				.contentType(ContentType.XML).and().body("status", equalTo("OK")).and().extract().response();

		io.restassured.path.xml.XmlPath rawDataXML = Rawdata.rawDataXML(res);
		System.out.println(rawDataXML);

	}

	public static String GenerateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));
	}

}

package practice.learning;

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

import Files.Payload;
import Files.Resources;

public class ApiTesting extends Resources {
	Properties prop = new Properties();

	@BeforeTest
	public void getdata() throws IOException {

		FileInputStream fi = new FileInputStream("D:\\Automation\\learning\\src\\main\\java\\Files\\env.properties");
		prop.load(fi);
	}

	@Test

	void postrequest() {
		String b = Payload.payLoadData();
		RestAssured.baseURI = prop.getProperty("HOST");
		// "https://maps.googleapis.com";

		RequestSpecification request = RestAssured.given();

		Response res = given().queryParam("key", prop.getProperty("KEY")).body(b).when()
				.post(Resources.placeResourceData()).then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("status", equalTo("OK")).and().extract().response();
		String asString = res.asString();

		System.out.println(asString);

		JsonPath js = new JsonPath(asString);
		Object object = js.get("place_id");
		System.out.println(object);
	}

	/*
	 * public void api() { RestAssured.baseURI ="https://maps.googleapis.com";
	 * 
	 * 
	 * //What al data we are passing to server(parameters,header,cookies,Body)
	 * given().
	 * 
	 * param("location","-33.8670522,151.1957362"). param("radius","500").
	 * param("type","restaurant"). param("keyword","cruise").
	 * param("key","AIzaSyDP5LB0SEny3chp-ZemPnxHtpGGd55j2f0").
	 * 
	 * when().get("/maps/api/place/nearbysearch/json").
	 * then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
	 * //and().body("results[1].name",equalTo("Cruise Bar, Restaurant & Events")).
	 * //and().body("results[0].place_id",equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI")).
	 * and().header("server", "scaffolding on HTTPServer2");
	 * 
	 * 
	 * 
	 * //adius=1500&type=restaurant&keyword=cruise&key=AIzaSyDP5LB0SEny3chp-
	 * ZemPnxHtpGGd55j2f0 }
	 */

}

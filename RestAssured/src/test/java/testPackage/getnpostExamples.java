package testPackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.matcher.*;
public class getnpostExamples {
	@Test
	
	public void gettests() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].first_name",equalTo("Tobias"));
			
			
	}
	@Test
	
	public void test2() {
		baseURI= "https://reqres.in/api";
		given().get("/users?page=2").
		then().
			statusCode(200).
			body("data[0].id",equalTo(7)).
			log().all();
	}
	
	@Test
	public void testget() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2/").
		then().
			statusCode(200).
			body("data[2].first_name",equalTo("Tobias")).
			body("data.first_name", hasItems("Michael","Lindsay"));
	} 

	@Test
	public void TestPost() {
		Map<String,Object > map = new HashMap<String, Object>();
		/*
		 * map.put("name", "Rakesh Kala"); map.put("Job", "Trainer");
		
		System.out.println(map); */
		JSONObject request = new JSONObject(map);
		request.put("name", "Rakesh Kala");
		request.put("job", "Trainer");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
			
	}
	
}

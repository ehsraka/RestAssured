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


public class putPatchDeletetest {
	@Test
	public void testPut() {
	
	JSONObject request = new JSONObject();
	request.put("name", "Rakesh kala");
	request.put("job", "Scrum Coach");
	System.out.println(request.toJSONString());
		
	baseURI = "https://reqres.in/api";
	
	given().
		header("Content-Type", "application/JSON").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		put("/users/2").
	then().
		statusCode(200).
		log().all();
	}
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Rakesh kala");
		request.put("job", "Scrum Coach");
		System.out.println(request.toJSONString());
			
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/JSON").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
		}
	@Test
	public void testDelete() {
		
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
		}
}
	

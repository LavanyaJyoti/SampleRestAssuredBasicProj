package org.sample.tests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.core.MediaType;
public class PostRequest {

	public static void main(String[] args) {
		
		String yourActualJSONString = null;
		String url="https://reqres.in/api/users";
		try {
			 yourActualJSONString = new String(Files.readAllBytes(Paths.get("D:\\workspaceSprint13\\SampleRestAssuredBasicProj\\src\\jsonfile\\createPost.json")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("yourActualJSONString::"+yourActualJSONString);
		Object obj=yourActualJSONString; 
		System.out.println("Object::"+obj);
		Response postResponse = given().relaxedHTTPSValidation().body(obj)
				.contentType( MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).log().all().when().post(url).then().log().all()
				.extract().response();
		System.out.println("postResponse::"+postResponse.asString());
	}

}

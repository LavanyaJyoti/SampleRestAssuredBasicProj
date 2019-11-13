package org.sample.tests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class GetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="https://reqres.in/api/users/2";
		Response getResponse = given().relaxedHTTPSValidation().log().all().when().get(url)
				.then().log().all().extract().response();
		System.out.println("Info::"+getResponse.asString());
	}

}

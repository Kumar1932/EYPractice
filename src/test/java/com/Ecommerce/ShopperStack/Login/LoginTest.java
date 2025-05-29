package com.Ecommerce.ShopperStack.Login;

import org.testng.annotations.Test;

import com.ECommerce.Shopperstack.PojoUtility.LoginPogo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class LoginTest 
{
	@Test
	public void loginToAppTest()
	{
		LoginPogo pojoObj=new LoginPogo("kannadigaluffy@gmail.com", "Luffy@1932", "SHOPPER");
		
		Response res = given().relaxedHTTPSValidation()
		       .contentType(ContentType.JSON)
		       .body(pojoObj)
		       .when().post("https://www.shoppersstack.com/shopping/users/login");
		res.then().log().all();
		res.then().assertThat().statusCode(200);
		res.then().assertThat().contentType(ContentType.JSON);
		String token=res.jsonPath().get("data.jwtToken");
		System.out.println(token);//test
	}
}

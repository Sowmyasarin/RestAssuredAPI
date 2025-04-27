package authentications;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class BearerTokenAuth {

	public static void main(String[] args)
	{
		Map<String,Object>mp=new LinkedHashMap<String,Object>();
		mp.put("name", "harry");
		mp.put("gender", "male");
		mp.put("email", "pk1234@gmail.com");
		mp.put("status", "active");

		String BearerToken="19804441d8231d4b7ab22e45d6666057b27cfec13e85c127bd31abceec793cce";

		RestAssured.baseURI="https://gorest.co.in";
		String Response=	given().headers("Authorization",BearerToken)
				.headers("Content-Type","application/json").body(mp)
				.when().post("public/v2/users")
				.then().log().all().assertThat().statusCode(201)
				.extract().response().asString();	
		System.out.println(Response);



	}



}

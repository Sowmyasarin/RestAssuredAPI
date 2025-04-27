package authentications;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class BasicAuth_using {

	public static void main(String[] args)
	{

		RestAssured.baseURI="http://postman-echo.com";

		String Response=	given().log().all().auth().preemptive().
				basic("postman", "password")
				.when().get("basic-auth")
				.then().
				assertThat().statusCode(200)
				.extract().response().asString();

		System.out.println(Response);
	}

}

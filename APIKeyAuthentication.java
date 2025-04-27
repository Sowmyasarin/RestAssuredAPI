package authentications;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class APIKeyAuthentication 
{
	public static void main(String[] args) {

		RestAssured.baseURI="https://api.openweathermap.org";

		String Response=		given().log().all().relaxedHTTPSValidation()
				.queryParam("q","Kolkata")
				.queryParam("appid", "c4a82761751d8c4a1482e529b39852ad")
				.when().get("/data/2.5/weather")
				.then().extract().response().asString();

		System.out.println(Response);





	}

}



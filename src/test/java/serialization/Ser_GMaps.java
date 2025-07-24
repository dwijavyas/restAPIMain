//when there is nested json in request
//serialization of variables in done via getters and setters
//converting a Java object into json

package serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class Ser_GMaps {

			//Add Place - Serialization
			public static void main(String[] args) {
				
				
				RestAssured.baseURI = "https://rahulshettyacademy.com";
				String apiKey = "qaclick123";
				
				Ser_All a = new Ser_All();
				a.setAccuracy(50);
				a.setAddress("5 abc town, hamilton");
				a.setLanguage("hindi");
				a.setName("himmat");
				a.setPhone_number("+919327563421");
				a.setWebsite("www.abc.com");
				List<String> t = new ArrayList<String>();
				t.add("lace park");
				t.add("china town");
				a.setTypes(t);
				Ser_location l = new Ser_location();
				l.setLat(35.38438395);
				l.setLng(-34.2948298);
				a.setLocation(l);
				
				
				
				//Base Request Spec
				RequestSpecification baseReq = new 
						RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
						.addQueryParam("key", apiKey)
						.addHeader("content-type", "application/json").build();
				
				//Base Response Spec
				ResponseSpecification baseRes = new ResponseSpecBuilder().expectStatusCode(200)
						.expectContentType(ContentType.JSON).build();
				
				
				
				//given request spec
				RequestSpecification gReq = given().log().all().spec(baseReq).body(a);
				
				//when then response spec
				Response wtRes= gReq.when().log().all().post("/maps/api/place/add/json")
												.then().log().all().assertThat()
												.spec(baseRes)
												.extract().response();
				
				
				String responseString = wtRes.asString();
				System.out.println(responseString);
				
}

}

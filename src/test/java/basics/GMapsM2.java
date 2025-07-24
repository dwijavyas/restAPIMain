//importing Json body payloads from external notepad file 

package basics;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GMapsM2 {

	
	
	public static void main(String[] args) throws IOException {
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String apiKey = "qaclick123";
			
		
		//Add Place
		String addResponse = given().log().all().queryParam("key", apiKey)
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\dwija\\OneDrive\\Desktop\\REST API\\addPlacePayload.json"))))
		.when().log().all().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath js = new JsonPath(addResponse);
		String placeId = js.getString("place_id");
		
		
		//Get Place
		given().log().all().queryParam("key",apiKey).queryParam("place_id", placeId)
		.header("Content-Type","application/json")
		.when().log().all().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);
		
		
		String newAddress = "70 earth walk, india";
		//update place
		given().log().all().queryParam("key", apiKey).header("content-type", "application/json")
		.body(Payload.updatePlacePayload(placeId,newAddress))
		.when().log().all().post("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200);
		
		//delete place
		given().log().all().queryParam("key",apiKey).header("Content-Type","application/json")
		.body(Payload.deletePlacePayload(placeId))
		.when().log().all().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);
		
		
	}
	
	
	
	
	
}

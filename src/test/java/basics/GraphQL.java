//graphql code for query and mutation

package basics;

import static io.restassured.RestAssured.given;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class GraphQL {

	public static void main(String[] args) {

		
		//query variables here
		int characterId = 15707;
		int locationId = 22191;
		
		//query
		String response = given().log().all().header("Content-Type", "application/json")
				.body(Payload.queryPayload(characterId,locationId))
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().log().all().extract().response()
				.asString();
		
		JsonPath js = new JsonPath(response);
		js.getString("data.character.name");

		
		// mutation variables
		String characterName = "Thanh"; 
		
		//mutation
		String response1 = given().log().all().header("Content-Type", "application/json")
				.body(Payload.mutationPayload(characterName))
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().log().all().extract().response()
				.asString();
		
		JsonPath js1 = new JsonPath(response1);
		js1.getString("data.createLocation.id");

	}

}

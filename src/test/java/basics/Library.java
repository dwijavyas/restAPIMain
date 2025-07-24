//api with payload class import and testng data privider

package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Library {

	@Test(dataProvider="bookData")
	public void bookAPI(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";

		// Add Book
		String addResponse = given().log().all().header("Content-Type", "application/json")
							.body(Payload.addBookPayload(isbn, aisle))
							.when().post("/Library/Addbook.php")
							.then().log().all()
							.assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(addResponse);
		String id = js.get("ID");
		System.out.println(id);

		// Get Book by ID
		String getIdResponse = given().log().all().queryParam("ID", isbn + aisle)
								.when().get("/Library/GetBook.php")
								.then().log().all()
								.assertThat().statusCode(200).extract().response().asString();

		JsonPath js1 = new JsonPath(getIdResponse);
		String authorName = js1.getString("[0].author");

		// Get Book by Author
		String getAuthorResponse = given().log().all().queryParam("AuthorName", authorName)
									.when().get("/Library/GetBook.php")
									.then().log().all()
									.assertThat().statusCode(200).extract().response().asString();

		System.out.println(getAuthorResponse);
		

		// Delete Book
		String deleteResponse = given().log().all().queryParam("ID", id)
								.when().delete("/Library/DeleteBook.php")
								.then().log().all()
								.assertThat().statusCode(200).extract().response().asString();

		System.out.println(deleteResponse);

	}
	
	@DataProvider(name="bookData")
	public Object[][] getData() {
		
		return new Object[][] {{"sdnj","70"},{"sdjke","900"},{"eiwo","277"}};
		
		
	}
	
	
	

}

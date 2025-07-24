package deserialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Des_OAuth {

	public static void main(String[] args) {
		
		String[] a = {"Selenium Webdriver Java","Cypress","Protractor"}; 
		List<String> expectedCourses = Arrays.asList(a);
		
		//Get Token Response
		String response =given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
                .formParams("scope", "trust").when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");

		System.out.println(accessToken);
		
		//get course details - apply desrialization to get attributes from nested json reponse
		Des_All getCoursesResponse = given().log().all().queryParam("access_token", accessToken)
		.header("content-type","application/json")
		.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.as(Des_All.class);
		
		
		System.out.println(getCoursesResponse.getExpertise());
		System.out.println(getCoursesResponse.getInstructor());
		System.out.println(getCoursesResponse.getLinkedIn());
		System.out.println(getCoursesResponse.getServices());
		System.out.println(getCoursesResponse.getUrl());
		
		//go into nested json response - get grand grand child obj
		//course title of a specific course
		//when index is fixed
		getCoursesResponse.getCourses().getMobile().get(0).getCourseTitle();
		
		//when index is not fixed/known - loop through each courses
		//get me api coursetitle = SoapUI Webservices testing
		List<Des_Api> apiCourses= getCoursesResponse.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++) {

			System.out.println(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"));
			
		}
		
		//get me price for web auto coursetitle - Cypress
		
		List<Des_WebAutomation> waCourses = getCoursesResponse.getCourses().getWebAutomation();
		for(int i=0;i<waCourses.size();i++) {
			
			if(waCourses.get(i).getCourseTitle().equalsIgnoreCase("Cypress")) {
				
				System.out.println(waCourses.get(i).getPrice());
				
			}
			
		}
		
		//get all course of web auto
		for(int i=0;i<waCourses.size();i++) {
			
			System.out.println(waCourses.get(i).getCourseTitle());
			
		}
		
		//compare actual wa coursestitle with expected
		//array list
		//grab all titles of wa and collect them into a list
		
		ArrayList<String> b = new ArrayList<String>();
		List<Des_WebAutomation> waCourses1 = getCoursesResponse.getCourses().getWebAutomation();
		
		for(int i=0;i<waCourses1.size();i++) {
			
			b.add(waCourses1.get(i).getCourseTitle());
			
		}
		
		Assert.assertTrue(b.equals(expectedCourses));
		
		
		

	}

}

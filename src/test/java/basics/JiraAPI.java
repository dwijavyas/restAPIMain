//jira test - create issue/get issue/add attachment/add comment
//import payload from payload class

package basics;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class JiraAPI {

    // Global variable to store issue key between tests
    public static String issueKey;

    @Test
    public void createIssueAndAttachFile() {

        RestAssured.baseURI = "https://learning-qa-testing.atlassian.net";

        // Create issue
        String createIssueResponse = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", Payload.authJira())
                .body(Payload.issueJira())
                .when().post("/rest/api/3/issue")
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath js = new JsonPath(createIssueResponse);
        issueKey = js.getString("key");  // ✅ Extracting key (e.g., "PROJ-123")

        // Get issue
        given().log().all()
                .pathParam("issueVal", issueKey)
                .header("Content-Type", "application/json")
                .header("Authorization", Payload.authJira())
                .when().get("/rest/api/3/issue/{issueVal}")
                .then().log().all()
                .assertThat().statusCode(200);

        // Add attachment
        given().log().all()
                .header("Authorization", Payload.authJira())
                .header("X-Atlassian-Token", "no-check")
                .header("Content-Type", "multipart/form-data")
                .pathParam("key", issueKey)
                .multiPart("file", new File("C:\\Users\\dwija\\OneDrive\\Desktop\\REST API\\jira issue 2 att 1.png"))
                .when().post("/rest/api/3/issue/{key}/attachments")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test(dataProvider = "commentStatement", dependsOnMethods = {"createIssueAndAttachFile"})
    public void addCommentToIssue(String comment) {

        // Add comment
        given().log().all()
                .header("Authorization", Payload.authJira())
                .header("Content-Type", "application/json")
                .pathParam("key", issueKey)
                .body(Payload.commentJira(comment))
                .when().post("/rest/api/3/issue/{key}/comment")
                .then().log().all()
                .assertThat().statusCode(201);
    }

    @DataProvider(name = "commentStatement")
    public Object[] getComment() {
        return new Object[] { "This is a new comment on the Jira issue." };
    }
}

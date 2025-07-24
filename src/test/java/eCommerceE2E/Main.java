package eCommerceE2E;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Main {

    public static void main(String[] args) {
        
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        
        // -------------------- LOGIN --------------------
        RequestSpecification req = new RequestSpecBuilder()
        							.setBaseUri(RestAssured.baseURI)
        							.setContentType(ContentType.JSON)
        							.build();
        
        Ser_login login = new Ser_login();
        login.setUserEmail("ronu@gmail.com");
        login.setUserPassword("Hello@123");
        
        RequestSpecification reqLogin = given().log().all().spec(req).body(login);
        
        Des_login res = reqLogin.when().post("/api/ecom/auth/login")
                		.then().log().all().statusCode(200)
                		.extract().response().as(Des_login.class);
        
        String token = res.getToken();
        String userId = res.getUserId();
        System.out.println("Login Message: " + res.getMessage());
        
        // -------------------- ADD PRODUCT --------------------
        RequestSpecification req1 = new RequestSpecBuilder()
                					.setBaseUri(RestAssured.baseURI)
                					.addHeader("Authorization", token)
                					.build();
        
        RequestSpecification reqAddProd = given().log().all().spec(req1)
                							.param("productName", "abc")
                							.param("productAddedBy", userId)
                							.param("productCategory", "electronics")
                							.param("productSubCategory", "photography")
                							.param("productPrice", "110")
                							.param("productDescription", "Addias")
                							.param("productFor", "unisex")
                							.multiPart("productImage", 
                							new File("C:\\Users\\dwija\\OneDrive\\Desktop\\REST API\\jira issue 2 att 1.png"));
        
        String res1 = reqAddProd.when().post("/api/ecom/product/add-product")
                	.then().log().all().statusCode(201)
                	.extract().response().asString();
        
        JsonPath js = new JsonPath(res1);
        String prodId = js.getString("productId");
        System.out.println("Product ID: " + prodId);
        
        // -------------------- CREATE ORDER --------------------
        RequestSpecification req2 = new RequestSpecBuilder()
                					.setBaseUri(RestAssured.baseURI)
                					.setContentType(ContentType.JSON)
                					.addHeader("Authorization", token)
                					.build();
        
        Ser_orders orders = new Ser_orders();
        orders.setCountry("India");
        orders.setProductOrderedId(prodId);
        
        List<Ser_orders> orders1 = new ArrayList<Ser_orders>();
		orders1.add(orders);
        
        RequestSpecification reqCreateOrder = given().log().all().spec(req2).body(orders);
        
        String res2 = reqCreateOrder.when().post("/api/ecom/order/create-order")
                		.then().log().all()
                		.extract().response().asString();
        
		/*
		 * JsonPath js1 = new JsonPath(res2); String orderId =
		 * js1.getString("orders[0]");
		 */
        System.out.println(res2);
        
		/*
		 * // -------------------- GET ORDER DETAILS --------------------
		 * RequestSpecification req3 = new RequestSpecBuilder()
		 * .setBaseUri(RestAssured.baseURI) .addQueryParam("id", orderId)
		 * .addHeader("Authorization", token) .build();
		 * 
		 * RequestSpecification reqOrderDetails = given().log().all().spec(req3);
		 * 
		 * String res3 = reqOrderDetails.when().get("/api/ecom/order/get-order-details")
		 * .then().log().all().statusCode(200) .extract().response().asString();
		 * 
		 * System.out.println("Order Details:\n" + res3);
		 * 
		 * // -------------------- DELETE ORDER -------------------- String
		 * deleteOrderResponse = given().log().all() .pathParam("prodOrderedId",
		 * orderId) .header("Authorization", token)
		 * .when().delete("/api/ecom/order/delete-order/{prodOrderedId}")
		 * .then().log().all().statusCode(200) .extract().response().asString();
		 * 
		 * System.out.println("Delete Order Response:\n" + deleteOrderResponse);
		 */
        // -------------------- DELETE PRODUCT --------------------
        String deleteProdResponse = given().log().all()
                					.pathParam("productId", prodId)
                					.header("Authorization", token)
                					.when().delete("/api/ecom/product/delete-product/{productId}")
                					.then().log().all().statusCode(200)
                					.extract().response().asString();
        
        System.out.println("Delete Product Response:\n" + deleteProdResponse);
    }
}

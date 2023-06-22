package test;

import groovy.json.JsonSlurper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;
import utils.DataUtility;

import javax.print.DocFlavor;
import java.util.Base64;
import java.util.Map;


public class BaseAPITest {
    RequestSpecification commonJsonSpec = new RequestSpecBuilder().setBaseUri("https://user-api.medkomtek-stg.com/user-svc/api/v1/")
            .setContentType(ContentType.JSON).build().log().all();
    RequestSpecification loginJsonSpec;
    String uid;


    @BeforeMethod
    public void login() {
        RestAssured.baseURI = "https://user-api.medkomtek-stg.com/user-svc/api/v1/";
//        String loginPayload = DataUtility.getDataFromExcel("Payloads", "LoginPayload");
        String loginPayload = "{\"phone\": \"081283768422\",\"password\": \"111111\",\"type\": \"pin\"}";
        Response response = RestAssured.given().contentType("application/json").body(loginPayload).when()
                .post(APIEndpoints.login);
        Assert.assertEquals(response.getStatusCode(),200);

        String token = response.jsonPath().get("data.record.token");
        System.out.println(token);
//        String token = response.jsonPath().get(JsonPaths.authToken);
        loginJsonSpec = new RequestSpecBuilder().setBaseUri("https://user-api.medkomtek-stg.com/user-svc/api/v1/")
                .setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token).build().log().all();
       //decoded token
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] parts = token.split("\\.");
        String decodedToken = new String(decoder.decode(parts[1]));
        System.out.println(decodedToken);
        JsonSlurper js = new JsonSlurper();
        Map m = (Map) js.parseText(decodedToken);
        uid = (String) m.get("id");
        System.out.println(uid);
    }

//    public void userId(String userId){
//        Response response = RestAssured.given().contentType("application/json").body(loginPayload).when()
//                .post(APIEndpoints.login);
//        String token = response.jsonPath().get("data.record.token");
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//        String[] parts = token.split("\\.");
//        String decodedToken = new String(decoder.decode(parts[1]));
//    }
}

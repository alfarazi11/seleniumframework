package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;
import utils.APIUtility;

import static io.restassured.RestAssured.given;

public class APITest extends BaseAPITest{


    @Test
    public void userProfile(){
        Response response = given().spec(loginJsonSpec).when().get(APIEndpoints.profile +uid);
        APIUtility.verifyStatusCodeSuccess(response);
//        Assert.assertEquals(response.getStatusCode(),200);
        String name = response.jsonPath().get("data.record.first_name");
        System.out.println(name);
        Assert.assertEquals(name,"John");
    }

    @Test
    public void memberHistory(){
        Response response = given().spec(loginJsonSpec).param("limit","10").
                param("page","1").when().get(APIEndpoints.Membership);
        APIUtility.verifyStatusCodeSuccess(response);
    }

}

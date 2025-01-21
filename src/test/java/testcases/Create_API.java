package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Helper;

import java.io.*;

public class Create_API {


    public static String id;
    public static Response testCreatePost(String endPointURL) throws IOException {

        String requestBody = """
                {
                    "title": "foo",
                    "body": "bar",
                    "userId": 1
                }
                """;
        Response response = RestAssured.given().
                // auth().
                // oauth2(OAuthUtils.getoAuthToken()).
                //or header("authorization", "Bearer " + OAuthUtils.getBearerToken()).
                contentType(ContentType.JSON).
                baseUri(endPointURL).
                body(requestBody).
                when().
                post("/posts").
                then().
                statusCode(201).
                extract().
                response();

        //Saving the response in a file inside "Response_Files" folder
        Helper.saveResponse("Response_Files", "create_API", response.asString());

        id = response.jsonPath().getString("userId");
        return response;

    }

}

package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Helper;

import java.io.IOException;

public class Get_API {
    public static Response testGetData(String endPointURL) throws IOException {
        Response response = RestAssured.given().
                // auth().
                // oauth2(OAuthUtils.getoAuthToken()).
                //or header("authorization", "OAuth " + OAuthUtils.getBearerToken()).
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri(endPointURL).
                pathParam("id",Create_API.id).
                when().
                get("/posts/{id}").
                then().
                statusCode(200).
                extract().
                response();

        //Saving the response in a file inside "ResponseFiles" folder
        Helper.saveResponse("Response_Files", "get_API", response.asString());

        return response;
    }
}

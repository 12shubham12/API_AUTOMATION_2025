package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Helper;

import java.io.IOException;

public class Delete_API {

    public static Response testDeletePost(String endPointURL) throws IOException {

        Response response = RestAssured.given().
                // auth().
                // oauth2(OAuthUtils.getoAuthToken()).
                //or header("authorization", "Bearer " + OAuthUtils.getBearerToken()).
                contentType(ContentType.JSON).
                baseUri(endPointURL).
                pathParam("id",Create_API.id).
                when().
                delete("/posts/{id}").
                then().
                statusCode(200).
                extract().
                response();

        //Saving the response in a file inside "Response_Files" folder
        Helper.saveResponse("Response_Files", "delete_API", response.asString());

        return response;

    }
}

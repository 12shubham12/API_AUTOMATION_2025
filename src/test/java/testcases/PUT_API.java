package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Helper;

import java.io.IOException;

public class PUT_API {

    public static Response testUpdateData(String endPointURL) throws IOException {

        //Since we are passing id as pathParam, so need to specify id in requestBody
        String requestBody = """
                {
                    "title": "updated title",
                    "body": "updated body",
                    "userId": 101
                }
                """;

        Response response = RestAssured.given().
                //header("Authorization", "Bearer " + AuthUtils.getBearerToken()).
                contentType(ContentType.JSON).
                body(requestBody).
                baseUri(endPointURL).
                pathParam("id", Create_API.id).
                when().
                put("/posts/{id}").
                then().
                statusCode(200).
                extract().
                response();

        //Saving the response in a file inside "ResponseFiles" folder
        Helper.saveResponse("Response_Files", "update_API", response.asString());

        return response;
    }
}

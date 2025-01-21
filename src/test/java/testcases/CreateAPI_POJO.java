package testcases;

import api_request_classes.CreateAPI_Request_POJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilities.Helper;

import java.io.FileNotFoundException;

public class CreateAPI_POJO {

    // Method to send POST request with UserRequest object as body
    public static Response createUserPost(CreateAPI_Request_POJO userRequest, String endPointURL) throws FileNotFoundException {
        Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri(endPointURL).
                body(userRequest). // Send the UserRequest object as JSON
                when().
                post("/posts").
                then().
                statusCode(201).
                extract().
                response();

        //Saving the response in a file inside "Response_Files" folder
        Helper.saveResponse("Response_Files", "create_API_POJO", response.asString());

        return response;

    }

    // Method to deserialize the response to a UserRequest object
    public static CreateAPI_Request_POJO parseResponseToUserResponse(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody().asString(), CreateAPI_Request_POJO.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

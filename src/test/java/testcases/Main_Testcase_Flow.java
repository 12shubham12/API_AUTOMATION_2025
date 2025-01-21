package testcases;

import api_request_classes.CreateAPI_Request_POJO;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.BaseClass;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main_Testcase_Flow extends BaseClass {

    @Test(priority=1)
    public void test_create_data() throws IOException {
        Response response = Create_API.testCreatePost(config.getProperty("POST-API"));
        response.prettyPrint();
    }

    @Test(priority=2)
    public void test_get_data() throws IOException {
        Response response = Get_API.testGetData(config.getProperty("GET-API"));
        response.prettyPrint();
    }

    @Test(priority=3)
    public void test_put_data() throws IOException {
        Response response = PUT_API.testUpdateData(config.getProperty("PUT-API"));
        response.prettyPrint();
    }

    @Test(priority=4)
    public void test_delete_data() throws IOException {
        Response response = Delete_API.testDeletePost(config.getProperty("DELETE-API"));
        response.prettyPrint();
    }

    @Test(priority=5)
    public void testCreateUser_POJO() throws FileNotFoundException {
        // Create an instance of the UserRequest model with necessary data
        CreateAPI_Request_POJO userRequest = new CreateAPI_Request_POJO();
        userRequest.setTitle("foo");
        userRequest.setBody("bar");
        userRequest.setUser_Id(String.valueOf(1));

        // Call the API to create the user
        Response response = CreateAPI_POJO.createUserPost(userRequest, config.getProperty("PUT-API"));
        response.prettyPrint();
    }
}

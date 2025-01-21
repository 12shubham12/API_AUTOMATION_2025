package api_request_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //generates getters, setters, toString(), equals() and hashCode()
@NoArgsConstructor //generates a no-argument constructor
@AllArgsConstructor //generates a constructor with all fields as parameters

public class CreateAPI_Request_POJO {
    private String title;
    private String body;
    private String user_Id;

}
//If the JSON has logical groupings of fields, consider splitting it into multiple nested POJOs. For example:
/*{
        "personalInfo": {
        "username": "Amit",
        "age": 21,
        "email": "amit@example.com"
        },
        "contactInfo": {
        "phone": "1234567890",
        "address": "123 Street Name",
        "city": "Some City",
        "state": "Some State",
        "zipCode": "12345",
        "country": "Some Country"
        }
        }

 */
/*
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest1 {
    private PersonalInfo personalInfo;
    private ContactInfo contactInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PersonalInfo {
        private String username;
        private int age;
        private String email;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContactInfo {
        private String phone;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }
}
 */

package PublicSnovioAPI;

import static Utils.RandomData.getRandomInt;
import static io.restassured.RestAssured.given;

public class Email_Finder {


    public void add_names_to_find_emails() {


        given()
                .contentType("application/x-www-form-urlencoded")

                .body("firstName=ApiTest " + getRandomInt(1, 10000) + "&" +
                        "lastName=ApiTest " + getRandomInt(1, 10000) + "&" +
                        "domain=mac-group.com")
                .when()
                .post("https://preprod-api.snov.io/v1/add-names-to-find-emails")
                .then().log().body()
                .statusCode(200)
                .extract().response();


    }


    public void get_emails_from_names() {
        for (int i = 0; i < 100; i++) {


            given()
                    .contentType("application/x-www-form-urlencoded")

                    .body("firstName=ApiTest " + getRandomInt(1, 10000) + "&" +
                            "lastName=ApiTest " + getRandomInt(1, 10000) + "&" +
                            "domain=mac-group.com")
                    .when()
                    .post("https://preprod-api.snov.io/v1/get-emails-from-names")
                    .then().log().body()
                    .statusCode(200)
                    .extract().response();
            System.out.println(" ");
            System.out.println(i);
        }

    }
}

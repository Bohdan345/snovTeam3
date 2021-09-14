package PublicSnovioAPI;

import static Utils.RandomData.getRandomInt;
import static io.restassured.RestAssured.given;

public class EmailVerifier {


    public void add_emails_to_verification() {
        for (int i = 0; i < 201; i++) {


            given()
                    .contentType("application/x-www-form-urlencoded")

                    .body("emails[]=ApiTest@" + getRandomInt(1, 10000) + "test.com" + "&")
                    .when()
                    .post("https://preprod-api.snov.io/v1/add-emails-to-verification")
                    .then().log().body()
                    .statusCode(200)
                    .extract().response();
            System.out.println(" ");
            System.out.println(i);
        }

    }


    public void get_emails_verification_status() {
        for (int i = 0; i < 201; i++) {


            given()
                    .contentType("application/x-www-form-urlencoded")

                    .body("emails[]=ApiTest@" + getRandomInt(1, 10000) + "test.com" + "&")
                    .when()
                    .post("https://preprod-api.snov.io/v1/get-emails-verification-status")
                    .then().log().body()
                    .statusCode(200)
                    .extract().response();
            System.out.println(" ");
            System.out.println(i);
        }

    }
}

package PublicSnovioAPI;

import static ReadData.DataFromProperty.*;
import static io.restassured.RestAssured.given;

public class Auth {

    public void aut() {
        given()
                .contentType("application/x-www-form-urlencoded")

                .body("grant_type=" + GRAND_TYPE + "&" +
                        "client_id=" + CLIENT_ID + "&" +
                        "client_secret=" + CLIENT_SECRET)
                .when()
                .post(PREPROD_API_URL + "/v1/add-names-to-find-emails")
                .then().log().body()
                .statusCode(200)
                .extract().response();

    }
}

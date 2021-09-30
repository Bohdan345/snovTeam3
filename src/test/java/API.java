import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static Utils.RandomData.getRandomInt;
import static io.restassured.RestAssured.given;

public class API {



    public void createDeal() {

        for (int i = 0; i < 20; i++) {


            given()
                    .contentType("application/x-www-form-urlencoded")
                    .cookie("snov_io=vbUJCZEv5Ccxf9e8sBBDjqITqZzJ45FJ0rLhXA2K; Path=/; Secure; HttpOnly;")
                    .body("name=ApiDeal " + getRandomInt(1, 1000000) + "&" +
                            "funnelId=496&" +
                            "funnelStatusId=2474&" +
                            "responsibleUserId=2984075ec47feda47f53b6fc6a22922f36903e3aa07b2dc6ecae4c59deb95b&" +
                            "companyId&1111&" +
                            "dealStatus=active&" +
                            "peopleName=User&" +
                            "price=100&" +
                            "peopleId=988118dd9e02053ba6fdca6a95c1216c9af4b839f441ea2a250575fe76dc3d6092b69f23")
                    .when()
                    .post("https://preprod.snov.io/crm/api/deals")
                    .then().log().body()
                    .statusCode(200)
                    .extract().response();

            Selenide.sleep(1800);
        }
    }


    // Verifier


    /**
     public void updateFunnelStatus() {


     given()
     .contentType("application/x-www-form-urlencoded")
     .cookie("snov_io=RsQZWWXs7EaphOE3ddUaPobzoSxRfMY33Ig5MvXw; Path=/; Secure; HttpOnly;")
     .body(
     "funnelId=5035&" +
     "funnelStatusId=25173&" +
     "dealStatus=active&"



     )
     .when()
     .put("https://preprod.snov.io/crm/api/deals/update-funnel-status")
     .then().log().body()
     .statusCode(200)
     .extract().response();
     }
     **/
}

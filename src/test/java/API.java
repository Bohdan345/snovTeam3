import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static Utils.RandomData.getRandomInt;
import static io.restassured.RestAssured.given;

public class API {

/*
    public void createDeal() {

        for (int i = 0; i < 9999; i++) {


            given()
                    .contentType("application/x-www-form-urlencoded")
                    .cookie("snov_io=HvQNTU5of5OV7fH92EWltNHMGR8SwFpLKWnKXvqq; Path=/; Secure; HttpOnly;")
                    .body("name=ApiDeal " + getRandomInt(1, 1000000) + "&" +
                            "funnelId=281&" +
                            "funnelStatusId=1400&" +
                            "responsibleUserId=39a36a10a577a4d74338579fd8fd414b6a16234d8fd91c040ec539ce9b667f&" +
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

public class API {

    /**

    public void createDeal() {

        for (int i = 0; i < 300; i++) {


            given()
                    .contentType("application/x-www-form-urlencoded")
                    .cookie("snov_io=vm45i5OIr4tCoV351LT1ex1OuKOzstH0EmYEkPxf; Path=/; Secure; HttpOnly;")
                    .body("name=ApiDeal " + getRandomInt(1, 10000) + "&" +
                            "funnelId=621&" +
                            "funnelStatusId=3153&" +
                            "responsibleUserId=be88142654833be1ba16b02d4d5e5b901ae405e7884e10c6122a0d2f0dbfa3&" +
                            "companyId&1111&" +
                            "dealStatus=active&" +
                            "price=100&" +
                            "peopleId=988118dd9e02053ba6fdca6a95c1216c9af4b839f441ea2a250575fe76dc3d6092b69f23")
                    .when()
                    .post("https://preprod.snov.io/crm/api/deals")
                    .then().log().body()
                    .statusCode(200)
                    .extract().response();

            Selenide.sleep(2000);
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

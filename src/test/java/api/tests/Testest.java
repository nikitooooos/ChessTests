package api.tests;

import api.models.LoginBodyModel;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Testest extends TestBase {

    @Test
    void successfulLoginWithApiTest() {
        LoginBodyModel loginData = new LoginBodyModel();
        loginData.setEmail("nikita.postnikov.00@gmail.com");
        loginData.setPassword("parol123*");
        String loginBody = "form[sites_client_mail]:" + loginData.getEmail() + "form[sites_client_pass]:" + loginData.getPassword();

        Response authResponse = given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType("application/x-www-form-urlencoded")
                .body(loginBody)
                .when()
                .post("/user/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().response();

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", authResponse.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("expires", authResponse.path("expires")));
        getWebDriver().manage().addCookie(new Cookie("token", authResponse.path("token")));

        open("");
        $(".lobby__app__content").shouldHave(text("Своя игра"));
    }
}

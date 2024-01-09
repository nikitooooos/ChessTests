package api.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import api.models.*;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static api.specs.TestSpecs.*;

@Owner("Nikita Postnikov")
@Feature("Testing of login on fruktinadom.ru")
@Tag("api")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Check response status of login")
    @Story("Testing of successful login using method POST")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("positive")
    void checkLoginStatus() {
        LoginBodyModel loginData = new LoginBodyModel();
        loginData.setEmail("nikita.postnikov.00@gmail.com");
        loginData.setPassword("parol123*");
        String loginBody = "form%5Bsites_client_mail%5D=" + loginData.getEmail() + "form%5Bsites_client_pass%5D=" + loginData.getPassword();

        step("Check that response status is 200", () -> {
            given(testRequestSpec)
                    .contentType("application/x-www-form-urlencoded; charset=ISO-8859-1")
                    //form%5Bsites_client_mail%5D=nikita.postnikov.00%40gmail.com&form%5Bsites_client_pass%5D=parol123*&send=
                    .body(loginBody)
                    .when()
                    .get("/login")
                    .then()
                    .spec(responseSpecStatusCodeIs200);
        });
    }
}
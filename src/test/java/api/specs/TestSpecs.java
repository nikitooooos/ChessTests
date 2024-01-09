package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static api.helpers.CustomAllureListener.withCustomTemplates;

public class TestSpecs {

    public static RequestSpecification testRequestSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=utf-8");
    public static ResponseSpecification responseSpecStatusCodeIs200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
    public static ResponseSpecification responseSpecWithoutStatus = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();


}
package testExamples;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITests {

    @Test
    void checkStatusCode() {
        given()
                .log().all()
                .when()
                .get("https://github.com/status")
                .then()
                .log().all()
                .statusCode(200);
                //.body("",is(""));

    }

    @Test
    void checkContentType() {
        String expectedAnswer = "text/html; charset=utf-8";
        String actualAnswer =given()
                .log().all()
                .when()
                .get("https://github.com/status")
                .then()
                .log().all()
                .statusCode(200)
                .extract().contentType();

        assertEquals(expectedAnswer,actualAnswer);

    }
}

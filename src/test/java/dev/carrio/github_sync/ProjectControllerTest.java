package dev.carrio.github_sync;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ProjectControllerTest {

    @Test
    public void testProjectsEndpoint() {
        given()
          .when().get("/projects")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }

}
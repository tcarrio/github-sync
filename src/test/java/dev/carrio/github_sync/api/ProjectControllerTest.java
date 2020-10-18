package dev.carrio.github_sync.api;

import dev.carrio.github_sync.api.api.ProjectControllerImpl;
import dev.carrio.github_sync.api.dto.ProjectDto;
import dev.carrio.github_sync.api.service.IProjectService;
import dev.carrio.github_sync.api.service.ProjectServiceImpl;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
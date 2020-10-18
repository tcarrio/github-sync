package dev.carrio.github_sync.api.api;

import dev.carrio.github_sync.api.dto.ProjectDto;
import dev.carrio.github_sync.api.dto.ActionDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/projects")
public interface IProjectController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectDto> getProjects();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<ProjectDto> getProject(@PathParam("id") UUID id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public UUID createProject(ProjectDto project);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public UUID updateProject(UUID id, ProjectDto project);

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionDto deleteProject(@PathParam("id") String id);
}
package dev.carrio.github_sync.api;

import dev.carrio.github_sync.dto.ActionDto;
import dev.carrio.github_sync.dto.ProjectDto;
import dev.carrio.github_sync.service.ProjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectControllerImpl implements IProjectController {
    @Inject
    private ProjectService projectService;

    @Override
    public List<ProjectDto> getProjects() {
        return this.projectService.getProjects();
    }

    @Override
    public Optional<ProjectDto> getProject(@PathParam("id") UUID id) {
        return this.projectService.getProject(id);
    }

    @Override
    public UUID createProject(ProjectDto project) {
        return this.projectService.createProject(project);
    }

    @Override
    public UUID updateProject(UUID id, ProjectDto project) {
        Optional<UUID> updated = this.projectService.updateProject(id, project);
        if (!updated.isPresent()) {
            throw new NotFoundException(String.format("No project with ID %s found", id.toString()));
        }

        return updated.get();
    }

    @Override
    public ActionDto deleteProject(@PathParam("id") String id) {
        ActionDto currentAction = new ActionDto();
        try {
            Optional<UUID> deleted = this.projectService.deleteProject(id);

            currentAction.success = deleted.isPresent();
            if (!currentAction.success) {
                currentAction.reason = "Project was not found";
            }
        } catch (Exception e) {
            currentAction.success = false;
            currentAction.reason = e.getMessage();
        }

        return currentAction;
    }
}
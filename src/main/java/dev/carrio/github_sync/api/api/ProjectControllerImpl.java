package dev.carrio.github_sync.api.api;

import dev.carrio.github_sync.api.dto.ActionDto;
import dev.carrio.github_sync.api.dto.ProjectDto;
import dev.carrio.github_sync.api.service.IProjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectControllerImpl implements IProjectController {
    @Inject
    private IProjectService projectServiceImpl;

    @Override
    public List<ProjectDto> getProjects() {
        return this.projectServiceImpl.getProjects();
    }

    @Override
    public Optional<ProjectDto> getProject(@PathParam("id") UUID id) {
        return this.projectServiceImpl.getProject(id);
    }

    @Override
    public UUID createProject(ProjectDto project) {
        return this.projectServiceImpl.createProject(project);
    }

    @Override
    public UUID updateProject(UUID id, ProjectDto project) {
        Optional<UUID> updated = this.projectServiceImpl.updateProject(id, project);
        if (!updated.isPresent()) {
            throw new NotFoundException(String.format("No project with ID %s found", id.toString()));
        }

        return updated.get();
    }

    @Override
    public ActionDto deleteProject(@PathParam("id") String id) {
        ActionDto currentAction = new ActionDto();
        try {
            Optional<UUID> deleted = this.projectServiceImpl.deleteProject(id);

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
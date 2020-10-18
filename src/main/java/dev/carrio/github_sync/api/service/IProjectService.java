package dev.carrio.github_sync.api.service;

import dev.carrio.github_sync.api.dto.ProjectDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProjectService {
    List<ProjectDto> getProjects();
    Optional<ProjectDto> getProject(UUID id);
    UUID createProject(ProjectDto project);
    Optional<UUID> updateProject(UUID id, ProjectDto project);
    Optional<UUID> deleteProject(String id);
}

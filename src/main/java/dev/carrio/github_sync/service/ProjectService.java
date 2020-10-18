package dev.carrio.github_sync.service;

import dev.carrio.github_sync.dto.ProjectDto;
import dev.carrio.github_sync.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProjectService {
    @Inject
    public EntityManager em;

    @Transactional
    public List<ProjectDto> getProjects() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Project> cq = cb.createQuery(Project.class);
        Root<Project> rootEntry = cq.from(Project.class);
        CriteriaQuery<Project> all = cq.select(rootEntry);
        TypedQuery<Project> allQuery = em.createQuery(all);
        return allQuery.getResultList().stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    @Transactional
    public Optional<ProjectDto> getProject(UUID id) {
        Project model = this.em.find(Project.class, id);
        if (model == null) {
            return Optional.empty();
        }

        ProjectDto dto = mapEntityToDto(model);

        return Optional.of(dto);
    }

    @Transactional
    public UUID createProject(ProjectDto project) {
        Project model = new Project();
        model.setName(project.name);
        model.setUrl(project.url);
        model.setDescription(project.description);
        this.em.persist(model);
        return model.getId();
    }

    @Transactional
    public Optional<UUID> updateProject(UUID id, ProjectDto project) {
        Project model = this.em.find(Project.class, id);
        if (model == null) {
            return Optional.empty();
        }

        model.setName(project.name);
        model.setUrl(project.url);
        model.setDescription(project.description);
        this.em.persist(model);
        return Optional.of(model.getId());
    }

    @Transactional
    public Optional<UUID> deleteProject(String id) {
        Project model = this.em.find(Project.class, id);
        if (model == null) {
            return Optional.empty();
        }

        em.remove(model);
        return Optional.of(model.getId());
    }

    private ProjectDto mapEntityToDto(Project model) {
        ProjectDto dto = new ProjectDto();
        dto.name = model.getName();
        dto.url = model.getUrl();
        dto.description = model.getDescription();
        return dto;
    }
}

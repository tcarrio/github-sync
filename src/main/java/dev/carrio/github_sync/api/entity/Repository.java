package dev.carrio.github_sync.api.entity;


//@Entity(name = "Repository")
//@Table(name = "Repository")

import javax.persistence.Entity;

@Entity
public class Repository extends AbstractUUIDEntity {
    private String projectId;
    private String name;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

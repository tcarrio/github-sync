package dev.carrio.github_sync.api.entity;

import javax.persistence.Entity;
import java.net.URL;

//@Entity(name = "Project")
//@Table(name = "Project")

@Entity
public class Project extends AbstractUUIDEntity {
    private String name;
    private URL url;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

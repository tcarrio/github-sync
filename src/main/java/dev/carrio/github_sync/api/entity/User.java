package dev.carrio.github_sync.api.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "user")
public class User extends AbstractUUIDEntity {
    public String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

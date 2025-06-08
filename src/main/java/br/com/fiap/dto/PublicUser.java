package br.com.fiap.dto;

import br.com.fiap.beans.User;

import java.time.LocalDateTime;

public class PublicUser {

    private int id;
    private String name;
    private LocalDateTime createdAt;

    public PublicUser() {
        super();
    }

    public PublicUser(int id, String name, LocalDateTime createdAt) {
        super();

        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public PublicUser(User user) {
        super();

        this.id = user.getId();
        this.name = user.getName();
        this.createdAt = user.getCreatedAt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PublicUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}

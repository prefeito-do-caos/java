package br.com.fiap.beans;

import br.com.fiap.dto.PublicUser;

import java.time.LocalDateTime;

public class GameScore {

    private int id;
    private PublicUser user;
    private Scenario scenario;
    private int score;
    private LocalDateTime createdAt;

    public GameScore() {
        super();
    }

    public GameScore(int id, int score) {
        super();

        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PublicUser getUser() {
        return user;
    }

    public void setUser(PublicUser user) {
        this.user = user;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "id=" + id +
                ", user=" + user +
                ", scenario=" + scenario +
                ", score=" + score +
                ", createdAt=" + createdAt +
                '}';
    }

}

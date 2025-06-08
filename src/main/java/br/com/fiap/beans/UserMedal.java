package br.com.fiap.beans;

import java.time.LocalDateTime;

public class UserMedal {

    private User user;
    private Medal medal;
    private LocalDateTime earnedAt;

    public UserMedal() {
        super();
    }

    public UserMedal(User user, Medal medal) {
        super();

        this.user = user;
        this.medal = medal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medal getMedal() {
        return medal;
    }

    public void setMedal(Medal medal) {
        this.medal = medal;
    }

    public LocalDateTime getEarnedAt() {
        return earnedAt;
    }

    public void setEarnedAt(LocalDateTime earnedAt) {
        this.earnedAt = earnedAt;
    }

    @Override
    public String toString() {
        return "UserMedal{" +
                "user=" + user +
                ", medal=" + medal +
                ", earnedAt=" + earnedAt +
                '}';
    }

}

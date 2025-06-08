package br.com.fiap.dto;

import br.com.fiap.beans.Medal;

import java.time.LocalDateTime;

public class UserMedal extends Medal {

    private LocalDateTime earnedAt;

    public UserMedal() {
        super();
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
                "earnedAt=" + earnedAt +
                "} " + super.toString();
    }

}

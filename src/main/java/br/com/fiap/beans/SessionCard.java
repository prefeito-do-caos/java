package br.com.fiap.beans;

import java.time.LocalDateTime;

public class SessionCard {

    private int id;
    private GameSession gameSession;
    private Card card;
    private int wasPlayed;
    private LocalDateTime playedAt;
    private LocalDateTime createdAt;

    public SessionCard() {
        super();
    }

    public SessionCard(int id, int wasPlayed) {
        super();

        this.id = id;
        this.wasPlayed = wasPlayed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getWasPlayed() {
        return wasPlayed;
    }

    public void setWasPlayed(int wasPlayed) {
        this.wasPlayed = wasPlayed;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(LocalDateTime playedAt) {
        this.playedAt = playedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SessionCard{" +
                "id=" + id +
                ", gameSession=" + gameSession +
                ", card=" + card +
                ", wasPlayed=" + wasPlayed +
                ", playedAt=" + playedAt +
                ", createdAt=" + createdAt +
                '}';
    }

}

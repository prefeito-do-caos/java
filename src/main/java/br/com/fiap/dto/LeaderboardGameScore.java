package br.com.fiap.dto;

import br.com.fiap.beans.GameScore;

public class LeaderboardGameScore {

    private PublicUser user;
    private int scenarioId;
    private int score;

    public LeaderboardGameScore() {
        super();
    }

    public LeaderboardGameScore(int score) {
        super();

        this.score = score;
    }

    public LeaderboardGameScore(GameScore gameScore) {
        super();
        
        this.user = gameScore.getUser();
        this.scenarioId = gameScore.getScenario().getId();
        this.score = gameScore.getScore();
    }

    public PublicUser getUser() {
        return user;
    }

    public void setUser(PublicUser user) {
        this.user = user;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LeaderBoardGameScore{" +
                "user=" + user +
                ", scenarioId=" + scenarioId +
                ", score=" + score +
                '}';
    }
    
}

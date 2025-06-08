package br.com.fiap.dto;

public class CreateGameSession {

    private int scenarioId;

    public CreateGameSession() {
        super();
    }

    public CreateGameSession(int scenarioId) {
        super();

        this.scenarioId = scenarioId;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    @Override
    public String toString() {
        return "CreateGameSession{" +
                "scenarioId=" + scenarioId +
                '}';
    }

}

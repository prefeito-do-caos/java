package br.com.fiap.dto;

public class CardDTO {

    private int id;
    private int scenarioId;
    private String phase;
    private String title;
    private String description;
    private int sequenceOrder;
    private String coverUrl;
    private String acceptLabel;
    private String rejectLabel;

    public CardDTO() {
        super();
    }

    public CardDTO(int id, int scenarioId, String phase, String title, String description, int sequenceOrder, String coverUrl, String acceptLabel, String rejectLabel) {
        super();

        this.id = id;
        this.scenarioId = scenarioId;
        this.phase = phase;
        this.title = title;
        this.description = description;
        this.sequenceOrder = sequenceOrder;
        this.coverUrl = coverUrl;
        this.acceptLabel = acceptLabel;
        this.rejectLabel = rejectLabel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getAcceptLabel() {
        return acceptLabel;
    }

    public void setAcceptLabel(String acceptLabel) {
        this.acceptLabel = acceptLabel;
    }

    public String getRejectLabel() {
        return rejectLabel;
    }

    public void setRejectLabel(String rejectLabel) {
        this.rejectLabel = rejectLabel;
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "id=" + id +
                ", scenarioId=" + scenarioId +
                ", phase='" + phase + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sequenceOrder=" + sequenceOrder +
                ", coverUrl='" + coverUrl + '\'' +
                ", acceptLabel='" + acceptLabel + '\'' +
                ", rejectLabel='" + rejectLabel + '\'' +
                '}';
    }

}

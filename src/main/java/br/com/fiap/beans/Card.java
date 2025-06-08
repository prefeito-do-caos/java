package br.com.fiap.beans;

public class Card {

    private int id;
    private Scenario scenario;
    private String phase;
    private String title;
    private String description;
    private int sequenceOrder;
    private String coverUrl;
    private String acceptLabel;
    private String rejectLabel;

    public Card() {
        super();
    }

    public Card(int id, String phase, String title, String description, int sequenceOrder, String coverUrl, String acceptLabel, String rejectLabel) {
        super();

        this.id = id;
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

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
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
        return "Card{" +
                "id=" + id +
                ", scenario=" + scenario +
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

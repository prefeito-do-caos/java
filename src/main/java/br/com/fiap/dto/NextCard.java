package br.com.fiap.dto;

public class NextCard {

    private int sequenceOrder;
    private String phase;
    private String title;
    private String description;
    private String coverUrl;
    private String acceptLabel;
    private String rejectLabel;
    private CardDecisionEffectDTO acceptEffect;
    private CardDecisionEffectDTO rejectEffect;

    public NextCard() {
        super();
    }

    public NextCard(int sequenceOrder, String phase, String title, String description, String coverUrl, String acceptLabel, String rejectLabel) {
        super();

        this.sequenceOrder = sequenceOrder;
        this.phase = phase;
        this.title = title;
        this.description = description;
        this.coverUrl = coverUrl;
        this.acceptLabel = acceptLabel;
        this.rejectLabel = rejectLabel;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
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

    public CardDecisionEffectDTO getAcceptEffect() {
        return acceptEffect;
    }

    public void setAcceptEffect(CardDecisionEffectDTO acceptEffect) {
        this.acceptEffect = acceptEffect;
    }

    public CardDecisionEffectDTO getRejectEffect() {
        return rejectEffect;
    }

    public void setRejectEffect(CardDecisionEffectDTO rejectEffect) {
        this.rejectEffect = rejectEffect;
    }

    @Override
    public String toString() {
        return "NextCard{" +
                "sequenceOrder=" + sequenceOrder +
                ", phase='" + phase + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", acceptLabel='" + acceptLabel + '\'' +
                ", rejectLabel='" + rejectLabel + '\'' +
                ", acceptEffect=" + acceptEffect +
                ", rejectEffect=" + rejectEffect +
                '}';
    }

}

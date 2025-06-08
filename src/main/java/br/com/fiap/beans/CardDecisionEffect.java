package br.com.fiap.beans;

public class CardDecisionEffect {

    private int id;
    private Card card;
    private String decisionType;
    private int effectBudget;
    private int effectFireUnits;
    private int effectMilitarySupport;
    private int effectLogistics;
    private int effectSavedLives;
    private int effectCrisisControl;
    private int effectPublicConfidence;
    private int effectStructuralIntegrity;

    public CardDecisionEffect() {
        super();
    }

    public CardDecisionEffect(int id, String decisionType, int effectBudget, int effectFireUnits, int effectMilitarySupport, int effectLogistics, int effectSavedLives, int effectCrisisControl, int effectPublicConfidence, int effectStructuralIntegrity) {
        super();

        this.id = id;
        this.decisionType = decisionType;
        this.effectBudget = effectBudget;
        this.effectFireUnits = effectFireUnits;
        this.effectMilitarySupport = effectMilitarySupport;
        this.effectLogistics = effectLogistics;
        this.effectSavedLives = effectSavedLives;
        this.effectCrisisControl = effectCrisisControl;
        this.effectPublicConfidence = effectPublicConfidence;
        this.effectStructuralIntegrity = effectStructuralIntegrity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public int getEffectBudget() {
        return effectBudget;
    }

    public void setEffectBudget(int effectBudget) {
        this.effectBudget = effectBudget;
    }

    public int getEffectFireUnits() {
        return effectFireUnits;
    }

    public void setEffectFireUnits(int effectFireUnits) {
        this.effectFireUnits = effectFireUnits;
    }

    public int getEffectMilitarySupport() {
        return effectMilitarySupport;
    }

    public void setEffectMilitarySupport(int effectMilitarySupport) {
        this.effectMilitarySupport = effectMilitarySupport;
    }

    public int getEffectLogistics() {
        return effectLogistics;
    }

    public void setEffectLogistics(int effectLogistics) {
        this.effectLogistics = effectLogistics;
    }

    public int getEffectSavedLives() {
        return effectSavedLives;
    }

    public void setEffectSavedLives(int effectSavedLives) {
        this.effectSavedLives = effectSavedLives;
    }

    public int getEffectCrisisControl() {
        return effectCrisisControl;
    }

    public void setEffectCrisisControl(int effectCrisisControl) {
        this.effectCrisisControl = effectCrisisControl;
    }

    public int getEffectPublicConfidence() {
        return effectPublicConfidence;
    }

    public void setEffectPublicConfidence(int effectPublicConfidence) {
        this.effectPublicConfidence = effectPublicConfidence;
    }

    public int getEffectStructuralIntegrity() {
        return effectStructuralIntegrity;
    }

    public void setEffectStructuralIntegrity(int effectStructuralIntegrity) {
        this.effectStructuralIntegrity = effectStructuralIntegrity;
    }

    @Override
    public String toString() {
        return "CardDecisionEffect{" +
                "id=" + id +
                ", card=" + card +
                ", decisionType='" + decisionType + '\'' +
                ", effectBudget=" + effectBudget +
                ", effectFireUnits=" + effectFireUnits +
                ", effectMilitarySupport=" + effectMilitarySupport +
                ", effectLogistics=" + effectLogistics +
                ", effectSavedLives=" + effectSavedLives +
                ", effectCrisisControl=" + effectCrisisControl +
                ", effectPublicConfidence=" + effectPublicConfidence +
                ", effectStructuralIntegrity=" + effectStructuralIntegrity +
                '}';
    }

}

package br.com.fiap.dto;

public class CardDecisionEffectDTO {

    private int effectBudget;
    private int effectFireUnits;
    private int effectMilitarySupport;
    private int effectLogistics;

    public CardDecisionEffectDTO() {
        super();
    }

    public CardDecisionEffectDTO(int effectBudget, int effectFireUnits, int effectMilitarySupport, int effectLogistics) {
        super();

        this.effectBudget = effectBudget;
        this.effectFireUnits = effectFireUnits;
        this.effectMilitarySupport = effectMilitarySupport;
        this.effectLogistics = effectLogistics;
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

    @Override
    public String toString() {
        return "CardDecisionEffectDTO{" +
                "effectBudget=" + effectBudget +
                ", effectFireUnits=" + effectFireUnits +
                ", effectMilitarySupport=" + effectMilitarySupport +
                ", effectLogistics=" + effectLogistics +
                '}';
    }

}

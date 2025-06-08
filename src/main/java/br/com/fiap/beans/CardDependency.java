package br.com.fiap.beans;

public class CardDependency {

    private int id;
    private Card parentCard;
    private Card addedCard;
    private String triggerChoice;

    public CardDependency() {
        super();
    }

    public CardDependency(int id, String triggerChoice) {
        super();

        this.id = id;
        this.triggerChoice = triggerChoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getParentCard() {
        return parentCard;
    }

    public void setParentCard(Card parentCard) {
        this.parentCard = parentCard;
    }

    public Card getAddedCard() {
        return addedCard;
    }

    public void setAddedCard(Card addedCard) {
        this.addedCard = addedCard;
    }

    public String getTriggerChoice() {
        return triggerChoice;
    }

    public void setTriggerChoice(String triggerChoice) {
        this.triggerChoice = triggerChoice;
    }

    @Override
    public String toString() {
        return "CardDependency{" +
                "id=" + id +
                ", parentCard=" + parentCard +
                ", addedCard=" + addedCard +
                ", triggerChoice='" + triggerChoice + '\'' +
                '}';
    }

}

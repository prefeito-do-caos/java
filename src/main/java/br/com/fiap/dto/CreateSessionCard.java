package br.com.fiap.dto;

import br.com.fiap.beans.Card;
import br.com.fiap.beans.GameSession;

import java.time.LocalDateTime;

public class CreateSessionCard {

    private int gameSessionId;
    private int cardId;
    private int sequenceOrder;

    public CreateSessionCard() {
        super();
    }

    public CreateSessionCard(int gameSessionId, int cardId, int sequenceOrder) {
        super();

        this.gameSessionId = gameSessionId;
        this.cardId = cardId;
        this.sequenceOrder = sequenceOrder;
    }

    public int getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(int gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getSequenceOrder() {
        return sequenceOrder;
    }

    public void setSequenceOrder(int sequenceOrder) {
        this.sequenceOrder = sequenceOrder;
    }

    @Override
    public String toString() {
        return "CreateSessionCard{" +
                "gameSessionId=" + gameSessionId +
                ", cardId=" + cardId +
                ", sequenceOrder=" + sequenceOrder +
                '}';
    }

}

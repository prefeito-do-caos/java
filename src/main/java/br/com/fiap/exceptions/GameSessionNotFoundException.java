package br.com.fiap.exceptions;

public class GameSessionNotFoundException extends Exception {

    public GameSessionNotFoundException() {
        super("Game session not found");
    }

}

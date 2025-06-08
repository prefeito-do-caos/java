package br.com.fiap.exceptions;

public class GameSessionExpiredException extends Exception {

    public GameSessionExpiredException() {
        super("This game session has expired");
    }
}

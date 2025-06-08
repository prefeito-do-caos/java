package br.com.fiap.exceptions;

public class IncorrectPasswordException extends Exception {

    public IncorrectPasswordException() {
        super("Incorrect current password");
    }

}

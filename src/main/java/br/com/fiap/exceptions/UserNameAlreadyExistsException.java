package br.com.fiap.exceptions;

public class UserNameAlreadyExistsException extends Exception {

    public UserNameAlreadyExistsException() {
        super("Name already exists");
    }

}

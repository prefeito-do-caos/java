package br.com.fiap.exceptions;

public class MedalNotFoundException extends Exception {

    public MedalNotFoundException() {
        super("Medal not found");
    }

}

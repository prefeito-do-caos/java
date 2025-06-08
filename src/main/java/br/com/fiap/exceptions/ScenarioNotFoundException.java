package br.com.fiap.exceptions;

public class ScenarioNotFoundException extends Exception {

    public ScenarioNotFoundException() {
        super("Scenario not found");
    }

}

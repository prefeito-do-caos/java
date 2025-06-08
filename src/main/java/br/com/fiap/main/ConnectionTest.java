package br.com.fiap.main;

import br.com.fiap.connections.ConnectionFactory;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args)  {

        try (Connection con = new ConnectionFactory().connection()) {
            System.out.println("Successfully connected to the database");
        } catch (ConnectionException | SQLException e) {
            System.err.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }

}

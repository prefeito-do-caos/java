package br.com.fiap.connections;

import br.com.fiap.exceptions.ConnectionException;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final Dotenv dotenv = Dotenv.load();

    public Connection connection() throws ConnectionException {

        try {
            String dbUrl = dotenv.get("DB_URL");
            String dbUser = dotenv.get("DB_USER");
            String dbPassword = dotenv.get("DB_PASSWORD");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e);
        }

    }

}

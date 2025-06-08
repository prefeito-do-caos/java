package br.com.fiap.dao;

import br.com.fiap.connections.ConnectionFactory;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO implements AutoCloseable {

    protected Connection con;

    public BaseDAO() throws ConnectionException {
        this.con = new ConnectionFactory().connection();
    }

    public Connection getConnection() {
        return this.con;
    }

    @Override
    public void close() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}

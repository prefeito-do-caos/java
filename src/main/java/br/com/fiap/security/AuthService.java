package br.com.fiap.security;

import br.com.fiap.beans.User;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.SQLException;

public class AuthService {

    public static PublicUser validUser(String username, String password) throws ConnectionException, SQLException {

        try (UserDAO userDAO = new UserDAO()) {
            User user = userDAO.findByName(username);

            if (user == null || !PasswordHash.checkPassword(password, user.getPassword())) {
                return null;
            }
            return new PublicUser(user);
        }
    }

}

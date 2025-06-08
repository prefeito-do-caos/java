package br.com.fiap.bo;

import br.com.fiap.beans.User;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.*;
import br.com.fiap.security.PasswordHash;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBO {

    public ArrayList<PublicUser> getAll() throws ConnectionException, SQLException {
        try (UserDAO userDAO = new UserDAO()) {
            return (ArrayList<PublicUser>) userDAO.findAll();
        }
    }

    public PublicUser getById(int id) throws ConnectionException, SQLException {
        try (UserDAO userDAO = new UserDAO()) {
            User user = userDAO.findById(id);
            return new PublicUser(user);
        }
    }

    public PublicUser insert(User user) throws
            ConnectionException, SQLException, UserNameAlreadyExistsException, InsertException {

        String hashedPassword = PasswordHash.hashPassword(user.getPassword());
        System.out.println(user.getName() + ' ' + hashedPassword);
        user.setPassword(hashedPassword);

        try (UserDAO userDAO = new UserDAO()) {

            User existentUser = userDAO.findByName(user.getName());
            if (existentUser != null) {
                throw new UserNameAlreadyExistsException();
            }

            int id = userDAO.insert(user);
            User insertedUser = userDAO.findById(id);

            return new PublicUser(insertedUser);
        }
    }

    public PublicUser update(int id, User user) throws
            ConnectionException, SQLException, UserNameAlreadyExistsException, UpdateException {

        try (UserDAO userDAO = new UserDAO()) {

            User existentUser = userDAO.findByName(user.getName(), id);
            if (existentUser != null) {
                throw new UserNameAlreadyExistsException();
            }

            userDAO.update(id, user);
            User updatedUser = userDAO.findById(id);

            return new PublicUser(updatedUser);
        }
    }

    public void updatePassword(int id, String password, String newPassword) throws
            ConnectionException, SQLException, UpdateException, IncorrectPasswordException {

        try (UserDAO userDAO = new UserDAO()) {

            User user = userDAO.findById(id);
            if (!PasswordHash.checkPassword(password, user.getPassword())) {
                throw new IncorrectPasswordException();
            }

            String hashedPassword = PasswordHash.hashPassword(newPassword);
            userDAO.updatePassword(id, hashedPassword);
        }
    }

}

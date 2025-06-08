package br.com.fiap.bo;

import br.com.fiap.beans.Medal;
import br.com.fiap.dao.MedalDAO;
import br.com.fiap.dto.UserMedal;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.SQLException;
import java.util.ArrayList;

public class MedalBO {

    public ArrayList<Medal> getAll() throws ConnectionException, SQLException {
        try (MedalDAO medalDAO = new MedalDAO()) {
            return (ArrayList<Medal>) medalDAO.findAll();
        }
    }

    public Medal getById(int id) throws ConnectionException, SQLException {
        try (MedalDAO medalDAO = new MedalDAO()) {
            return medalDAO.findById(id);
        }
    }

    public ArrayList<UserMedal> getByUserId(int userId) throws ConnectionException, SQLException {
        try (MedalDAO medalDAO = new MedalDAO()) {
            return (ArrayList<UserMedal>) medalDAO.findByUserId(userId);
        }
    }

}

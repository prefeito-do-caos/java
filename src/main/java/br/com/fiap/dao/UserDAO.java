package br.com.fiap.dao;

import br.com.fiap.beans.User;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.InsertException;
import br.com.fiap.exceptions.UpdateException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO {

    public UserDAO() throws ConnectionException {
        super();
    }

    public int insert(User user) throws InsertException {
        String sql = "INSERT INTO pdc_user (name, password) VALUES (?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, new String[] { "user_id" })) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new InsertException("Failed to insert user");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new InsertException("Failed to retrieve generated ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("SQL error while inserting user: " + e.getMessage(), e);
        }
    }

    public void update(int id, User user) throws UpdateException {
        String sql = "UPDATE pdc_user SET name = ? WHERE user_id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user.getName());

            stmt.setInt(2, id);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new UpdateException("Failed to update user");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new UpdateException("SQL error while updating user: " + e.getMessage(), e);
        }
    }

    public void updatePassword(int id, String password) throws UpdateException {
        String sql = "UPDATE pdc_user SET password = ? WHERE user_id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, password);

            stmt.setInt(2, id);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new UpdateException("Failed to update user");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new UpdateException("SQL error while updating user: " + e.getMessage(), e);
        }
    }

    public List<PublicUser> findAll() throws SQLException {
        String sql = "SELECT user_id, name, created_at FROM pdc_user ORDER BY user_id";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                List<PublicUser> users = new ArrayList<PublicUser>();

                while (rs.next()) {
                    PublicUser user = new PublicUser();

                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("name"));
                    user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    users.add(user);
                }

                return users;
            }

        }
    }

    public User findById(int id) throws SQLException {
        String sql = "SELECT user_id, name, password, created_at FROM pdc_user WHERE user_id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();

                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    return user;
                }

                return null;
            }
        }
    }

    public User findByName(String name) throws SQLException {
        return findByName(name, -1);
    }

    public User findByName(String name, int excludeId) throws SQLException {
        String sql = "SELECT user_id, name, password, created_at FROM pdc_user WHERE name = ?";
        if (excludeId != -1) {
            sql += " AND user_id != ?";
        }

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, name);
            if (excludeId != -1) {
                stmt.setInt(2, excludeId);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();

                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("name"));
                    user.setPassword(rs.getString("password"));
                    user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    return user;
                }

                return null;
            }
        }
    }

}

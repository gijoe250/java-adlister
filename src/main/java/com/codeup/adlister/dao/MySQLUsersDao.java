package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import model.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try{
            PreparedStatement stmt = createSelectQuery(username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    @Override
    public Long insert(User user) {
        try{
            PreparedStatement stmt = createInsertQuery(user);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private PreparedStatement createInsertQuery(User user) throws SQLException {
        String sql = "INSERT INTO users (username, email, password) VALUES ( ?, ?, ?)";
        PreparedStatement preStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preStmt.setString(1, user.getUsername());
        preStmt.setString(2, user.getEmail());
        preStmt.setString(3, user.getPassword());
        return preStmt;
    }

    private PreparedStatement createSelectQuery(String username) throws SQLException {
        String sql = "select * from users where username = ?";
        PreparedStatement preStmt = connection.prepareStatement(sql);
        preStmt.setString(1, username);
        return preStmt;
    }

    private User extractAd(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
}

package dao;

import model.Ad;
import model.Config;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try{
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> all() {
        String selectQueryAds = "SELECT * FROM ads";

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQueryAds);

            List<Ad> ads = new ArrayList<>();

            while (rs.next()) {
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getString("title"),
                                rs.getString("description")
                                ));
            }
            return ads;
        } catch(SQLException e) {
            throw new RuntimeException("Error connecting to database.", e);
        }

    }

    @Override
    public Long insert(Ad ad) {
        String query = String.format("INSERT INTO ads (user_id, title, description) VALUES (1, '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription());
        try{
            Statement stmt = this.connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

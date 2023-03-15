import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;

public class JDBCExample {
    public static void main(String[] args) throws SQLException {
        try{
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/codeup_test_db?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "codeup"
            );
            Statement stmt = connection.createStatement();
            String query = "select * from albums;";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("artist"));
            }
        }
        catch(SQLException e) {
            throw new RuntimeException("Error connecting to database.", e);
        }
    }
}

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class JDBCEmployees {
    public static void main(String[] args){
        try{
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employees?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "codeup"
            );
            Statement stmt = connection.createStatement();
            String query = "select first_name, last_name from employees;";

            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> names = new ArrayList<>();

            for (int i=0; i<10; i++){
                rs.next();
                String small = rs.getString("first_name") + " " + rs.getString("last_name");
                names.add(small);
                System.out.println(names.get(i));
            }
        }
        catch(SQLException e) {
            throw new RuntimeException("Error connecting to database.", e);
        }
    }
}

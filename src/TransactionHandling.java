import java.sql.*;
import java.util.Scanner;

public class TransactionHandling {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "Dhiraj#62";
    public static void main(String[] args) {

        try{
            // Driver load
            Class.forName("com.mysql.cj.jdbc.Driver");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            // database Connection
            Connection conn = DriverManager.getConnection(url ,username, password);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

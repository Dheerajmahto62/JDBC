
import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class JDBCBatch {
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
            // Database connection
            Connection conn = DriverManager.getConnection(url , username, password);
            Statement statement = conn.createStatement();
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("Enter name : ");
                String name = sc.next();
                System.out.print("Enter age : ");
                int age = sc.nextInt();
                System.out.print("Enter marks : ");
                double marks = sc.nextDouble();
                System.out.print("Enter more data -->(Y/N) :");
                String choice = sc.next();

                String query = String.format("INSERT INTO students(name , age , marks) VALUES('%s',%d,%f)", name , age , marks );
                statement.addBatch(query);

                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr = statement.executeBatch();

            for(int i = 0; i<arr.length; i++){
                if(arr[i]==0){
                    System.out.println("Query" + i + "not executed Successfully !!");
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

// Batch Processing --> it is used insert multiple value at a time

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCBatchPreState {
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
            String query ="INSERT INTO students(name , age , marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
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

                preparedStatement.setString(1 , name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);


                preparedStatement.addBatch(query);

                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr = preparedStatement.executeBatch();

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

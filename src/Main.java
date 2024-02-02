import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/mydb" ;
    private static final String username = "root";
    private static final String password = "Dhiraj#62";
    public static void main(String[] args){
        try{
            // Driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

                // Connection in the DataBase
        try{
            Connection conn = DriverManager.getConnection(url , username , password);
            Statement statement = conn.createStatement();
            // Insert Data ---
//            String query = "INSERT INTO students(name , age , marks) VALUES ('Rahul' , 19 , 40)";// Method -- 1
//            String query = String.format("INSERT INTO students(name , age , marks) VALUES ('%s' , %o , %f)", "Mahto" , 20, 85.40); // Method -- 2

            // Update Data
//            String query = String.format("UPDATE students SET marks = %f WHERE id = %d" , 80.10 ,3);

            String query  = "DELETE FROM students WHERE id= 6";
            int  resultSet = statement.executeUpdate(query);
            if(resultSet>0){
                System.out.println("Data DELETED");
            }
            else{
                System.out.println("Data DID Not DELETED ");
            }

                     // Show table
//            String query = "SELECT * FROM students";
//            ResultSet resultset = statement.executeQuery(query);
//            while(resultset.next()){
//                int id = resultset.getInt("id");
//                String name  = resultset.getString("name");
//                int age = resultset.getInt("age");
//                double marks = resultset.getDouble("marks");
//                System.out.println("ID : " + id) ;
//                System.out.println("Name : "+ name);
//                System.out.println("Age : " + age);
//                System.out.println("Marks : " + marks) ;
//            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

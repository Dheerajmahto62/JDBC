import java.sql.*;

public class JDBCPrepSat {
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
            // Insertion Operation --
//            String query = "INSERT INTO students(name , age , marks) VALUES(? , ? , ? )";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//
//            preparedStatement.setString(1, "Radhika");
//            preparedStatement.setInt(2, 20);
//            preparedStatement.setDouble(3, 78.80);

//            int  InsertData = preparedStatement.executeUpdate();
//            if(InsertData>0){
//                System.out.println("Data INSERTED");
//            }
//            else{
//                System.out.println("Data DID Not INSERTED ");
//            }

            // Retrieve Data
//            String query = "SELECT * FROM students WHERE id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1,3 );
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks : " +marks);
//            }
//            else{
//                System.out.println("Marks not found!!");
//            }


            // UPDATES OPERATION


//            String query = "UPDATE students set marks = ? WHERE id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setDouble(1,80.20);
//            preparedStatement.setInt(2,4);
//            int resultSet = preparedStatement.executeUpdate();
//            if (resultSet>0){
//                System.out.println("Data Updated Successfully");
//            }
//            else{
//                System.out.println("Data not Updated ");
//            }


            // Delete Operation

            String query = "DELETE FROM students WHERE id  = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,8);
//            preparedStatement.setInt(2,);
            int resultset = preparedStatement.executeUpdate();
            if (resultset>0){
                System.out.println("Data deleted Successfully");
            }
            else{
                System.out.println("Data not deleted");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}


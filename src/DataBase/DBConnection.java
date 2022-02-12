package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private final static String dbUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;databaseName=RefugeeManagementSystem";

    public void DatabaseConnect() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            connection = DriverManager.getConnection(dbUrl);
            if(connection!=null){
                System.out.println("***Connected***");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    public void DisconnectDB(){
        try{
            if(connection != null && !connection.isClosed()){
                    connection.close();
                    System.out.println("***Disconnected***");
            }
        }catch(SQLException e){
                e.printStackTrace();
        }
    }
}

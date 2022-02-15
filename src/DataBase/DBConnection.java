package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection connection;
    public static final String dbUrl = "jdbc:sqlserver://localhost:1433;user=sa;password=p@ssword13;databaseName=RefugeeManagementSystem";

    public Connection DatabaseConnect() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            connection = DriverManager.getConnection(dbUrl);
            if(connection!=null){
                System.out.println("***Connected***");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }
    }

    public Connection DisconnectDB(){
        try{
            if(connection != null && !connection.isClosed()){
                    connection.close();
                    System.out.println("***Disconnected***");
            }
            return connection;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

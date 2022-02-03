package ConnectToDB;

import java.sql.*;

public class DatabaseConnection {
    Statement statmnt;
    Connection connection;

    public void ConnectToDB() throws ClassNotFoundException, SQLException{
        System.out.println("Database Connecting......");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url  = "jdbc:sqlserver://localhost;databaseName=RefugeeManagementSystem;user=sa;password=p@ssword;";
        connection = DriverManager.getConnection(url);
        if(connection != null){
            System.out.println("**Database Connected**");
        }
        
    }

    public void CloseConnection(){
        try{
            if(statmnt != null)
            statmnt.close();
            if(connection != null)
            connection.close();
        }catch(SQLException e){   
            e.printStackTrace();
        }
    }

    public boolean insertInDB(String query){
        try {
            statmnt = connection.createStatement();
            statmnt.executeQuery(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

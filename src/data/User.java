package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.DBConnection;
import GUI.LoginController;

public class User {
    /*DBConnection connector;

    private int id;
    public String name, email, phone;
    private String pass;
}
public User()
{
    id=0;
    name=null;
    email=null;
    pass=null;
}
public User(String name, String email, String phone, String pass){
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.pass = pass; 
}
public int get_id(){
    return this.id;
}

<<<<<<< HEAD
public User(int id) throws SQLException {
    this.id = id;
}

public static User get_id(int id) throws SQLException{
    return new User(id);
}
=======
    public User() {
    }
>>>>>>> 25c9c7c3eb75e6fda0f93919e9ed3c7dbfc855cb

public String get_pass(){
    return this.pass;
} 

public void set_pass(String pass){
    this.pass = pass;
}
public void insert() throws SQLException{
    String query = "insert into \"user\"(name, email, phone, pass) values('" + name + "', '" + email + "', '" + phone + "', '" + pass + "' )";
    DBConnection conn = new DBConnection();
    conn.DatabaseConnect().executeUpdate(query);
}
  
public void update() throws SQLException{
    String new_id = String.valueOf(LoginController.uid);

    String query= "update \"user\" set name='" + name + "', email='" + email + "', phone='" + phone + "', pass='" + pass + "',  where id=" + new_id + ";";
    System.out.println(query);
    DBConnection conn = new DBConnection();
    conn.createStatement().executeUpdate(query);
}

public void delete() throws SQLException{
    String query = "delete from \"user\" where id=" + id;
    DBConnection conn = new DBConnection();
    conn.createStatement().execute(query);
}

private void convert_User(ResultSet resultSet) throws SQLException{
    id = resultSet.getInt("id");
    name = resultSet.getString("name");
    email = resultSet.getString("email");
    phone = resultSet.getString("phone");
    pass = resultSet.getString("pass");
    
}

public static User get_info(String mobile) throws SQLException{
    String query = "select * from \"user\" where mobile='" + mobile + "'";
    DBConnection con = new DBConnection();
    ResultSet resultSet = con.createStatement().executeQuery(query);
    resultSet.next();
    User user = new User();
    user.convert_User(resultSet);
    return user;
}

    public User()
    {
        id=0;
        name=null;
        email=null;
        pass=null;
    }
    public User(String name, String email, String phone, String pass){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass; 
    }
    public int get_id(){
        return this.id;
    }

    public User(int id) throws SQLException {
        this.id = id;
    }

    public static User get_id(int id) throws SQLException{
        return new User(id);
    }

    public String get_pass(){
        return this.pass;
    } 

    public void set_pass(String pass){
        this.pass = pass;
    }
    public void insert() throws SQLException{
        String query = "insert into \"user\"(name, email, phone, pass) values('" + name + "', '" + email + "', '" + phone + "', '" + pass + "' )";
    // DBConnection conn = new DBConnection();
        //conn.DatabaseConnect().executeUpdate(query);
    }*/
}


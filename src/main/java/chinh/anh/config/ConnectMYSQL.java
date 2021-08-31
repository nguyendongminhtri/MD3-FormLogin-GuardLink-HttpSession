package chinh.anh.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMYSQL {
    private static Connection connection;

    public ConnectMYSQL() {
    }
//    mysql://b3b24bafb765f8:359fd5ca@us-cdbr-east-04.cleardb.com/heroku_8426d25f2a59a54?reconnect=true
    public static final String URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/servlet_login";
    public static final String USER = "b3b24bafb765f8";
    public static final String PASSWORD = "359fd5ca";
    public static Connection getConnection(){
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("Connect success!");
            } catch (ClassNotFoundException | SQLException e){
                System.out.println("Connect MYSQL failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}

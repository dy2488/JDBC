package jdbc;

import javax.management.DescriptorRead;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBC_TOOL {
    public JDBC_TOOL(){

    }
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static{
        try {
            ClassLoader classLoader = JDBC_TOOL.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            Properties properties = new Properties();
//            properties.load(new FileReader("src/jdbc.properties"));
//            System.out.println(path);
            properties.load(new FileReader(path));
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
           Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  public static Connection get_connection() throws SQLException {
        return DriverManager.getConnection(url,user ,password );
   }
    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
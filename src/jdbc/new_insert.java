package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class new_insert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;
        try {
            connection=JDBC_TOOL.get_connection();
            statement = connection.createStatement();
            String sql="select *from test";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String s = resultSet.getString("id");
                String s1 = resultSet.getString("password");
                System.out.println("账号"+s+"密码"+s1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBC_TOOL.close(resultSet, statement, connection,null);
        }
    }
}

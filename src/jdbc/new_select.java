package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class new_select {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBC_TOOL.get_connection();
            statement = connection.createStatement();
            String sql = "select *from zhanghu";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString(1);
                int anInt = resultSet.getInt(2);
                String s = resultSet.getString(3);
                System.out.println("名字"+name+"性别"+anInt+"生日"+s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    finally {
            JDBC_TOOL.close( resultSet, statement, connection,null);
        }

    }
}

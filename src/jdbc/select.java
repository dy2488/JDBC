package jdbc;

import java.sql.*;

public class select {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement =null;
        ResultSet resultSet =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dingyu?serverTimezone=UTC", "root", "DingYu,!199000521");
            String sql ="select *from family";
             statement = connection.createStatement();
             resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int i = resultSet.getInt(2);
                String anInt = resultSet.getString(3);
                System.out.println(name+i+anInt);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
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
}

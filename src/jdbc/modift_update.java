package jdbc;

import java.sql.*;

public class modift_update {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dingyu?serverTimezone=UTC", "root", "DingYu,!199000521");
            String sql = "update family set sex=1 where name='丁雨'";
            statement=connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);//输出影响行数
            if(i>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
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
        }
    }
}

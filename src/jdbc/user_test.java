package jdbc;

import java.sql.*;
import java.util.Scanner;

public class user_test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String u = scanner.nextLine();
        System.out.println("请输入密码");
        String p = scanner.nextLine();
        boolean loo = new user_test().login(u,p);
        if(loo){
            System.out.println("登陆成功");
        }else
            System.out.println("登陆失败");
        }


    public boolean login(String username,String password){
        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement pre =null;
        if(username == null ||password ==null){
            return false;
        }
        try {
            connection=JDBC_TOOL.get_connection();
            String sql="select *from test where id=?and password=?";
            pre = connection.prepareStatement(sql);
            resultSet = pre.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC_TOOL.close(resultSet, pre, connection);
        }


        return false;
    }

}

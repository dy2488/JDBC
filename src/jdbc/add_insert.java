package jdbc;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class add_insert {
    public static void main(String[] args) {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dingyu?serverTimezone=UTC", "root", "DingYu,!199000521");
             statement = connection.createStatement();
            String sql = "insert into zhanghu values(123,123)";
            int i = statement.executeUpdate(sql);//影响的行数
            System.out.println(i);
            if(i>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
                //为了避免空指针异常
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
        }
    }
}

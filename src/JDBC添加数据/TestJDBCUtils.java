package JDBC添加数据;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-19 20:05
 * Copyright(c):
 * Version:
 * explain:
 *  使用JDBC插入数据
 */

public class TestJDBCUtils {
    public static void main(String[] args) throws Exception, SQLException {
       //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接数据库
        String url = "jdbc:mysql://localhost:3306/mybase";
        String user = "root";
        String password = "root";
        Connection con =DriverManager.getConnection(url, user, password);
        System.out.println(con);    //有输出说明数据库连接成功

        //3、获取SQL语句
        Statement stat = con.createStatement();

        //4、执行SQL语句
        int row = stat.executeUpdate(
                "INSERT INTO sort(sname,sprice,sdesc) value ('汽车用品',50000,'新品SUV')"
        );
        System.out.println(row);    //输出  1 说明sql语句执行成功

        //5、释放资源
        stat.close();
        con.close();


    }
}

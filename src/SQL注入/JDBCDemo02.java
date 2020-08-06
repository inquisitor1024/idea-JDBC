package SQL注入;

import java.sql.*;
import java.util.Scanner;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-20 15:24
 * Copyright(c):
 * Version:
 * explain:
 */

public class JDBCDemo02 {
    public static void main(String[] arge) throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url,username,password);

                //3、获取SQL语句对象
        Statement stat = con.createStatement();
        //文本扫描器
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String user = sc.nextLine();
        System.out.println("请输入密码");
        String pwd = sc.nextLine();
        //拼写SQL语句
//        String sql = "SELECT * FROM users WHERE username ='32141' AND PASSWORD = '32' OR 1 =1;";
        String sql = "SELECT * FROM users WHERE username ="+user+" AND PASSWORD = "+pwd;

        //4、调用方法
        ResultSet rs = stat.executeQuery(sql);
//        System.out.println(rs.next()); 返回true则为真
        if (rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("账号或密码错误");
        }

        //遍历结果集
        while (rs.next()){
            System.out.println(rs.getObject("username")+"   "+rs.getObject("password"));
        }
        //5、关闭资源
        rs.close();
        stat.close();
        con.close();

        }
}

/**
 *
 * 请输入账号
 * 2341
 * 请输入密码
 * 41 or 1=1
 * 登录成功
 * 456   def
 *
 *
 */

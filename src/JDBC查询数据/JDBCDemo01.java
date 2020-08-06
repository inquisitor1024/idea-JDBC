package JDBC查询数据;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-19 21:18
 * Copyright(c):
 * Version:
 * explain:
 * 使用JDBC技术 查询数据表，获取结果值
 */

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        // 1、注册启动
        Class.forName("com.mysql.jdbc.Driver");

        // 2、获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String user = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);
        //3、获取执行SQL语句的对象
        Statement stat = con.createStatement();

        //拼写SQL语句
        String sql = "SELECT * FROM sort ";
        //4、调用对象方法
        /**
         * ResultSet executeQuery(String sql) 执行SQL语句的select查询
         * 返回值 ResultSet接口的实现类对象，实习类在mysql驱动中
         */
        //获取结果集
        ResultSet rs = stat.executeQuery(sql);

        //5、关闭资源
//        System.out.println(rs); //com.mysql.jdbc.JDBC4Connection@5a10411 为接口实现类

        //ResultSet 接口方法 boolean next() 返回true，有结果集，返回false无结果集，查询内容不存在
        //true 说明有结果集但不知道有几个
        System.out.println(rs.next());

        //迭代器 让光标依次判断并输出
        while (rs.next()) {
            //获取每一列的数据，使用的是ResultSet 接口方法 getxxxx
            //第一列数据是int类型
            System.out.println(
                    //第一种方式
//                    rs.getInt("sid")+"\t"
//                    + rs.getString("sname")+"\t"
//                    + rs.getDouble("sprice")+"\t"
//                    + rs.getString("sdesc")

                    //第二种方式:偷懒方式
                     rs.getObject("sid")+"\t"
                    + rs.getObject("sname")+"\t"
                    + rs.getObject("sprice")+"\t"
                    + rs.getObject("sdesc")
            );
        }
        rs.close(); //关闭结果集
        stat.close();//关闭执行者对象
        con.close();//关闭连接对象


    }

}

//        3	儿童玩具	300.0	赚家长钱
//        5	服装	24000.0	换季销售

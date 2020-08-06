package JDBC预编译SQL语句执行修改;

import java.sql.*;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-21 08:20
 * Copyright(c):
 * Version:
 * explain:
 *  使用PrepareStatement 接口，实现数据表的更新操作
 */

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url,username,password);

        //拼写SQL语句
        String sql = "SELECT * FROM sort";

        PreparedStatement pst = con.prepareStatement(sql);

        //调用pst对象的方法，执行查询语句select 语句
        ResultSet rs = pst.executeQuery();

        //打印结果集
        while (rs.next()){
            System.out.println(rs.getObject("sid")+"  "
                    +rs.getObject("sname")+"  "
                    +rs.getObject("sprice")+"  "
                    +rs.getObject("sdesc"));
        }

        con.close();
        pst.close();
        rs.close();
    }
}

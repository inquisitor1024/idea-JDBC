package Text;


import java.sql.*;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-25 17:43
 * Copyright(c):
 * Version:
 * explain:
 */

public class JDBC_Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);

        Statement stat = con.createStatement();
        String sql ="SELECT * FROM  sort";
        ResultSet rs = stat.executeQuery(sql);
        System.out.println(rs.next());


        con.close();


    }
}

package Text;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-25 08:38
 * Copyright(c):
 * Version:
 * explain:
 */

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement stat = con.createStatement();
        int sql = stat.executeUpdate(
                ""
        );

        System.out.println(sql);

        stat.close();
        con.close();
    }
}

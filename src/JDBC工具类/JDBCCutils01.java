package JDBC工具类;

import java.sql.*;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-21 08:42
 * Copyright(c):
 * Version:
 * explain:
 * 实现JDBC的工具类
 * 定义方法，直接返回数据库的连接对象
 * <p>
 * 写关闭方法
 */

public class JDBCCutils01 {
    /*
     * 私有化，防止修改
     */

    private JDBCCutils01() {
    }

    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mybase";
            String user = "root";
            String password = "root";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            //连接失败了，就直接停止，并提示
            throw new RuntimeException(ex + "数据库连接失败");
        }
    }

    /*
     * 定义静态方法,返回数据库的连接对象
     */
    public static Connection getConnection() {
        return con;
    }

    public static void close(Connection con, Statement stat) {

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException ex) {
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }

    }

    public static void close(Connection con, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
            }
        }

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException ex) {
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }

    }
}

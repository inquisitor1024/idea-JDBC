package SQL注入;


import java.sql.*;
import java.util.Scanner;

/**
 * Java程序实现用户登录,用户名和密码,数据库检查
 * 防止注入攻击
 * Statement接口实现类,作用执行SQL语句,返回结果集
 * 有一个子接口PreparedStatement  (SQL预编译存储,多次高效的执行SQL)
 * PreparedStatement的实现类数据库的驱动中,如何获取接口的实现类
 * <p>
 * 是Connection数据库连接对象的方法
 * PreparedStatement prepareStatement(String sql)
 */

public class JDBCDemo03 {
    public static void main(String[] arge) throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接对象
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println(con);

        //文本扫描器
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String user = sc.nextLine();
        System.out.println("请输入密码");
        String pwd = sc.nextLine();
        //拼写SQL语句
//        String sql = "SELECT * FROM users WHERE username ='32141' AND PASSWORD = '32' OR 1 =1;";
        String sql = "SELECT * FROM users WHERE username = ? AND PASSWORD = ? ";
        //3、获取SQL语句对象
        PreparedStatement pst = con.prepareStatement(sql);
        //4、调用方法，获取结果集

        //SQL中的参数都是以? 的形式来占位
        //表示第一个问号是user参数，第二个问号是pwd参数
        pst.setObject(1, user);
        pst.setObject(2, pwd);

        //遍历结果集
        ResultSet rs = pst.executeQuery();
        //返回true则为真
//        System.out.println(rs.next());
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("账号或密码错误");
        }
        //5、关闭资源
        rs.close();
        pst.close();
        con.close();

    }
}

/**
 * 请输入账号
 * 2341
 * 请输入密码
 * 41 or 1=1
 * 登录成功
 * 456   def
 */



package JDBC工具测试类;

import JDBC工具类.JDBCCutils01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @projectName:
 * @fileName:
 * @packageName: TestJDBCUtils
 * @author: Mr.乐
 * @date: 2020/7/8 21:17
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 *
 *
 */

public class TestJDBCUtils {
    public static void main(String[] arge) throws Exception {
        Connection con = JDBCCutils01.getConnection();
        PreparedStatement pst = con.prepareStatement("select name from sort;");
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getObject("name"));
        }

        JDBCCutils01.close(con,pst,rs);

    }

}

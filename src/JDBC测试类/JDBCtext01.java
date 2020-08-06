package JDBC测试类;

import JDBC工具类.JDBCCutils01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ProjectName:
 * FileName:
 * PackageName:
 * TheAuthor:
 * DATE: 2020-06-21 10:00
 * Copyright(c):
 * Version:
 * explain:
 */

public class JDBCtext01 {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCCutils01.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT sname FROM sort");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("sname"));
        }
        JDBCCutils01.close(con, pst, rs);
		/*List list = new XXXX()
		 * while(rs.next()){
			Sort s = new Sort(rs.getInt("")......);
			list.add(s);
		}
		 * */
    }
}

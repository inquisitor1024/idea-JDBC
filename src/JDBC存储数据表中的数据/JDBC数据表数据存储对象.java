package JDBC存储数据表中的数据;

import JDBC工具类.JDBCCutils01;
import dommain.Sort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName:
 * @fileName:
 * @packageName: JDBC数据表数据存储对象
 * @author: Mr.乐
 * @date: 2020/7/9 10:46
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 */

public class JDBC数据表数据存储对象 {
    public static void main(String[] arge) throws SQLException {
        //使用JDBC工具类，直接获取数据库连接对象
        Connection con = JDBCCutils01.getConnection();
        //连接获取数据库SQL语句执行者对象
        PreparedStatement pst = con.prepareStatement("SELECT * FROM ssort;");
        //调用查询方法，获取结果集
        ResultSet rs = pst.executeQuery();
        //创建一个集合对象s
        List<Sort>  list = new ArrayList<Sort>();

        while (rs.next()){
            //获取到每一个列数据

            Sort s = new Sort(rs.getInt("id"),rs.getString("name"),rs.getInt("monery"));
            //封装到Sort类中，在存储到集合中
            list.add(s);

        }
        //关闭资源
        JDBCCutils01.close(con,pst,rs);

        //遍历List集合
        for (Sort s : list){
            System.out.println(s);
        }


    }

}

package com.JavaSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class JdbcAction {
    // 创建静态全局变量
    static Connection conn;

    static Statement st;
    /* 获取数据库连接的函数*/
    public static Connection getConnection() {
        Connection con = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pc", "root", "123456");// 创建数据连接

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return con; //返回所建立的数据库连接
    }

    public static void insert(Video v){
        conn = getConnection(); // 首先要获取连接，即连接到数据库
        try {
            String sql = "INSERT INTO video(itemGuid, itemDate, itemEnUrl,itemEnType, itemAuthor, " +
                    "itemKeyword,itemDuration,itemDesc,itemLink,itemTitle )"
                    + " VALUES ('"+v.getItemGuid()+"','"+v.getItemDate()+"','"+v.getItemEnUrl()+"','"+v.getItemEnType()+
                    "','"+v.getItemAuthor()+"','"+v.getItemKeyword()+"','"+v.getItemDuration()+"','"+v.getItemDesc()+"','"+
                    v.getItemLink()+"','"+v.getItemTitle()+"')";  // 插入数据的sql语句
            System.out.println("sql="+sql);
            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象

            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("向video表中插入 " + count + " 条数据"); //输出插入操作的处理结果

            conn.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
        }
    }

    public static boolean query(String guid) {
        conn = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "select * from video where itemGuid="+guid;     // 查询数据的sql语句
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
            while (rs.next()) { // 判断是否还有下一个数据
                return true ;
            }
            conn.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("查询数据失败");
        }
        return false;
    }

    public static List<Video> findAll() {
        conn = getConnection(); //同样先要获取连接，即连接到数据库
        List<Video> vl = new ArrayList<Video>() ;
        try {
            String sql = "select * from video where state=400";     // 查询数据的sql语句
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
            while (rs.next()) { // 判断是否还有下一个数据
                String itemGuid = rs.getString("itemGuid");
                String itemDate = rs.getString("itemDate");
                String itemTitle = rs.getString("itemTitle");
                String itemLink = rs.getString("itemLink");
                String itemDesc = rs.getString("itemDesc");
                String itemDuration = rs.getString("itemDuration");

                String itemKeyword = rs.getString("itemKeyword");
                String itemAuthor = rs.getString("itemAuthor");
                String itemEnType = rs.getString("itemEnType");
                String itemEnUrl = rs.getString("itemEnUrl");
                int state = rs.getInt("state");
                Video v = new Video() ;
                v.setItemAuthor(itemAuthor) ;
                v.setItemDate(itemDate) ;
                v.setItemDesc(itemDesc) ;
                v.setItemDuration(itemDuration) ;
                v.setItemEnType(itemEnType) ;
                v.setItemEnUrl(itemEnUrl) ;
                v.setItemGuid(itemGuid) ;
                v.setItemKeyword(itemKeyword) ;
                v.setItemLink(itemLink) ;
                v.setItemTitle(itemTitle) ;
                v.setState(state) ;
                vl.add(v) ;
            }
            conn.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("查询数据失败");
        }
        return vl ;
    }

    /* 更新符合要求的记录，并返回更新的记录数目*/
    public static void update(Video v) {
        conn = getConnection(); //同样先要获取连接，即连接到数据库
        try {
            String sql = "update video set state=402 where itemGuid="+v.getItemGuid();// 更新数据的sql语句

            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数

            System.out.println("video表中更新 " + count + " 条数据");      //输出更新操作的处理结果

            conn.close();   //关闭数据库连接

        } catch (SQLException e) {
            System.out.println("更新数据失败");
        }
    }
}

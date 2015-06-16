/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasql;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;


public class JavaSQL {
    // 创建静态全局变量  
    static Connection conn;  
    static Statement st;  
    // 获取数据库连接的函数  
    public static Connection getConnection() {  
        Connection con = null;
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/test", "TEST", "123456");// 创建数据连接 
             if (!con.isClosed())
                System.out.println("Successfully connected to MySQL server using TCP/IP...");// 连接成功提示
        // 由Connection对象创建Statement             
        } catch (Exception DBConnectError) {  
            System.out.println("Database connection error!" + DBConnectError.getMessage());  // 连接错误提示
        }  
        return con; //返回所建立的数据库连接  
    }  
    
	public static void insert(Student stu){
		conn = getConnection(); // 首先要获取连接，即连接到数据库  
	    try {  
	        String sql = "INSERT INTO Student(StuNumber, StuName, StuSexual,StuAge, StuGrade, StuClass, StuScore "+
                    " VALUES ('"+stu.getStuNumber()+"','"+stu.getStuName()+"','"+stu.getStuSexual()+"','"+stu.getStuAge()+"','"+
                    stu.getStuGrade()+"','"+stu.getClass()+"','"+stu.getStuScore()+"')'";  // 插入数据的sql语句  
	        System.out.println("SQL="+sql);
	        st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
	          
	        int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
	          
	        System.out.println("Insert student table " + count + " rows"); //输出插入操作的处理结果  
	          
	        conn.close();   //关闭数据库连接  
	          
	    } catch (SQLException InsertDataError) {  
	        System.out.println("Insert data error!" + InsertDataError.getMessage());  
	    }  
	}
	
	public static boolean query(String StuNumber) {  
	    conn = getConnection(); //同样先要获取连接，即连接到数据库  
	    try {  
	        String sql = "select * from student where StuNumber="+StuNumber;     // 查询数据的sql语句  
	        st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
	          
	        ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
	        while (rs.next()) { // 判断是否还有下一个数据  
	            return true ;
	        }
	        conn.close();   //关闭数据库连接  
	          
	    } catch (SQLException e) {  
	        System.out.println("Select data error");  
	    }
		return false;  
	}  
	
	public static List<Student> findAll() {  
	    conn = getConnection(); //同样先要获取连接，即连接到数据库  
	    List<Student> vl = new ArrayList<Student>() ;
	    try {  
	        String sql = "select * from student where state=400";     // 查询数据的sql语句  
	        st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
	        ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
	        while (rs.next()) { // 判断是否还有下一个数据  
	        String StuNumber = rs.getString("StuNumber");  
                String StuName = rs.getString("StuName");  
                String StuSexual = rs.getString("StuSexual");  
                String StuAge = rs.getString("StuAge");  
                String StuGrade = rs.getString("StuGrade");  
                String StuClass = rs.getString("StuClass");                 
                String StuScore = rs.getString("StuScore");     
                Student stu = new Student();
                stu.setStuNumber(StuNumber);
                stu.setStuName(StuName);
                stu.setStuSexual(StuSexual);
                stu.setStuAge(StuAge);
                stu.setStuGrade(StuGrade);
                stu.setStuClass(StuClass);
                stu.setStuScore(StuScore);
                vl.add(stu) ;
	        }
	        conn.close();   //关闭数据库连接  
	          
	    } catch (SQLException e) {  
	        System.out.println("Select data error");  
	    }
	    return vl ;
	}  
	
	/* 更新符合要求的记录，并返回更新的记录数目*/  
    public static void update(Student stu) {  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "update student set state=402 where StuNumber="+stu.getStuNumber();// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("Student table updated " + count + " rows");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("Update data error!");  
        }  
    }
    public static void main(String[] args){
        System.out.println("HELLO,MySQL!");
    }
}

package com.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class DBUtil {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/sunjob";
	private static final String user = "root";
	private static final String pass = "1018222wxw";
	
	//实例化
	private static Vector<Connection> connectionPool = new Vector<Connection>();
	
	//初始化
	static{
		try {
			Class.forName(driver);
			for(int i = 0; i < 10; i++){
				Connection conn = DriverManager.getConnection(url, user, pass);
				connectionPool.add(conn);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//获得连接
	public static Connection getConnection(){
		Connection conn = connectionPool.get(0);
		connectionPool.remove(0);
		return conn;
	}
	
	//释放连接
	public static void releaseConnection(Connection conn){
		
		connectionPool.add(conn);
	}
	
	
	//查询
	public static List<Object> query(Class c, String sql, Object... p){
		
		ArrayList<Object> list = new ArrayList<Object>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < p.length; i++){
				ps.setObject(i+1, p[i]);
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			while(rs.next()){
				Object object = c.newInstance();
				
				for(int i = 0; i < n; i++){
					String fieldName = rsmd.getColumnLabel(i+1);
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);//设置私有属性可以访问
					field.set(object, rs.getObject(i+1));
				}
				list.add(object);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return list;
		
	}
	
	//增删改
	public static int update(String sql, Object... p){
		
		Connection conn = DBUtil.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < p.length; i++){
				ps.setObject(i+1, p[i]);
			}
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		return n ;
		
	}

}

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		try{
			Class.forName(driver);
			for(int i = 0; i < 10; i++){
				Connection conn = DriverManager.getConnection(url, user, pass);
				connectionPool.add(conn);
			}
		}catch(Exception e){
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
	public static ResultSet query(String sql, Object...p){
		
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < p.length; i++){
				ps.setObject(i+1, p[i]);
			}
			rs = ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//增删改
	public static int update(String sql, Object...p){
		
		Connection conn = DBUtil.getConnection();
		int n = 0;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < p.length; i++){
				ps.setObject(i+1, p[i]);
			}
			n = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.releaseConnection(conn);
		}
		return n;
	}
	

}

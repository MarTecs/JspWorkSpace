package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DBUtil {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/sunjob";
	private static final String user = "root";
	private static final String pass = "1018222wxw";
	
	//ʵ����
	public static Vector<Connection> connectionPool = new Vector<Connection>();
	
	//��ʼ��
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			for(int i = 0; i < 10; i++){
				Connection conn = DriverManager.getConnection(url, user, pass);
				connectionPool.add(conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//ȡ������
	public static Connection getConnection(){
		Connection conn = connectionPool.get(0);
		connectionPool.remove(0);
		return conn;
	}
	
	//�ͷ�����
	public static void releaseConnection(Connection conn){
		connectionPool.add(conn);
	}
	
	//��ѯ:���ﲻ�������ӵ��ͷţ���Ϊ�������ʹ�õ�ʱ���ͷ�֮�󣬺�����û���ʹ�õ�ǰ���ӽ��в�ѯ��
	//֮ǰ�Ľ�����ᱻ����
	public static ResultSet query(String sql, Object...q){
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < q.length; i++){
				ps.setObject(i+1, q[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}
	
	//��ɾ�Ĳ���
	public static int update(String sql, Object...q){
		Connection conn = DBUtil.getConnection();
		int n = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0; i < q.length; i++){
				ps.setObject(i+1, q[i]);
			}
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.releaseConnection(conn);
		}
		
		return n;
	}
	
	
}

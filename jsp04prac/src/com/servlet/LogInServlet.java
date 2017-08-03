package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class LogInServlet implements javax.servlet.Servlet{
	
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost/sunjob";
	private final static String user = "root";
	private final static String pass = "1018222wxw";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "select * from userinfo where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);
			ps.setObject(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				((HttpServletResponse)response).sendRedirect("login.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}

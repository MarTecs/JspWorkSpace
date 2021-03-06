package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBUtil;

public class UserServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		
		String way = request.getParameter("others");
		if("register".equals(way)){
			doRegister(request, response);
		}
		if("login".equals(way)){
			doLogin(request, response);
		}
	}
	
	
	/**
	 * ע��
	 * @param request
	 * @param response
	 */
	public void doRegister(HttpServletRequest request, HttpServletResponse 
			response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "insert into userinfo(username, password) values(?, ?)";
		int n = DBUtil.update(sql, username, password);
		if(n > 0){
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * ��¼
	 * @param request
	 * @param response
	 */
	public void doLogin(HttpServletRequest request, HttpServletResponse 
			response){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select * from userinfo where username = ? and password = ?";
		ResultSet rs = DBUtil.query(sql, username, password);
		try{
			if(rs.next()){
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				DBUtil.releaseConnection(rs.getStatement().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

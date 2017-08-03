package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.UserInfo;
import com.util.DBUtil;

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("add".equals(method)){
			doAdd(request, response);
		}
		if("delete".equals(method)){
			doDelete(request, response);
		}
		if("update".equals(method)){
			doUpdate(request, response);
		}
		if("show".equals(method)){
			doShow(request, response);
		}
	
	}
	
	public void doShow(HttpServletRequest request, HttpServletResponse 
			response){
		String sql = "select username,password from userinfo";
		
		List<Object> list = DBUtil.query(UserInfo.class, sql);
		
		//由于我们将会使用转发，对于服务器内部传参，我们使用如下方法
		request.setAttribute("list", list);
		
		try {
			request.getRequestDispatcher("show.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(HttpServletRequest request, HttpServletResponse 
			reponse){
		
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse 
			response){
		
		String username = request.getParameter("username");
		String sql = "delete from userinfo where username = ?";
		int n = DBUtil.update(sql, username);
		if(n > 0){
			try {
				//如果这里重定向到show.jsp,将会发送一个新的请求，将不会传递List参数，所以会报出NullPointerException
				//response.sendRedirect("show.jsp");
				
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse 
			response){
	
//		String username = request.getParameter("username");
//		String sql = "update "
	}
	
	
	
}

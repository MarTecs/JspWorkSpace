package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDao;
import com.dao.UserDao;
import com.pojo.Goods;
import com.pojo.UserInfo;
import com.util.DBUtil;

public class GoodsServlet extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		if("login".equals("login"))
		{
			doLogIn(request, response);
		}
		
		if("findAll".equals(method))
		{
			doFindAll(request, response);
		}
		
		if("findById".equals(method))
		{
			doFindById(request, response);
		}
	}
	
	public void doFindAll(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException
	{
		List<Goods> list = GoodsDao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
	}
	
	public void doFindById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		Goods goods = GoodsDao.findById(id);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
	}
	
	public void doLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserInfo user = UserDao.findByUserName(username, password);
		request.setAttribute("user", user);
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
	}
}

package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDao;
import com.dao.UserDao;
import com.pojo.Goods;
import com.pojo.User;

public class AllServlet extends HttpServlet{
	
	@Override
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("login".equals(method))
		{
			doLogIn(request, response);
		}
		
		if("show".equals(method))
		{
			doShow(request, response);
		}
		
		if("showDetail".equals(method))
		{
			doShowDetail(request, response);
		}
		
		
	}
	

	public void doLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = UserDao.findByUserName(username, password);
		if(user == null)
		{
			//这里重定向到另外一个页面之后，下面的代码还会继续执行下去
			response.sendRedirect("login.jsp");
			return;
		}
		
		Cookie userName_Cookie = new Cookie("username", username);
		Cookie passWord_Cookie = new Cookie("password", password);
		userName_Cookie.setMaxAge(3600);
		passWord_Cookie.setMaxAge(3600);
		response.addCookie(userName_Cookie);
		response.addCookie(passWord_Cookie);
		
		request.setAttribute("user", user);
		doShow(request, response);
	}
	
	public void doShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("list", GoodsDao.findAll());
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}
	
	public void doShowDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String goodsid = request.getParameter("id");
		Goods goods = GoodsDao.findById(Integer.parseInt(goodsid));
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
	}
	
	
	
	

}

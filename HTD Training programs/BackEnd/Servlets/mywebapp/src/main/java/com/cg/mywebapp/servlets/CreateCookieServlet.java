package com.cg.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Create the cookie
		Cookie cookie=new Cookie("empName","Manju");
		cookie.setMaxAge(7*24*60*60);
		resp.addCookie(cookie);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("./Cookie.html");
		requestDispatcher.include(req, resp);	
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cookie created successfully....</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}

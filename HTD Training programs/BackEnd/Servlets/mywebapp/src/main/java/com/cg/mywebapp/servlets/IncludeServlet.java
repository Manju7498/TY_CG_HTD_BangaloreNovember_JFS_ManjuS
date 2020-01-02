package com.cg.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/include")
public class IncludeServlet  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String url="./currentDate";
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("<h2> Hello User<br> </h2>");
	RequestDispatcher requestDispatcher=req.getRequestDispatcher(url);
	requestDispatcher.include(req, resp);
	out.println("<h2>Thank you <br> </h2>");
	out.println("</body>");
	out.println("</html>");
	
}
}

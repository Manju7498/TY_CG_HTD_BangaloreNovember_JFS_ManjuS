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
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read the cookie
		Cookie[] cookies=req.getCookies();
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		req.getRequestDispatcher("./Cookie.html").include(req, resp);
		out.println("<html>");
		out.println("<body>");
		if(cookies!=null) {
		for (Cookie cookie : cookies) {
			out.println("<br>Cookie name= "+cookie.getName());
			out.println("<br>Cookie value= "+cookie.getValue());
		}
			}else {
				out.println("<br>Cookie not found");
			}
		out.println("</body>");
		out.println("</html>");
	}

}


package com.cg.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the query String
		String idValue=req.getParameter("id");
		//Get the context param
		ServletContext context=getServletContext();
		String contextParamVal=context.getInitParameter("myContextParam");
		//Get config parameter
		ServletConfig config=getServletConfig();
		String configParamVal=config.getInitParameter("myConfigParam");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Employee id = "+ idValue);
		out.println("Name = Manju");
		out.println(" Salary = 30000");
		//displaying context param & config values
		out.println("<br><br>Context Param Value = "+contextParamVal);
		out.println("<br><br>Config Param Value = "+configParamVal);
		

		out.println("</body>");
		out.println("</html>");
	}//end of doget

}//end of class

package com.cg.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dateservlet extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	 //Current date and time
	Date date=new Date();	
	//Get the context param
	ServletContext context=getServletContext();
	//ServletContext context=req.getServletContext();    same as line 20
	String contextParamVal=context.getInitParameter("myContextParam");
	//Get config parameter
	ServletConfig config=getServletConfig();
	String configParamVal=config.getInitParameter("myConfigParam");
	 resp.setContentType("text/html");
	 resp.setHeader("refresh","1");
	PrintWriter out=resp.getWriter();
	out.print("<html>");
	out.print("<h2>Current System Date & Time - <br>"+ date + "</h2>");
	//displaying context param & config values
	out.println("<br><br>Context Param Value = "+contextParamVal);
	out.println("<br><br>Config Param Value = "+configParamVal);
	
	out.print("</html>");
}//end of doget

}//end of class

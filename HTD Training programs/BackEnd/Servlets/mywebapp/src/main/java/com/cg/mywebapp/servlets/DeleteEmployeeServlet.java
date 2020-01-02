package com.cg.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mywebapp.service.EmployeeService;
import com.cg.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeService Service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(session!=null) {
			//Valid Session
			int empId=Integer.parseInt(req.getParameter("empId"));
			if(Service.deleteEmployee(empId)) {
				out.println("<h3 style='color: blue'> Employee Record for "+empId+" deleted</h3>");
			} else {
				out.println("<h3 style='color: blue'> Employee Record for "+empId+" not found </h3>");		
			}
			req.getRequestDispatcher("./DeleteEmployee.html").include(req, resp);
		}else {
			//Invalid Session
			out.println("<h3 style='color:orange'>Please Login First</h3>");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");
	}

}

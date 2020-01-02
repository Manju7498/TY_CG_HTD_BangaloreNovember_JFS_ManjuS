package com.cg.mywebapp.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mywebapp.beans.EmployeeInfoBean;
import com.cg.mywebapp.service.EmployeeService;
import com.cg.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/searchEmployee2")
public class SearchEmployeeServlet2 extends HttpServlet {
	private EmployeeService employeeService=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(session!=null) {
			//Valid session
			//Get the form data
			String empIdval=req.getParameter("empId");
			int empId=Integer.parseInt(empIdval);
			EmployeeInfoBean employeeInfoBean=employeeService.searchEmployee(empId);
			if(employeeInfoBean!=null) {
				out.println("<h3>Employee Id : "+empId+" found<h3>");
				out.println("Name : "+employeeInfoBean.getEname());
				out.println("<br>Age : "+employeeInfoBean.getAge());
				out.println("<br>Salary : "+employeeInfoBean.getSalary());
				out.println("<br>Designation : "+employeeInfoBean.getDesignation());
				out.println("<br>Password : "+employeeInfoBean.getPassword());
			} else {
				out.println("<h3 style='color:red'>Employee Id "+empId+" not found </h3>");
			}
		}else {
			//Invalid session
			out.println("<h3 style='color:orange'>Please Login First</h3>");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);

		}
		out.println("</body>");
		out.println("</html>");

	}//end of doGet()
}//end of class

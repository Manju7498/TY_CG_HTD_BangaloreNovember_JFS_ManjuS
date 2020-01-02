package com.cg.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mywebapp.beans.EmployeeInfoBean;
import com.cg.mywebapp.service.EmployeeService;
import com.cg.mywebapp.service.EmployeeServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeeService Service = new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the form data
		String empIdVal = req.getParameter("empId");
		String password = req.getParameter("password");
		int empId = Integer.parseInt(empIdVal);
		EmployeeInfoBean employeeInfoBean = Service.authenticate(empId, password);
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (employeeInfoBean != null) {
			// valid credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			out.println("<h2 style='color:blue'>Welcome " + employeeInfoBean.getEname() + "</h2>");
			out.println("<br><a href='./AddEmployee.html'>Add Employee</a>");
			out.println("<br><a href='#'>Update Employee</a>");
			out.println("<br><a href='./searchEmployee.html'>Search Employee</a>");
			out.println("<br><a href='./DeleteEmployee.html'>Delete Employee</a>");
			out.println("<br><a href='#'>See All Employee</a>");
			out.println("<br><br><br><a href='./logout'>Log Out</a>");
		} else {
			// invalid credentials
			out.println("<h3 style='color:red'> Invalid Credentials</h3>");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");
	}// end of doPost()
}// end of servlet class

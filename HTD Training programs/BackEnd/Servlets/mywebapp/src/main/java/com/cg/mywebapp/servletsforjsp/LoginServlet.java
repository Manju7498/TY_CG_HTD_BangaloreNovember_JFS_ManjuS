package com.cg.mywebapp.servletsforjsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mywebapp.beans.EmployeeInfoBean;
import com.cg.mywebapp.service.EmployeeService;
import com.cg.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/login2")
public class LoginServlet extends HttpServlet  {
	private EmployeeService Service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId=Integer.parseInt(req.getParameter("empId"));
		String password=req.getParameter("password");
		EmployeeInfoBean employeeInfoBean=Service.authenticate(empId, password);
		if(employeeInfoBean!=null) {
			//valid credentials
			HttpSession session=req.getSession(true);
			session.setAttribute("employeeInfoBean",employeeInfoBean);
			session.setMaxInactiveInterval(60);
			req.getRequestDispatcher("./homePageJsp.jsp").forward(req, resp);
			
			
		}else {
			//Invalid credentials
			req.setAttribute("msg","Invalid Credentials");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}
}//end of class

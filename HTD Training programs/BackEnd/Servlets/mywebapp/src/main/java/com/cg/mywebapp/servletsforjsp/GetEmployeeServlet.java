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
@WebServlet("/searchEmployee3")
public class GetEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//valid session
			//Get the form data
			int empId=Integer.parseInt(req.getParameter("empId"));
			EmployeeInfoBean employeeInfoBean=service.searchEmployee(empId);
			req.setAttribute("employeeInfoBean",employeeInfoBean);
			req.getRequestDispatcher("./SearchEmployeeJspForm.jsp").forward(req, resp);
		}else {
			//Invalid session
			req.setAttribute("msg","Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}

}

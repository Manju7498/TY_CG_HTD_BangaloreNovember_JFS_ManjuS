package com.cg.mywebapp.servletsforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mywebapp.service.EmployeeService;
import com.cg.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/deleteEmployee2")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//valid session
			//Get the form 
			int empId=Integer.parseInt(req.getParameter("empId"));
			boolean isDeleted=service.deleteEmployee(empId);
			if(isDeleted) {
				req.setAttribute("msg","Employee "+empId+" deleted");
			}else {
				req.setAttribute("msg","Employee "+empId+" not deleted");
			}
			req.getRequestDispatcher("./deleteEmployeeJspForm.jsp").forward(req, resp);
			
		}else {
			//invalid session
			req.setAttribute("msg","Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
			
		}
		
	}

}

package com.cg.mywebapp.servletsforjsp;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.mywebapp.beans.EmployeeInfoBean;
import com.cg.mywebapp.service.EmployeeService;
import com.cg.mywebapp.service.EmployeeServiceImpl;
@WebServlet("/seeAllEmployees")
public class SeeAllEmployeesServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//valid session
			List<EmployeeInfoBean> employeelist=service.getAllEmployees();
			if(employeelist!=null && !employeelist.isEmpty()) {
				req.setAttribute("employeelist",employeelist);
			}else {
				req.setAttribute("msg","There is no employee record to display");
			}
			req.getRequestDispatcher("./seeAllEmployeesJsp.jsp").forward(req, resp);
		}else {
			//Invalid session
			req.setAttribute("msg","Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}
}

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
@WebServlet("/addEmployee1")
public class AddEmployeeServlet extends HttpServlet {
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
	      if(session!=null) {
	    	  //Valid Session
	    	  //Get the form data
	    	  int empId=Integer.parseInt(req.getParameter("empId"));
	    	  String name=req.getParameter("ename");
	    	  double salary=Double.parseDouble(req.getParameter("salary"));
	    	  int age=Integer.parseInt(req.getParameter("age"));
	    	  String designation=req.getParameter("designation");
	    	  String password=req.getParameter("password");
	    	  EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
	    	  employeeInfoBean.setEmpId(empId);
	    	  employeeInfoBean.setEname(name);
	    	  employeeInfoBean.setSalary(salary);
	    	  employeeInfoBean.setAge(age);
	    	  employeeInfoBean.setDesignation(designation);
	    	  employeeInfoBean.setPassword(password);
	    	  boolean isAdded=service.addEmployee(employeeInfoBean);
	    	  if(isAdded) {
	    		  req.setAttribute("msg","Employee "+empId+" added");
	    	  } else {
	    		  req.setAttribute("msg","Employee "+empId+" not added"); 
	    	  }
	    	  req.getRequestDispatcher("./addEmployeeJspForm.jsp").forward(req, resp);
	}else {
		//Invalid session
		req.setAttribute("msg","Please Login First");
		req.getRequestDispatcher("./loginForm").forward(req, resp);
	}
	}
}

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

@WebServlet("/updateEmployee1")
public class UpdateEmployeeServlet extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			//valid session
			//Get the form data
			int empId=Integer.parseInt(req.getParameter("empId"));
	    	  String name=req.getParameter("ename");
	    	  String salary=req.getParameter("salary");
	    	  String age=req.getParameter("age");
	    	  String designation=req.getParameter("designation");
	    	  String password=req.getParameter("password");
	    	  EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
	    	  employeeInfoBean.setEmpId(empId);
	    	  employeeInfoBean.setEname(name);
	    	  if(age!=null && !age.isEmpty()) {
	    		  int age1=Integer.parseInt(age);
	    		  employeeInfoBean.setAge(age1);
	    	  }
	    	  if(salary!=null && !salary.isEmpty()) {
	    		  double sal1=Double.parseDouble(salary);
	    		  employeeInfoBean.setSalary(sal1);
	    	  }
	    	  employeeInfoBean.setDesignation(designation);
	    	  employeeInfoBean.setPassword(password);
	    	  boolean isAdded=service.updateEmployee(employeeInfoBean);
	    	  if(isAdded) {
	    		  req.setAttribute("msg","Employee "+empId+" updated");
	    	  } else {
	    		  req.setAttribute("msg","Employee "+empId+" not updated"); 
	    	  }
	    	  req.getRequestDispatcher("./updateEmployeeJspForm.jsp").forward(req, resp);
	}else {
		//Invalid session
		req.setAttribute("msg","Please Login First");
		req.getRequestDispatcher("./loginForm").forward(req, resp);
	}
	}

}

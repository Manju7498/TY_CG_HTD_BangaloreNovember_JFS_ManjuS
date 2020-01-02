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
@WebServlet("/addEmployee")
public class AddEmployeeServlet  extends HttpServlet{
	private EmployeeService service=new EmployeeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session=req.getSession(false);
      PrintWriter out=resp.getWriter();
      out.println("<html>");
      out.println("<body>");
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
    		  out.println("<h3 style='color:orange'>Employee Added Successfully</h3>");
    	  }else {
    		  out.println("<h3 style='color:orange'>Unable to add Employee </h3>"); 
    	  }
      }else {
    	  //Invalid session
    	  out.println("<h3 style='color:orange'>Please Login First</h3>");
			req.getRequestDispatcher("./LoginPage.html").include(req, resp);
      }
         out.println("</html>");
         out.println("</body>");
    }//end of doPost
}//end of class

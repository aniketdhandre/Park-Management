package com.parkmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	         response.setContentType("text/html");
	     
	         PrintWriter pw=response.getWriter();
	         
	         String user=request.getParameter("username");
	         String pwd=request.getParameter("pwd");
	         
	         
	     if(logindao.validate(user, pwd)) {
	    	 RequestDispatcher rd=request.getRequestDispatcher("dashboard.html");
	    	 rd.forward(request, response);
	     }else {
	    	 pw.print("Sorry! username or password wrong");
	    	 RequestDispatcher rd=request.getRequestDispatcher("login.html");
	    	 rd.include(request, response);
	     }
	         
	         
	
	}

}

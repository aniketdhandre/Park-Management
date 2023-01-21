package com.parkmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createroutinecontroller
 */
@WebServlet("/createroutinecontroller")
public class createroutinecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createroutinecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html");
		   
		   PrintWriter pw=response.getWriter();
		   
		   
               String empname=request.getParameter("empname");		   
		       String date=request.getParameter("date");
		       String time=request.getParameter("time");
		       String work=request.getParameter("work");
	     	     
		       PreparedStatement ps=null;
			      Connection con=null;
		       
		       try {
					
					  Class.forName("com.mysql.jdbc.Driver");			  
					  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkmanagement","root","Aniket@1234");
					  String query="insert into routine(emp_name,date,time,work) values(?,?,?,?)";
					  ps=con.prepareStatement(query);
					  ps.setString(1, empname);
					  ps.setString(2, date);
					  ps.setString(3, time);
					  ps.setString(4, work);
					  
					  ps.executeUpdate();
			
					  
					  response.sendRedirect("dashboard.html");
					  
				} catch (Exception e) {
					
					System.out.println(e);
					
				}  finally {
					  try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
				}         
		
		
	}

}

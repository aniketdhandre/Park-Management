package com.parkmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddStaffController
 */
@WebServlet("/AddStaffController")
public class AddStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		      response.setContentType("text/html");
		      
		      PrintWriter pw=response.getWriter();		      
		      String name=request.getParameter("name");
		      String email=request.getParameter("email");
		      String pwd=request.getParameter("password");
		      String phone=request.getParameter("phone");   
		      
		      PreparedStatement ps=null;
		      Connection con=null;
		      
		    
		  try {
			
			  Class.forName("com.mysql.jdbc.Driver");			  
			  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkmanagement","root","Aniket@1234");
			  String query="insert into addstaff(name,email,password,phone) values(?,?,?,?)";
			  ps=con.prepareStatement(query);
			  ps.setString(1, name);
			  ps.setString(2, email);
			  ps.setString(3, pwd);
			  ps.setString(4, phone);
			  
			  ps.executeUpdate();
			  
			  pw.print("You have been successfully added");
			  
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

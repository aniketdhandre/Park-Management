package com.parkmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewStaff
 */
@WebServlet("/ViewStaff")
public class ViewStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();
		    
		    
		    try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkmanagement","root","Aniket@1234");  
				      
				PreparedStatement ps=con.prepareStatement("select * from addstaff"); 
				      
				ResultSet rs=ps.executeQuery();  
				pw.print("<table border='1' width='100%'");  
		        pw.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Phone</th></tr>");
			     
				while(rs.next()) {
					pw.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
				}
				
				
				          
				}catch(Exception e){System.out.println(e);}
		    
		    
		          pw.print("<a href='dashboard.html'><button type='button'> Back </button></a><br><br><br>");
				}     
		    
		    
		
	}



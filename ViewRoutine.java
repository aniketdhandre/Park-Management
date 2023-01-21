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
 * Servlet implementation class ViewRoutine
 */
@WebServlet("/ViewRoutine")
public class ViewRoutine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRoutine() {
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
			      
			PreparedStatement ps=con.prepareStatement("select * from routine"); 
			      
			ResultSet rs=ps.executeQuery();  
			pw.print("<table border='1' width='100%'");  
	        pw.print("<tr><th>Employee Name</th><th>Date</th><th>Time</th><th>Work</th></tr>");
		     
			while(rs.next()) {
				pw.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
			
			
			          
			}catch(Exception e){System.out.println(e);}  
			     
	           
	          pw.print("<a href='dashboard.html'><button type='button'> Back </button></a><br><br><br>");
	    
			}     		
		     
	      
		
	}



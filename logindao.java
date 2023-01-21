package com.parkmanagement.controller;

import java.sql.*;
import java.sql.DriverManager;

public class logindao {

	public static boolean validate(String name,String pass){  
		
		boolean status=false;  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkmanagement","root","Aniket@1234");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from login where username=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
}

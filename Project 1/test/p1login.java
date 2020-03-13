package com.revature.test;

import java.io.*;  
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.domain.User;  


public class p1login extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String username1 = "postgres";
	private static String password1 = "Vietnam94!";
	
	
	
	
	 @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {  
		  response.setStatus(HttpServletResponse.SC_NO_CONTENT);
          PrintWriter out = response.getWriter();  
          
          
          String username = request.getParameter("username");  
          String password = request.getParameter("password");
          
          
          if (request.getParameter("Second") != null) {
          try
          {  
               //load the driver
        	   Class.forName("org.postgresql.Driver"); 
               //create connection object
               Connection con=DriverManager.getConnection(url,username1,password1);  
               // create the prepared statement object
               PreparedStatement ps=con.prepareStatement
            		   ("insert into account(username, password, roleid, year_fund) values(?,?,?,?)");  
  
               ps.setString(1, username);
               ps.setString(2, password);
               ps.setInt(3, 4);
               ps.setInt(4, 0);
               
  
               ps.executeUpdate(); 
  
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }  
          out.close();  
     } else if (request.getParameter("First") != null) {
    	 Account user = null;
    	 try
         {  
              //load the driver
       	   	  Class.forName("org.postgresql.Driver"); 
              //create connection object
              Connection con=DriverManager.getConnection(url,username1,password1);
              PreparedStatement ps=con.prepareStatement("select * from account where username = ?");
              
              ps.setString(1, username);
              ResultSet rs = ps.executeQuery();
  				if (rs.next()) {
  				user = new Account();
  				user.setEmpid(rs.getInt(1));
  				user.setUsername(rs.getString(2));
  				user.setPassword(rs.getString(3));
  				user.setRoleid(rs.getInt(4));
  				user.setYear_fund(rs.getInt(5));
  				
  				}
         }
  				catch (SQLException | ClassNotFoundException ex) {
               ex.printStackTrace();
          }
    	 
    	 
    	 if (user != null && user.getPassword().equals(password)) {
    		 
    		 HttpSession sess = request.getSession(true);
    		 
    		 
    		 sess.setAttribute("user", user);
    		
    		 
    		 if(user.getRoleid() == 4) {
    		
 			 response.sendRedirect("http://localhost:8080/CarDealership/pages/welcome.html");
    			
    		 } else {
 			response.sendRedirect("http://localhost:8080/CarDealership/pages/manager.html");
 		}
    	 }
    		 else {
    	 			response.sendRedirect("http://localhost:8080/CarDealership/pages/p1login.html");
     }
     }
     }
}

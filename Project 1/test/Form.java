package com.revature.test;

import java.io.*;  
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.domain.User;  


public class Form extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String username = "postgres";
	private static String password = "Vietnam94!";
	
	
	
	
	 @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {  
		 

          //String link = "http://localhost:8080/CarDealership/pages/welcome.html";
		 
		  HttpSession sess=request.getSession(false);
		  
		  Account emp = (Account) sess.getAttribute("user");
		  
		  int empid = emp.getEmpid();
	
      
          String name = request.getParameter("name");  
          String address = request.getParameter("address");  
          String phone = request.getParameter("phone");
          String type = request.getParameter("type");
          String description = request.getParameter("description");
          String location = request.getParameter("location");
          String date = request.getParameter("date");
          double cost = Double.parseDouble(request.getParameter("cost"));
          String grading_format = request.getParameter("grading_format");
          
        
          
          double amount = 0;
         
          if(type.equals("University Courses")) {
        	  amount = cost * 0.8;
        	  
          } else if(type.equals("Seminars")) {
        	  amount = cost * 0.6;
          } else if(type.equals("Certificate Prep Class")) {
        	  amount = cost * 0.75;
          } else if(type.equals("Certification")){
        	  amount = cost;
          } else if(type.equals("Technical Training")) {
        	  amount = cost * 0.9;
          } else if(type.equals("Other")) {
        	  amount = cost * 0.3;
          }
          
          
     
          
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          
          LocalDate today = LocalDate.now();
          
          String startnum  = date.replaceAll("[^0-9]", "");
          String submitnum = formatter.format(today).replaceAll("[^0-9]", "");
          
          int startnum2 = Integer.parseInt(startnum);
          int submitnum2 = Integer.parseInt(submitnum);
          
          String urgency;
          if((startnum2 - submitnum2) <= 14) {
        	  urgency = "Urgent!";
          } else {
        	  urgency = "Not urgent";
          }
           
          
       
          try
          {  
               //load the driver
        	   Class.forName("org.postgresql.Driver"); 
               //create connection object
               Connection con=DriverManager.getConnection(url,username,password);  
               // create the prepared statement object
               PreparedStatement ps=con.prepareStatement
            		   ("insert into form(empid, name, address, phone, type, description,"
            		   		+ "location, submit_date, start_date, is_urgent, cost, reimbursement_amount, grading_format, "
            		   		+ "ds_approved, dh_approved, bc_approved, awarded)"
            		   		+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
               ps.setInt(1, empid);
               ps.setString(2,name);  
               ps.setString(3,address);  
               ps.setString(4,phone);  
               ps.setString(5, type);
               ps.setString(6,description);  
               ps.setString(7,location);
               ps.setString(8, formatter.format(today));
               ps.setString(9,date);
               ps.setString(10, urgency);
               ps.setDouble(11, cost);
               ps.setDouble(12, amount);
               ps.setString(13, grading_format);
               ps.setString(14, "pending");
               ps.setString(15, "pending");
               ps.setString(16, "pending");	 
               ps.setInt(17, 0);

               
  
               int i = ps.executeUpdate();
             
               if(i>0){
               response.sendRedirect("http://localhost:8080/CarDealership/pages/welcome.html"); 
               } 
  
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }  
 
     }  
}
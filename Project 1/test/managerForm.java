package com.revature.test;

import java.io.*;  
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.domain.User;  


public class managerForm extends HttpServlet{
	
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
		 
		 
		  HttpSession sess=request.getSession(false);
		  
		  Account emp = (Account) sess.getAttribute("user");
		  
		  int whichone = emp.getRoleid();
		  String column = null;
		  
		  if(whichone == 1) {
			  column = "ds_approved";
		  } else if (whichone == 2) {
			  column = "dh_approved";
		  } else if (whichone == 3) {
			  column = "bc_approved";
		  }
		  
		  String decision = request.getParameter("decision"); 
		  int formid = Integer.parseInt(request.getParameter("formid2"));


          
          try
          {  
               //load the driver
        	   Class.forName("org.postgresql.Driver"); 
               //create connection object
               Connection con=DriverManager.getConnection(url,username,password);  
               // create the prepared statement object
               PreparedStatement ps=con.prepareStatement
            		   ("update form set " + column + " = ? where formid = ?"); 
               ps.setString(1, decision);
               ps.setInt(2, formid);

               int i = ps.executeUpdate();
               
        
              
         
               PreparedStatement zz=con.prepareStatement
            		   ("update form set awarded = reimbursement_amount "
            		   		+ "where form.ds_approved = 'Accept' and form.dh_approved = 'Accept' "
            		   		+ "and form.bc_approved = 'Accept' and formid = ? ");
               zz.setInt(1, formid);
               int y = zz.executeUpdate();
               
               PreparedStatement xx=con.prepareStatement
            		   ("update account set year_fund = account.year_fund + awarded "
            		   		+ "from form where account.empid = form.empid and formid = ?");
               
               if (y > 0) {
               
             
               xx.setInt(1, formid);
               xx.executeUpdate();
               }
               

             
               if (i > 0) {
               response.sendRedirect("http://localhost:8080/CarDealership/pages/manager.html"); 

  
               } }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }  
 
     }}
          

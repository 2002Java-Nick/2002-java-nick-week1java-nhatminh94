package com.revature.test;

import java.io.*;  
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.GsonBuilder;
import com.revature.domain.Car;
import com.revature.domain.User;  

public class accountView extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String username1 = "postgres";
	private static String password1 = "Vietnam94!";
	
public List<Account> retrieveAllForms(int x) throws ClassNotFoundException {
		
		List<Account> accList = new ArrayList<Account>();
		
		
		
		try {

		 Class.forName("org.postgresql.Driver"); 
         //create connection object
         Connection con=DriverManager.getConnection(url,username1,password1);  
         // create the prepared statement object
         PreparedStatement ps=con.prepareStatement("select * from account where empid = ?");
         
         ps.setInt(1, x);
         ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accList.add(
						new Account
						(
						rs.getInt("empid"), 
						rs.getString("username"), 
						rs.getString("password"), 
						rs.getInt("roleid"), 
						rs.getDouble("year_fund")));
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accList;
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {  
		
		HttpSession sess=request.getSession(false);
		Account emp = (Account) sess.getAttribute("user");
		  
		int empid = emp.getEmpid();
		
		

			  try {
					List<Account> accList = retrieveAllForms(empid);
					String accListJSON = new GsonBuilder().create().toJson(accList);
					PrintWriter pw = response.getWriter();
					pw.write(accListJSON);
						
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    }


}

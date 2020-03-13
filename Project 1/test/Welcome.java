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

public class Welcome extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String username1 = "postgres";
	private static String password1 = "Vietnam94!";
	
public List<trmsForms> retrieveAllForms(int x) throws ClassNotFoundException {
		
		List<trmsForms> formList = new ArrayList<trmsForms>();
		
		
		
		try {

		 Class.forName("org.postgresql.Driver"); 
         //create connection object
         Connection con=DriverManager.getConnection(url,username1,password1);  
         // create the prepared statement object
         PreparedStatement ps=con.prepareStatement("select * from form where empid = ?");
         
         ps.setInt(1, x);
         ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				formList.add(
						new trmsForms
						(
						rs.getInt("formid"), 
						rs.getInt("empid"), 
						rs.getString("name"), 
						rs.getString("address"), 
						rs.getString("phone"), 
						rs.getString("type"), 
						rs.getString("description"), 
						rs.getString("location"), 
						rs.getString("submit_date"), 
						rs.getString("start_date"), 
						rs.getString("is_urgent"), 
						rs.getDouble("cost"), 
						rs.getDouble("reimbursement_amount"), 
						rs.getString("grading_format"), 
						rs.getString("ds_approved"), 
						rs.getString("dh_approved"), 
						rs.getString("bc_approved"),
						rs.getDouble("awarded")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formList;
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {  
		
		HttpSession sess=request.getSession(false);
		Account emp = (Account) sess.getAttribute("user");
		  
		int empid = emp.getEmpid();
		
		

			  try {
					List<trmsForms> formList = retrieveAllForms(empid);
					String formListJSON = new GsonBuilder().create().toJson(formList);
					PrintWriter pw = response.getWriter();
					pw.write(formListJSON);
						
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    }


}

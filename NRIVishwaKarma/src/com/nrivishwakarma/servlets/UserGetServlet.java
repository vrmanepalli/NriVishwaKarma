package com.nrivishwakarma.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;




import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nrivishwakarma.databaseclasses.DBProfileUser;
import com.nrivishwakarma.utilities.UserProfile;

public class UserGetServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in UserGetServlet");
		response.setContentType("text/html");
		
		//Takes Json String from Request.
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String str;
		PrintWriter out=response.getWriter();
		
		while ((str = reader.readLine()) != null) {
			
				sb.append(str);
		}
	//below line is imp coz everything is in sb (stringbuffer)so I will convert the buffer to string and assign to value
		str=sb.toString();
		String email = new Gson().fromJson(sb.toString(),String.class);
		DBProfileUser dbu = new DBProfileUser();
		UserProfile user = new UserProfile();
		try {
			user = dbu.getUser(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("system cant get the user");
			e.printStackTrace();
		}
		//Taking hard code date for example
		 String dob = user.bdate;
		    System.out.println("dob="+dob);
		    
		    //divide date to year,month,day
		    int yearDOB = Integer.parseInt(dob.substring(0, 4));
		    int monthDOB = Integer.parseInt(dob.substring(5, 7));
		    int dayDOB = Integer.parseInt(dob.substring(8, 10));
		    
		    user.setByear((String)(""+yearDOB));
		    user.setBmonth((String)(""+monthDOB));
		    user.setBday((String)(""+dayDOB));
		    System.out.println("year="+user.getByear()+" month="+user.getBmonth()+" date="+user.getBday());
		    
		  //individual variable for year-month-date
		    DateFormat dateFormat = new SimpleDateFormat("yyyy");
		    java.util.Date date = new java.util.Date();
		    int thisYear = Integer.parseInt(dateFormat.format(date));

		    dateFormat = new SimpleDateFormat("MM");
		    date = new java.util.Date();
		    int thisMonth = Integer.parseInt(dateFormat.format(date));

		    dateFormat = new SimpleDateFormat("dd");
		    date = new java.util.Date();
		    int thisDay = Integer.parseInt(dateFormat.format(date));

		    //current year minus birth year
		    int age = thisYear - yearDOB;

		    if(thisMonth < monthDOB){
		    age = age - 1;
		    }

		    if(thisMonth == monthDOB && thisDay < dayDOB){
		    age = age - 1;
		    }
		user.setAge((String)(""+age));

		Gson gson = new Gson();
		String json=gson.toJson(user);
		System.out.println("User json: "+json);
			out.print(json);
	}//closing for post

}

package com.nrivishwakarma.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nrivishwakarma.databaseclasses.DBProfileUser;
import com.nrivishwakarma.utilities.UserProfile;

public class UserUpdateServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in UserUpdateServlet");
		response.setContentType("text/html");
		boolean status = false;
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
		UserProfile details = new Gson().fromJson(sb.toString(),UserProfile.class);
		System.out.println("User for update in servlet-->"+details);
		DBProfileUser dbp = new DBProfileUser();
		try {
			dbp.updateUser(details);
			status=true;
		}
		catch (Exception E) {
			System.out.println("The error is=" + E.getMessage());
			E.printStackTrace();
		}
		 Gson gson = new Gson();
			String json=gson.toJson(status);
			out.print(json);
			
		//sending the data back to controller to take desire action
	}//closing for post
}


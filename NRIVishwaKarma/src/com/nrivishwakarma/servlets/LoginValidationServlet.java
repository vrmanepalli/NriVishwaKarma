package com.nrivishwakarma.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nrivishwakarma.databaseclasses.DBConnection;
import com.nrivishwakarma.utilities.UserDetails;
import com.nrivishwakarma.databaseclasses.DataBaseRegister;


public class LoginValidationServlet extends HttpServlet {
	
	public void init() throws ServletException
	 {
	 }

	 public void doPost(HttpServletRequest request,
           	HttpServletResponse response)
           	throws ServletException, IOException
    {
		 
		 String returnValue = "";
		 System.out.println("in LoginValidationServlet");
			boolean status = false;
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = request.getReader();
			String str;
			while ((str=reader.readLine())!=null){
				sb.append(str);
			}
			System.out.println("Email and password"+sb.toString());
			UserDetails ud = new Gson().fromJson(sb.toString(), UserDetails.class);
			System.out.print("data from the front end"+ud.email);
			System.out.println("data from the back end"+ud.password);
			try {
				DataBaseRegister dbr = new DataBaseRegister();
				returnValue = dbr.validLogin(ud.email,ud.password);
				status=true;
			} catch (Exception e) {
				status=false;
				e.printStackTrace();System.out.println("can't update user data");
			}
			PrintWriter out = new PrintWriter(response.getWriter());
			 
			out.println(returnValue);

    }



}

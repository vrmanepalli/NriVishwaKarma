package com.nrivishwakarma.servlets;

import com.nrivishwakarma.databaseclasses.DBConnection;
import com.nrivishwakarma.utilities.UserDetails;
import com.nrivishwakarma.databaseclasses.DataBaseRegister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class RegistrationServlet extends HttpServlet {
	public void init() throws ServletException
	 {
	 }

	 public void doPost(HttpServletRequest request,
            	HttpServletResponse response)
            	throws ServletException, IOException
     {
		 
		 
		 System.out.println("in UpdateUserServlet");
			boolean status = false;
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = request.getReader();
			String str;
			while ((str=reader.readLine())!=null){
				sb.append(str);
			}
			UserDetails ud = new Gson().fromJson(sb.toString(), UserDetails.class);
			//if((ud.fname!=null) && ((ud.fname).length() > 8 ) && (Character.isUpperCase((ud.fname).charAt(0)))){
			DataBaseRegister dbr = new DataBaseRegister();
			try {
				dbr.insertUser(ud);
				status=true;
			} catch (Exception e) {
				e.printStackTrace();System.out.println("can't update user data");
			}
		//	}
		
	 PrintWriter out = new PrintWriter(response.getWriter());
			 Gson gson = new Gson();
			 String jsonStr = gson.toJson(status);
			 out.println(jsonStr);

    }


}

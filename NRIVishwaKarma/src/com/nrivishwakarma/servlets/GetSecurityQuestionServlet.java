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


public class GetSecurityQuestionServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnValue="";
		PrintWriter out = response.getWriter();
		 System.out.println("in LoginValidationServlet");
			boolean status = false;
			BufferedReader reader = request.getReader();
			String str;
			str=reader.readLine();
			UserDetails ud = new Gson().fromJson(str, UserDetails.class);
			System.out.print("data from the front end"+ud.email);
			try {
				DataBaseRegister dbr = new DataBaseRegister();
				returnValue = dbr.getSecurityQuestion(ud.email);
				if(returnValue != "") {
					status=true;
					System.out.println("Email address found");
				} else {
					status=false;
					System.out.println("Email address not found");
				}
			} catch (Exception e) {
				status=false;
				e.printStackTrace();
			}
			System.out.println(returnValue);
			out.println("{\"status\":\"" + status + "\",\"question\":\"" + returnValue + "\"}");
	}
}

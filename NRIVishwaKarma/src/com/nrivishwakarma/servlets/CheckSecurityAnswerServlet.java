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


public class CheckSecurityAnswerServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("in checkSecurityQuestion");
		boolean status = false;
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String str;
		while ((str=reader.readLine())!=null){
			sb.append(str);
		}
		System.out.println("Email and password"+sb.toString());
		UserDetails ud = new Gson().fromJson(sb.toString(), UserDetails.class);
				System.out.print("data from the front end "+ud.email);
		try {
			DataBaseRegister dbr = new DataBaseRegister();
			status = dbr.checkSecurityQuestion(ud.email,ud.answer);
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		out.println("{\"status\":\"" + status + "\"}");

		
		//out.println("{\"status\":\"true\"}");
		
	}
}
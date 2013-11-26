package com.nrivishwakarma.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nrivishwakarma.databaseclasses.DBInterests;
import com.nrivishwakarma.utilities.Interests;

public class GetInterestServlet extends HttpServlet{
	
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in GetInterestServlet");
		response.setContentType("text/html");
		//Takes Json String from Request.
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String str;
		PrintWriter out=response.getWriter();
		while ((str = reader.readLine()) != null) {
				sb.append(str);
		}
		str=sb.toString();
		String email = new Gson().fromJson(sb.toString(),String.class);
		System.out.println("email from factory for interest: "+email);
		Interests interests = null;
		DBInterests dbi = new DBInterests();
		try {
			interests = dbi.getInterests(email);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in geting interests from DB");
		}
		Gson gson = new Gson();
		String json=gson.toJson(interests);
		System.out.println("interests class: "+interests);
			System.out.println("interests json: "+json);
			out.print(json);
	}
}
	

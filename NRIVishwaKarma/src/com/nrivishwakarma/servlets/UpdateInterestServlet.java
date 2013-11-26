package com.nrivishwakarma.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nrivishwakarma.databaseclasses.DBInterests;
import com.nrivishwakarma.databaseclasses.DBProfileUser;
import com.nrivishwakarma.utilities.Interests;
import com.nrivishwakarma.utilities.UserProfile;

public class UpdateInterestServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in UpdateInterestservlet");
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
		str=sb.toString();
		System.out.println("in servlet str="+str);
		Interests inter = new Gson().fromJson(sb.toString(),Interests.class);
		DBInterests dbi = new DBInterests();
		System.out.println("From servlet inter="+inter);
		try {
			dbi.updateInterests(inter);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("can't update interests");
		}
	}//service method
}

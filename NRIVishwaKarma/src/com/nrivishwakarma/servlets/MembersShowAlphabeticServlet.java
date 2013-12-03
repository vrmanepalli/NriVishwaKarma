package com.nrivishwakarma.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nrivishwakarma.databaseclasses.DBMembers;
import com.nrivishwakarma.utilities.MemberDetails;
import com.nrivishwakarma.utilities.SearchByDetails;

public class MembersShowAlphabeticServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<MemberDetails> ls=new ArrayList<MemberDetails>();
		System.out.println("in MembersShowServletByName");
		boolean status = false;
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String str;
		while ((str=reader.readLine())!=null){
			sb.append(str);
		}
		System.out.println("name"+sb.toString());
		SearchByDetails sd = new Gson().fromJson(sb.toString(), SearchByDetails.class);
		System.out.println("data of the name from the front end "+sd.alphabeticFilter);
		try {
			DBMembers dbm = new DBMembers();
			System.out.println("before calling the function");
			ls = dbm.memberFunctionByAlphabeticFilter(sd.alphabeticFilter);
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		
		Gson gson = new Gson();
		String json=gson.toJson(ls);
		System.out.println(json);
		out.println(json);
		
		//out.println("{\"status\":\"" + status + "\"}");

	}


}

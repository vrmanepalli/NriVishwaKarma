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
import com.nrivishwakarma.utilities.SearchByDetails;
import com.nrivishwakarma.utilities.MemberDetails;
import com.nrivishwakarma.databaseclasses.DBMembers;
import com.nrivishwakarma.databaseclasses.DataBaseRegister;

public class MembersShowServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<MemberDetails> ls=new ArrayList<MemberDetails>();
		System.out.println("in MembersShowServlet");
		boolean status = false;
		try {
			DBMembers dbm = new DBMembers();
			System.out.println("before calling the function");
			ls = dbm.memberFunctionAll();
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

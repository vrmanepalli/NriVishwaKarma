package com.nrivishwakarma.databaseclasses;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nrivishwakarma.databaseclasses.DBConnection;
import com.nrivishwakarma.utilities.MemberDetails;
import com.nrivishwakarma.utilities.*;

public class DBMembers {
	
	public List<MemberDetails> memberFunctionByName(String name) throws Exception{
		System.out.print("I am in the DBmember function");
		List<MemberDetails> ls = new ArrayList<MemberDetails>();
		Connection con = DBConnection.getInstance().getConnection();
		Statement stm = con.createStatement();
		System.out.println("I am in the DBMember"+name);
		ResultSet rs = stm.executeQuery
				("select * from users where FName = '"+name+"'");
		while(rs.next() ){
			MemberDetails md = new MemberDetails();
			md.FName=rs.getString("FName");
			System.out.println(rs.getString("FName"));
			ls.add(md);
		}
		return ls;
		
	}
	public List<MemberDetails> memberFunctionAll() throws Exception{
		System.out.print("I am in the DBmember function All");
		List<MemberDetails> ls = new ArrayList<MemberDetails>();
		Connection con = DBConnection.getInstance().getConnection();
		Statement stm = con.createStatement();
		System.out.println("I am in the DBMember");
		MemberPageCount mdc = countNoOfPagesForAll();
	
			ResultSet rs = stm.executeQuery
				("select * from users");
		
		while(rs.next() ){
		       MemberDetails md = new MemberDetails();
		       md.c=new int[mdc.b];
		       md.count=mdc.count;
		       for(int i=1;i<=mdc.b;i++)
		    	   md.c[i-1]=mdc.c[i-1];
			md.FName=rs.getString("FName");
			System.out.println(rs.getString("FName"));
			ls.add(md);
		}
		return ls;
		
	}
	
	public List<MemberDetails> memberFunctionByAlphabeticFilter(char alphabeticFilter) throws Exception{
		System.out.print("I am in the DBmember function");
		List<MemberDetails> ls = new ArrayList<MemberDetails>();
		Connection con = DBConnection.getInstance().getConnection();
		Statement stm = con.createStatement();
		System.out.println("I am in the DBMember");
		ResultSet rs = stm.executeQuery
				("select * from users where FName like '"+alphabeticFilter+"%'");
		while(rs.next() ){
			MemberDetails md = new MemberDetails();
			md.FName=rs.getString("FName");
			System.out.println(rs.getString("FName"));
			ls.add(md);
		}
		return ls;
		
	}
	
	public MemberPageCount countNoOfPagesForAll()throws Exception{
		MemberPageCount mdc=new MemberPageCount();
		Connection con = DBConnection.getInstance().getConnection();
		Statement stm = con.createStatement();
		System.out.println("I am in the DBMember Count Function");
		ResultSet rs = stm.executeQuery
				("select count(*) as count from users");
		while (rs.next()) {
			mdc.count = rs.getInt("count");
		}
		System.out.println("The total count"+mdc.count);
		 mdc.b=mdc.count/20;
		System.out.println("the value of b"+mdc.b);
		  if(mdc.b<=0){
			mdc.b=1;
			System.out.println("Inside the b");
		  }
        mdc.c=new int[mdc.b+2];
		for (int i = 1; i <=mdc.b; i++) {
			// a++;
			System.out.println("befre c[i]");
			mdc.c[i-1]= i;
			System.out.println(mdc.c[i]);
		}
		//mdc.c[mdc.count+1]=-1;
		for(int i=0;i<=mdc.b;i++)
		System.out.println("The count in out of array"+mdc.c[i]);
		return mdc;
		
	}
}

package com.nrivishwakarma.databaseclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





import com.nrivishwakarma.databaseclasses.DBConnection;
import com.nrivishwakarma.utilities.*;

public class DBProfileUser {
    
    public void updateUser (UserProfile user){
        try {
        	Connection conn = DBConnection.getInstance().getConnection();
        	System.out.println("update users set FName=?, LName=?, bday=?, gender=?, country=?,"
            		+ "state=?, city=?, country_origin=?, state_origin=?, city_origin=?, phno=?, aboutme=?, marital_status=?,"
            		+ "job=?, university=?, univ_year=?, school=?, school_year=?, degree=?, qualification=?, company=?"
            		+ "where Email='"+user.getEmail()+"'");
            PreparedStatement pstm = conn.prepareStatement("update users set FName=?, LName=?, bday=?, gender=?, country=?,"
            		+ "state=?, city=?, country_origin=?, state_origin=?, city_origin=?, phno=?, aboutme=?, marital_status=?,"
            		+ "job=?, university=?, univ_year=?, school=?, school_year=?, degree=?, qualification=?, company=?"
            		+ " where Email='"+user.getEmail()+"'");
            pstm.setString(1, user.getFname());
            pstm.setString(2, user.getLname());
            pstm.setString(3, user.getBdate());
            pstm.setString(4, user.getGender());
            pstm.setString(5, user.getCountry());
            pstm.setString(6, user.getState());
            pstm.setString(7, user.getCity());
            pstm.setString(8, user.getFromcountry());
            pstm.setString(9, user.getFromstate());
            pstm.setString(10, user.getFromcity());
            pstm.setInt(11, user.getPhone());
            pstm.setString(12, user.getAbout());
            pstm.setString(13, user.getStatus());
            pstm.setString(14, user.getJob());
            pstm.setString(15, user.getUniver());
            pstm.setString(16, user.getYearuniver());
            pstm.setString(17, user.getSchool());
            pstm.setString(18, user.getYearschool());
            pstm.setString(19, user.getDegree());
            pstm.setString(20, user.getField());
            pstm.setString(21, user.getCompany());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }            
    }//updateUser
    public void changePassword(UserProfile user) throws Exception{
    	Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement
        		("update users set pass=? where Email='"+user.getEmail()+"'");
        pstm.setString(1, user.getPassword());
        pstm.execute();
    }
    
    public UserProfile getUser (String email) throws Exception{
        Connection conn = DBConnection.getInstance().getConnection();
        Statement st =(Statement)conn.createStatement();
        UserProfile details=new UserProfile();
        try {
            String query1="select * from users where Email ='"+email+"'";
            ResultSet rs=st.executeQuery(query1);
            while(rs.next())
            {
                details.email=rs.getString("Email");
                details.fname=rs.getString("FName");
                details.lname=rs.getString("LName");
                details.bdate=rs.getString("bday");
                details.gender=rs.getString("gender");
                details.imageUrl=rs.getString("imageUrl");
                details.country=rs.getString("country");
                details.state=rs.getString("state");
                details.city=rs.getString("city");
                details.fromcountry=rs.getString("country_origin");
                details.fromstate=rs.getString("state_origin");
                details.fromcity=rs.getString("city_origin");
                details.password=rs.getString("pass");
                details.phone=rs.getInt("phno");
                details.about=rs.getString("aboutme");
                details.status=rs.getString("marital_status");
                details.job=rs.getString("job");
                details.company=rs.getString("company");
                details.univer=rs.getString("university");
                details.yearuniver =rs.getString("univ_year");
                details.school = rs.getString("school");
                details.yearschool = rs.getString("school_year");
                details.degree = rs.getString("degree");
                details.field = rs.getString("qualification");
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return details;        
}//getUser()
}

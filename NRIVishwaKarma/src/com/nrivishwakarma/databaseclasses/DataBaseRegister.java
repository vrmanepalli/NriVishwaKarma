package com.nrivishwakarma.databaseclasses;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import com.nrivishwakarma.databaseclasses.DBConnection;
	import com.nrivishwakarma.utilities.MailNotification;
	import com.nrivishwakarma.utilities.UserDetails;


	public class DataBaseRegister {
		public void insertUser (UserDetails dt){
			
			try{
				Connection con;
				PreparedStatement pstm=null;
				Statement st=null;
				con=DBConnection.getInstance().getConnection();
				System.out.println("In the Database reg\n"+dt.getFname());
				System.out.println(dt.bday);
				String str="insert into users"
					+ "(FName,LName,pass,gender,city,state,phno,country_origin,state_origin,city_origin,conf_pass,Email,country) "
					+ "values('"+dt.getFname()+"','"+dt.getLname()+"','"+dt.getPassword()+"','"+dt.getGender()+"','"+dt.getCity()+"','"+
					dt.getState()+"','"+dt.getPhone()+"','"+dt.getCountry_origin()+"','"+dt.getState_origin()+"','"+dt.getCity_origin()+"','"+
					dt.getConfirm_pass()+"','"+dt.getEmail()+"','"+dt.getCountry()+"')";
				
				//if()
			     st=con.createStatement();
			     st.executeUpdate(str);
			    
			}		
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	/*********Update the register user*********/
		
		public void updateUser(UserDetails Details)throws Exception{
			Connection con=DBConnection.getInstance().getConnection();
			String sql="update users set FName=?,LName=?,gender=?,bday=?,city=?,state=?,phno=?,country_origin=?,state_origin=?,city_origin=?,country=? " +"where email='"+Details.getEmail()+"'";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, Details.getFname());
			pstm.setString(2, Details.getLname());
			pstm.setString(4, Details.getGender());
			pstm.setString(5, Details.getBday());
			pstm.setString(6, Details.getCity());
			pstm.setString(7, Details.getState());
			pstm.setInt(8, Details.getPhone());
			pstm.setString(9, Details.getCountry_origin());
			pstm.setString(10, Details.getState_origin());
			pstm.setString(11, Details.getCity_origin());
			pstm.setString(14, Details.getCountry());
			pstm.executeUpdate();

		}
		
		/***********Update the Password********/
		public void changePass(UserDetails Details)throws Exception{
			
			Connection con=DBConnection.getInstance().getConnection();
			String sql="update users set pass=?,conf_pass=?" +"where email='"+Details.getEmail()+"' AND pass='"+Details.password+"'";
			PreparedStatement pstm=(PreparedStatement)con.prepareStatement(sql);
			pstm.setString(12, Details.getConfirm_pass());
			pstm.setString(3, Details.getPassword());
			pstm.executeUpdate();
				
		}
	/*************Login Validation***************/
		
		public String validLogin(String email, String password) throws Exception{
			boolean status = false;
			String str="";
			System.out.println("from the servlet: "+email);
			System.out.println("from the servlet: "+password);
			Connection con = DBConnection.getInstance().getConnection();
			Statement stm = con.createStatement();
	        UserDetails usr=getUser(email,password);
	        System.out.println("from the getuser method: "+usr.getEmail()+" password: "+usr.getPassword());
			System.out.println(email.equals(usr.getEmail()));
	        if(email.equals(usr.getEmail()) && password.equals(usr.getPassword())){
				System.out.println("You logged in");
				//status = true;
				 str="{\"status\":\"true\", \"message\":\"successful\"}";
				 System.out.println(str);
				//return str;
			} else {
				System.out.println("Your Email or password id is invalid ");
				str="{\"status\":\"false\",\"message\":\"Please re-enter your email and password\"}";
			}
	        return str;
		}
		
		
		public UserDetails getUser(String email,String password){
			UserDetails user = new UserDetails();
			try {
				Connection con=DBConnection.getInstance().getConnection();
				Statement stm=(Statement) con.createStatement();
				ResultSet rs = stm.executeQuery("select * from users where email = '"+ email+"' AND pass='"+password+"'");
				while(rs.next() ){
				user.setFname    (rs.getString("fname"));
				user.setLname  (rs.getString("lname"));
				user.setEmail      (rs.getString("email"));
				user.setPassword   (rs.getString("pass"));
				user.setConfirm_pass(rs.getString("Conf_pass"));
				System.out.println("from the database"+rs.getString("email"));
				System.out.println(rs.getString("pass"));
				
				}//while
				return user;
			}	
			 catch (Exception e) {
				e.printStackTrace();
			}//catch
			return user;
				
		}//metod getUser by email
		/**********Login Validation end code***********/
		
		/*********ForgotPassword*********/

		public void sendPassword(String email) throws Exception{
			ResultSet rs=null;
			String str="";
			System.out.println("in the forgot password method"+email);
			Connection con = DBConnection.getInstance().getConnection();
			Statement stm = con.createStatement();
			String sql="select pass from users where Email='"+email+"'";
			rs=stm.executeQuery(sql);
			while(rs.next()){
				str=rs.getString("pass");
			}
			System.out.println("the password that extracted from the database:"+str);
			if(str != null)
			{
				MailNotification md=new MailNotification(email," Request Password",str);
				md.run();
			}
		
		}
		
	}



package com.nrivishwakarma.databaseclasses;

	import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
					+ "(FName,LName,bday,pass,gender,city,state,phno,country_origin,state_origin,city_origin,Email,country,question,answer) "
					+ "values('"+dt.getFname()+"','"+dt.getLname()+"','"+dt.getBday()+"','"+dt.getPassword()+"','"+dt.getGender()+"','"+dt.getCity()+"','"+
					dt.getState()+"','"+dt.getPhone()+"','"+dt.getCountry_origin()+"','"+dt.getState_origin()+"','"+dt.getCity_origin()+
					"','"+dt.getEmail()+"','"+dt.getCountry()+"','"+dt.getQuestion()+"','"+dt.getAnswer()+"')";
				
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

		public boolean sendPassword(String email) throws Exception{
			ResultSet rs=null;
			boolean status;
			String str=null;
			System.out.println("in the send password method"+email);
			Connection con = DBConnection.getInstance().getConnection();
			Statement stm = con.createStatement();
			String sql="select email from users where Email='"+email+"'";
			rs=stm.executeQuery(sql);
			while(rs.next()){
				str=rs.getString("email");
			}
			System.out.println("the email that extracted from the database:"+str);
			if(str != null)
			{
				String token = create_uid(str);
				
				MailNotification md=new MailNotification(email," Request Password",str,token);
				
				return md.run();
			}
				return false;
			
		
		}
		
		
		
		public boolean reqResetPassword(String token,String password) throws Exception{
			ResultSet rs=null;
			String str="";
			System.out.println("in the req send password method"+token);
			Connection con = DBConnection.getInstance().getConnection();
			Statement stm = con.createStatement();
			String sql="select email from pass_change where "
					+ "expirary_date>=cast(current_timestamp as date) "
					+ "AND token='"+token+"'";
			rs=stm.executeQuery(sql);
			while(rs.next()){
				str=rs.getString("email");
			}
			System.out.println("the email that extracted from the database:"+str);
			if(str!=null){
				return resetPassword(str,password);
			}
			else{
				return false;
			}
		
		}
		
		
		/*********Check sequrityQuestion*********/
		
		public String getSecurityQuestion(String email) throws Exception{
			ResultSet rs=null;
			String str=null;
			Connection con = DBConnection.getInstance().getConnection();
			Statement stm = con.createStatement();
			String sql="select question from users where email='"+email+"'";
			rs=stm.executeQuery(sql);
			while(rs.next()){
				str=rs.getString("question");
			}
			System.out.println("the Question that extracted from the database:"+str);
			return str;
		}
		public boolean checkSecurityQuestion(String email,String answer) throws Exception{
			ResultSet rs=null;
			String str="";
			Connection con = DBConnection.getInstance().getConnection();
			Statement stm = con.createStatement();
			String sql="select  answer from users where email='"+email+"'";
			rs=stm.executeQuery(sql);
			while(rs.next()){
				str=rs.getString("answer");
			}
			System.out.println("the answer that extracted from the database:"+str);
			if(str.equals(answer)) {
				create_uid(email);
				return true;
			}
			return false;
		}
		
		public String create_uid(String email)throws Exception{
		
	    String str, str3;
		str3 = email;
		Connection con = DBConnection.getInstance().getConnection();
		Statement stm = con.createStatement();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date date = new Date();

		System.out.println("starting date" + dateFormat.format(date));

		Date dt = new Date();

		Calendar c = Calendar.getInstance();

		c.setTime(dt);

		c.add(Calendar.DATE, 1);

		dt = c.getTime();

		System.out.println(dt);

		System.out.println("expiration date" + dateFormat.format(dt));

		MessageDigest sha = MessageDigest.getInstance("SHA-1");

		byte[] result = sha.digest(str3.getBytes());

		System.out.println("I am the  String" + str3);

		System.out.println("Message encrypted " + hexEncode(result));

		str = hexEncode(result);
      
		System.out.println("str: " + str);
		stm = con.createStatement();

		stm.executeUpdate("insert into pass_change values('" + str3 + "','"
				+ dateFormat.format(date) + "','" + dateFormat.format(dt) + "','"
				+ str + "')");

		System.out.println("query executed");
		return str;
	}

	static private String hexEncode(byte[] aInput) {

		StringBuilder result = new StringBuilder();

		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		for (int idx = 0; idx < aInput.length; ++idx) {

			byte b = aInput[idx];

			result.append(digits[(b & 0xf0) >> 4]);

			result.append(digits[b & 0x0f]);

		}

		return result.toString();

	}
	public boolean resetPassword(String email,String resetpass) throws Exception{
		ResultSet rs=null;
		String str="";
		System.out.println("I am in the function");
		Connection con = DBConnection.getInstance().getConnection();
		Statement stm = con.createStatement();
		String sql1="delete from pass_change where email='"+email+"'";
		stm.executeUpdate(sql1);
		String sql="update users set pass='"+resetpass+"' where Email='"+email+"'";
		if(stm.getUpdateCount() > 0) {
			try {
				stm.executeUpdate(sql);
				System.out.println("executeUpdate succeeded!");
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
		
	}
	
}

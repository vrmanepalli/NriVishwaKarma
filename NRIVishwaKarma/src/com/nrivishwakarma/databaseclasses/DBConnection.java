package com.nrivishwakarma.databaseclasses;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


	public class DBConnection {
		private static Connection conn = null;
		private static DBConnection mySelf=null;
		//private static String driver = "com.mysql.jdbc.Driver";
		private static String dbName = "karma";
		private static String username = "root", password = "pass";
		
		//method for connect to DB
		public  DBConnection() throws ClassNotFoundException{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);
				System.out.println("CONNECT WITH DB");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Can't to connect to DB");
			}
		}

		public static DBConnection getInstance() throws Exception{
			if (mySelf==null){
				mySelf = new DBConnection();
			}//if
			return mySelf;
		}

		public Connection getConnection(){
			return conn;
		}
		
		//method for disconnect
		public static void disconnect() throws SQLException{
			conn.close();
		}


	}




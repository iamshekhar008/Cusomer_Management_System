package com.amdocs.cms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.amdocs.cms.crud.usr;
import com.amdocs.cms.implement.userReg;

public class appli {
public static void login() {
	Scanner sc=new Scanner(System.in);
	System.out.println("--------*********Welcome To Login portal*********----------");
	System.out.println("Enter your id:");
	int id=sc.nextInt();
	System.out.println("Enter your password");
	String pass=sc.next();
    int usid=-1;
	//exception check
	//jdbc connect
	boolean flag=true;
	 try {
   		 Class.forName("oracle.jdbc.driver.OracleDriver");
   		 String uname="system";
   		 String passwo="1234";
   		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, passwo);
   		 
   		 Statement smt=con.createStatement();
   		ResultSet res= smt.executeQuery("select u_id,pass from cms_user");
   	
   		 while(res.next()) {
   			int uid=res.getInt("u_id");
   			usid=uid;
   			 String pas=res.getString("pass");
   			System.out.println(res.getInt("u_id"));
   			 System.out.println(res.getInt("u_pass"));
   			 if(uid!=id) {
   				 System.out.println("wrong credentials!!!");
   				flag=false;
   				 break;
   			 }
   			 if(!pass.equals(pas)) {
   				 System.out.println("wrong credentials!!!");
   				 flag=false;
   				 break;
   			 }
   		 }
   		 smt.close();
   		 con.close();
   	 }
   	 catch(Exception e) {
   		 e.getMessage();
   	 }
	
	
	if(flag==true) {
		System.out.println("login successful");
		usr.userPortal(usid);
	}
	else {
		
	ip.takeip();	
	}
}
public static void register() {
	Scanner sc=new Scanner(System.in);
	System.out.println("-------******Hi Welcome To user Register*******-------");
	System.out.println("Enter your prefered id:");
	int id=sc.nextInt();
	System.out.println("Enter your name");
	String name=sc.next();
	System.out.println("Enter your preffered password");
	String pass=sc.next();
	
	userReg r=new userReg(id,name,pass);
	//db connectivity
	boolean flag=true;
	try {
  		 Class.forName("oracle.jdbc.driver.OracleDriver");
  		 String uname="system";
  		 String passwo="1234";
  		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, passwo);
  		 String query="select * from cms_user";
  		 Statement smt1=con.createStatement();
          ResultSet res=smt1.executeQuery(query);
  	
  	    
  	   
  	  while(res.next()) {
  		  
  		int uid=res.getInt("u_id");
  		if(uid==r.getUid()) {
  			flag=false;
  			System.out.println("already a user...");
  			break;
  		}
  	  }
          
  		 smt1.close();
  		con.close();	 
  	 }
  	 catch(Exception e) {
  		 e.getMessage();
  	 }
	if(flag==true) {
		try {
	  		 Class.forName("oracle.jdbc.driver.OracleDriver");
	  		 String uname="system";
	  		 String passwo="1234";
	  		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, passwo);
	  		 String query="insert into cms_user(u_id,u_name,pass,privilage) values(?,?,?,'user')";
	  		 PreparedStatement smt1=con.prepareStatement(query);
	  		 smt1.setInt(1,r.getUid());
	  		 String n=r.getUname();
	  		 smt1.setString(2,n);
	  		 String p=r.getPassword();
	  		 smt1.setString(3, p);
	          int a=smt1.executeUpdate();
	  	    System.out.println("row effected: "+a);
	  	    
	
	System.out.println("user registration done....");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	
	ip.takeip();
	
}
}

package com.amdocs.cms.crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.amdocs.cms.appli;
import com.amdocs.cms.implement.customer;


public class usr {
public static void userPortal(int uid) {
	System.out.println("Welcome to user portal for crud application");
//to change it when you do jdbc
	String privl="";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
  		 String uname="system";
  		 String pass="1234";
  		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
  		 String query="select privilage from cms_user where u_id=?";
  		 PreparedStatement ps=con.prepareStatement(query);
  		 ps.setInt(1, uid);
  		 ResultSet res=ps.executeQuery();
  		 res.next();
  		 privl=res.getString("privilage");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}

	switch(privl) {
	case "Admin" : System.out.println("Select operations to perform");
	                System.out.println("1.View 2.insert 3.delete 4.set privilages 5.Logout");
	                usr.inputt(uid);
	case "user": System.out.println("Select operation to perform");
	              System.out.println("1.View 2.insert 3.Exit");
	              usr.inputu(uid);
	}
}
public static void inputt(int uid) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	switch(n) {
	case 1:view(uid);
	       break;
	case 2:insert(uid);
	       break;
	case 3:delete(uid);
	       break;
	case 4:setpriv(uid);  
	       break;
	case 5:ip.takeip();
	       break;
	default: System.out.println("wrong input!!");       
	}
}
public static void inputu(int uid) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	switch(n) {
	case 1:view(uid);
	       break;
	case 2:insert(uid);
	       break;
	case 3:ip.takeip();
	       break;
	default:System.out.println("wrong input");       
	}
}
public static void view(int uid) {
    //jdbc call
	 try {
   		 Class.forName("oracle.jdbc.driver.OracleDriver");
   		 String uname="system";
   		 String pass="1234";
   		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
   		 String query="select * from customer";
  		 Statement smt=con.createStatement();
          ResultSet res=smt.executeQuery(query);
          
          System.out.println("Customer_ID Customer_Name Address Contact Product");
          
          while(res.next()) {
        	  System.out.println(res.getInt("c_id")+" "+res.getString("c_name")+" "+res.getString("address")+" "+res.getString("contact")+" "+res.getInt("pid"));
          }
   		 //Statement smt=con.createStatement();
   		 //smt.executeUpdate("create table emp(d number,ss varchar(20))");
   		 smt.close();
   		 con.close();
   	 }
   	 catch(Exception e) {
   		 e.getMessage();
   	 }
	 usr.userPortal(uid);
}
public static void insert(int uid) {
	//jdbc call
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter cust id:");
	int id=sc.nextInt();
	System.out.println("Enter cust name");
	String name=sc.next();
	System.out.println("Enter cust address");
	String address=sc.next();
	System.out.println("Enter cust contact");
	String co=sc.next();
	System.out.println("Enter cust pid");
	int pid=sc.nextInt();
	customer r=new customer(id,name,address,co,pid);
	try {
 		 Class.forName("oracle.jdbc.driver.OracleDriver");
 		 String uname="system";
 		 String passwo="1234";
 		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, passwo);
 		 String query="insert into customer(c_id,c_name,address,contact,pid) values(?,?,?,?,?)";
 		 PreparedStatement smt1=con.prepareStatement(query);
 		 smt1.setInt(1,r.getCid());
 		 String n=r.getCname();
 		 smt1.setString(2,n);
 		 String ad=r.getAddress();
 		 smt1.setString(3, ad);
 		 String contact=r.getContact();
 		 smt1.setString(4, contact);
 		 int pi=r.getPid();
 		 smt1.setInt(5, pid);
         int a=smt1.executeUpdate();
 	    System.out.println("row effected: "+a);
 	    
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	usr.userPortal(uid);
}
public static void delete(int uid) {
	//jdbc call
	
System.out.println("Tell the id no. to be deleted:");
Scanner sc=new Scanner(System.in);
int i=sc.nextInt();

try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String uname="system";
		 String pass="1234";
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
		 String query="select c_id from customer";
		 Statement smt=con.createStatement();
     ResultSet res=smt.executeQuery(query);
    
     boolean flag=false;
     
     while(res.next()) {
   	  if(res.getInt("c_id")==i) {
   		  flag=true;
   		  break;
   	  }
     }
     if(flag==false) {
    	 System.out.println("Wrong id given..");
    	 usr.userPortal(uid);
     }
		 //Statement smt=con.createStatement();
		 //smt.executeUpdate("create table emp(d number,ss varchar(20))");
		 smt.close();
		 con.close();
	 }
	 catch(Exception e) {
		 e.getMessage();
	 }

  try {
	  Class.forName("oracle.jdbc.driver.OracleDriver");
		 String uname="system";
		 String pass="1234";
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
		 String query= "Delete from customer where c_id=?";
		 PreparedStatement stmt=con.prepareStatement(query);
		 stmt.setInt(1, i);
		 System.out.println("row effected: "+stmt.executeUpdate());
		 
  }
  catch(Exception e) {
	  e.printStackTrace();
  }

usr.userPortal(uid);
}
public static void setpriv(int uid) {
	//jdbc call
	System.out.println("Tell the id where you want to set the privilage to admin: ");
	Scanner sc=new Scanner(System.in);
	int pri=sc.nextInt();
	try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String uname="system";
		 String pass="1234";
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
		 String query="select c_id from cms_user";
		 Statement smt=con.createStatement();
    ResultSet res=smt.executeQuery(query);
   
    boolean flag=false;
    
    while(res.next()) {
  	  if(res.getInt("c_id")==pri) {
  		  flag=true;
  		  break;
  	  }
    }
    if(flag==false) {
   	 System.out.println("Wrong id given..");
   	 usr.userPortal(uid);
    }
		 //Statement smt=con.createStatement();
		 //smt.executeUpdate("create table emp(d number,ss varchar(20))");
		 smt.close();
		 con.close();
	 }
	 catch(Exception e) {
		 e.getMessage();
	 }
	
	 try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
			 String uname="system";
			 String pass="1234";
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
			 String query= "update cms_user set privilage = 'Admin'  where u_id=?";
			 PreparedStatement stmt=con.prepareStatement(query);
			 stmt.setInt(1, pri);
			 String query2="select u_name from cms_user where u_id=?";
			 PreparedStatement s2=con.prepareStatement(query2);
			 s2.setInt(1, pri);
			 ResultSet rss=s2.executeQuery();
			 rss.next();
			 System.out.println(rss.getString("u_name")+"is set to Admin!!");
			 System.out.println("row effected: "+stmt.executeUpdate());
			 stmt.close();
			 s2.close();
			 con.close();
			 
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	usr.userPortal(uid);
	
  }
}

class ip {
	public static void takeip() {
		System.out.println("-------------***********Welcome To Customer Management System************------------");
		System.out.println("1.New User Register");
		System.out.println("2.Existing user Login");
		System.out.println("3.Exit from system");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		switch(n) {
		case 1:appli.register();
		      break;
		case 2:appli.login();
		      break;
		case 3:System.exit(0);      
		      break;
		default:System.out.println("Wrong input...");   
		        takeip();
		}
	}
}

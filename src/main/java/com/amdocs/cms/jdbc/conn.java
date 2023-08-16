package com.amdocs.cms.jdbc;
import java.sql.*;
public class conn {
 public static void  concet(String stmt){
	 try {
   		 Class.forName("oracle.jdbc.driver.OracleDriver");
   		 String uname="system";
   		 String pass="1234";
   		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", uname, pass);
   		 
   		 //Statement smt=con.createStatement();
   		 //smt.executeUpdate("create table emp(d number,ss varchar(20))");
   		 //smt.close();
   		 //con.close();
   	 }
   	 catch(Exception e) {
   		 e.getMessage();
   	 }
       	
       
 }
}

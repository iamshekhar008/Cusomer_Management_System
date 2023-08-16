package com.amdocs.cms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "--------*************Welcome to Customer Management System***************---------");
        System.out.println("Please Select one of the following --");
        
        ip.takeip();
    	
    	
    }
}
class ip {
	public static void takeip() {
		System.out.println("1.New User Register");
		System.out.println("2.Existing user Login");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		switch(n) {
		case 1:appli.register();
		      break;
		case 2:appli.login();
		      break;
		default:System.out.println("Wrong input...");   
		        takeip();
		}
	}
}
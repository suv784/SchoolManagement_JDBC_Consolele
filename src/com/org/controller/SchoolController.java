package com.org.controller;

import java.util.Scanner;

public class SchoolController {
	public static void main(String[] args)
	{ 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO SMALL SCHOOL MANAGEMENGT SYSTEM:"); 
		System.out.println("<=======================================================================>"); 
		System.out.println("                                  <MENU>                                  "); 
		System.out.println("<========================================================================>");
		System.out.println("a)student management system:");
		System.out.println("b)Teacher mangement system:");
		System.out.println("c)To Manage student Score details:"); 
		System.out.println("d)To manage Course details:");
		System.out.println("*****************************************************************************");
		System.out.println("enter your choice-");
		System.out.println("******************************************************************************");
		char c = sc.next().charAt(0);
		String[] s = { " " };
		switch (c) {
		case 'a': {
			StudentCRUDcontroller.main(s); 
		}
			break;
		case 'b': {
			TeacherCRUDcontroller.main(s);
		}
			break;
			
		case 'c':
		{ 
			 ReportaCardController.main(s);
			
		}
		case 'd':
		{ 
			CourseCRUDcontroller.main(s);
			
		}
	
		default:
			System.out.println("invalid option");

		}

	}
}

package com.org.controller;

import java.util.List;
import java.util.Scanner;
import com.org.dao.StudentDao;
import com.org.dto.Student;

public class StudentCRUDcontroller {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao dao = new StudentDao();
		System.out.println("1)To add student details");
		System.out.println("2)To view student details");
		System.out.println("3)To delete student data");
		System.out.println("4)To update student details");
		System.out.println("5)To Exit");
		while (true) {
			System.out.println("enter your choice ch-");
			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				System.out.println("enter student id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("enter student name");
				String name = sc.nextLine();
				System.out.println("enter email");
				String email = sc.nextLine();
				System.out.println("enter student age:");
				int age = sc.nextInt();
				Student s = new Student();
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
				s.setAge(age);
				boolean res = dao.saveStudent(s);
				if (res) {
					System.out.println(name + "data saved sucessfully");
				} else {
					System.out.println("something went wrong");
				}

				break;
			}
			case 2: {
				List<Student> li = dao.getStudent();
				for (Student s : li) {
					System.out.printf("%-10s|",s.getId(),"\n");
					System.out.printf("%-20s|", s.getName(),"\n");
					System.out.printf("%-30s|", s.getEmail(),"\n");
					System.out.printf("%-3s|", s.getAge(),"\n");
					System.out.println("\n-----------------------------------------------------------------------------");
				}
				break;

			}

			case 3: {
				System.out.println("enter the id :");
				int id = sc.nextInt();
				boolean res = dao.deleteStudent(id);
				if (res) {
					System.out.println("Data deleted sucesfully");
				} else {
					System.out.println("data not delted sucesfully");
				}

			}
				break;
			case 4: {
				System.out.println("a)for updating name");
				System.out.println("b)for updating email");
				System.out.println("c)for updating age");
				System.out.println("d)for updating all details");
				System.out.println("enter your choice");
				char c = sc.next().charAt(0);
				switch (c) {
				case 'a': {
					System.out.println("enter the id of students");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the name to update");
					String name = sc.nextLine();
					boolean res = dao.updateName(id, name);
					if (res) {
						System.out.println("name update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'b': {
					System.out.println("enter the id of students");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the email to update");
					String email = sc.nextLine();
					boolean res = dao.updateEmail(id, email);
					if (res) {
						System.out.println("name update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'c': {
					System.out.println("enter the id of students");
					int id = sc.nextInt();
					System.out.println("enter the age to update");
					int age = sc.nextInt();
					boolean res = dao.updateAge(id, age);
					if (res) {
						System.out.println("name update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'd': {
					System.out.println("enter the id of the students:");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the name of the student to update:");
					String name = sc.nextLine();
					System.out.println("enter the email to update:");
					String email = sc.nextLine();
					System.out.println("enter the age to update:");
					int age = sc.nextInt();
					boolean res = dao.updateAllDetails(id, name, email, age);
					if (res) {
						System.out.println("updation sucessfully");
					} else {
						System.out.println("not sucess");
					}
				}
					break;
				default: {
					System.out.println("invalid");
				}
				}
			}

			case 5: {
				dao.closeConnection();
				return;

			}

			}
		}

	}

}

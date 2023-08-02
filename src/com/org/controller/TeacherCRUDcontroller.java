package com.org.controller;

import java.util.List;
import java.util.Scanner;
import com.org.dao.TeacherDa0;
import com.org.dto.Teacher;

public class TeacherCRUDcontroller {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TeacherDa0 dao = new TeacherDa0();
		System.out.println("1)To add Teacher details");
		System.out.println("2)To view Teacher details");
		System.out.println("3)To delete Teacher details");
		System.out.println("4)To update Teacher  details");
		System.out.println("5)To Exit");
		while (true) {
			System.out.println("enter your choice ch-");
			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				System.out.println("enter Teacher id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("enter Teacher name");
				String name = sc.nextLine();
				System.out.println("enter Teaching subject");
				String subject = sc.nextLine();
				System.out.println("enter Teacher phone:");
				int phone = sc.nextInt();
				Teacher t = new Teacher();
				t.setId(id);
				t.setName(name);
				t.setPhone(phone);
				t.setSubject(subject);
				boolean res = dao.saveTeacher(t);
				if (res) {
					System.out.println("data saved sucessfully");
				} else {
					System.out.println("something went wrong");
				}
			}
				break;

			case 2: {
				List<Teacher> li = dao.getTeachers();
				for (Teacher t : li) {
					System.out.println("id  :" + t.getId());
					System.out.println("Name  :" + t.getName());
					System.out.println("Subject :" + t.getSubject());
					System.out.println("phone  :" + t.getPhone());
					System.out.println("---------------------------------------------");
				}

			}
				break;

			case 3: {
				System.out.println("enter the id :");
				int id = sc.nextInt();
				boolean res = dao.deleteTeacher(id);
				if (res) {
					System.out.println("Data deleted sucesfully");
				} else {
					System.out.println("data not delted sucesfully");
				}

			}
				break;
			case 4: {
				System.out.println("a)for updating name");
				System.out.println("b)for updating subject");
				System.out.println("c)for updating phone");
				System.out.println("d)for updating all details");
				System.out.println("enter your choice");
				char c = sc.next().charAt(0);
				switch (c) {
				case 'a': {
					System.out.println("enter the id Teacher");
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
					System.out.println("enter the id of Teacher");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the  subject to update");
					String subject = sc.nextLine();
					boolean res = dao.updateSubject(id, subject);
					if (res) {
						System.out.println("Subject update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'c': {
					System.out.println("enter the id of Teacher");
					int id = sc.nextInt();
					System.out.println("enter the phone_number to update");
					int phone = sc.nextInt();
					boolean res = dao.updatephone(id, phone);
					if (res) {
						System.out.println("name update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'd': {
					System.out.println("enter the id of the Teacher:");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the name of the Teacher to update:");
					String name = sc.nextLine();
					System.out.println("enter the subject to update:");
					String subject = sc.nextLine();
					System.out.println("enter the phone to update:");
					int phone = sc.nextInt();
					boolean res = dao.updateAllDetails(id, name, subject, phone);
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

package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.dao.ReportCardDao;
import com.org.dto.ReportCard;

public class ReportaCardController {
	public static void main(String[] args) {
		ReportCardDao dao = new ReportCardDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1)To add student report details");
		System.out.println("2)To view student report details");
		System.out.println("3)To delete  student report data");
		System.out.println("4)To update student  report details");
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
				System.out.println("enter subject");
				String sub = sc.nextLine();
				System.out.println("enter student Grade:");
				String grade = sc.nextLine();
				ReportCard rd = new ReportCard();
				rd.setName(name);
				rd.setSubject(sub);
				rd.setId(id);
				rd.setGrade(grade);
				boolean res = dao.saveReport(rd);
				if (res) {
					System.out.println("data saved sucessfully");
				} else {
					System.out.println("something went wrong");
				}

				break;
			}
			case 2: {
				List<ReportCard> li = dao.getReportCards();
				for (ReportCard s : li) {
					System.out.println("Roll  :" + s.getId());
					System.out.println("Name  :" + s.getName());
					System.out.println("Grade :" + s.getGrade());
					System.out.println("subject  :" + s.getSubject());
					System.out.println("---------------------------------------------");
				}
				break;

			}

			case 3: {
				System.out.println("enter the id :");
				int id = sc.nextInt();
				boolean res = dao.deleteReport(id);
				if (res) {
					System.out.println("data deleted sucesfully");
				} else {
					System.out.println("data not delted sucesfully");
				}

			}
				break;
			case 4: {
				System.out.println("a)for updating name");
				System.out.println("b)for updating subject");
				System.out.println("c)for updating grade");
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
					System.out.println("enter the subject to update");
					String subject = sc.nextLine();
					boolean res = dao.updateSubject(id, subject);
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
					System.out.println("enter the grade to update");
					String grade = sc.nextLine();
					boolean res = dao.updateGrade(id, grade);
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
					System.out.println("enter the subject to update:");
					String subject = sc.nextLine();
					System.out.println("enter the grade to update:");
					String grade = sc.nextLine();
					boolean res = dao.updateAllDetails(id, name, subject, grade);
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

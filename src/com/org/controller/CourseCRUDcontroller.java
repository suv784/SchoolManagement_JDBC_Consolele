package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.dao.CourseDao;
import com.org.dto.Course;

public class CourseCRUDcontroller {
	public static void main(String[] args) {
		CourseDao dao = new CourseDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1)To add  course details");
		System.out.println("2)To view course details");
		System.out.println("3)To delete course  details");
		System.out.println("4)To update course  details");
		System.out.println("5)To Exit");
		while (true) {
			System.out.println("enter your choice ch-");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("enter course id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("enter course name");
				String name = sc.nextLine();
				System.out.println("enter course code");
				String code = sc.nextLine();
				System.out.println("enter student rating:");
				String rate = sc.nextLine();
				Course rd = new Course();
				rd.setCourseid(id);
				rd.setCourseName(name);
				rd.setCourseCode(code);
				rd.setCourseRating(rate);
				boolean res = dao.saveCourse(rd);
				if (res) {
					System.out.println("data saved sucessfully");
				} else {
					System.out.println("something went wrong");
				}

				break;
			}
			case 2: {
				List<Course> li = dao.getCourse();
				for (Course s : li) {
					System.out.println("Courseid  :" + s.getCourseid());
					System.out.println("CourseName  :" + s.getCourseName());
					System.out.println("CourseCode :" + s.getCourseCode());
					System.out.println("CourseRating :" + s.getCourseRating());
					System.out.println("---------------------------------------------");
				}
				break;

			}

			case 3: {
				System.out.println("enter the Courseid :");
				int id = sc.nextInt();
				boolean res = dao.deleteCourse(id);
				if (res) {
					System.out.println("data deleted sucesfully");
				} else {
					System.out.println("data not delted sucesfully");
				}

			}
				break;
			case 4: {
				System.out.println("a)for updating CourseName");
				System.out.println("b)for updating CourseCode");
				System.out.println("c)for updating CourseRating");
				System.out.println("d)for updating all details");
				System.out.println("enter your choice");
				char c = sc.next().charAt(0);
				switch (c) {
				case 'a': {
					System.out.println("enter the id of course");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the CourseName to update");
					String name = sc.nextLine();
					boolean res = dao.updateCourseName(id, name);
					if (res) {
						System.out.println("name update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'b': {
					System.out.println("enter the id of Course");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the CourseCode to update");
					String code = sc.nextLine();
					boolean res = dao.updatecourseCode(id, code);
					if (res) {
						System.out.println("name update sucesfully");
					} else {
						System.out.println("something went wrong");
					}

				}
					break;

				case 'c': {
					System.out.println("enter the id of Course");
					int id = sc.nextInt();
					System.out.println("enter the grade to update");
					String rate = sc.nextLine();
					boolean res = dao.updatecourseRating(id, rate);
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

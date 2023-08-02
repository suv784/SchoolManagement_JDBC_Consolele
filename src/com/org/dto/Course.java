package com.org.dto;

public class Course {
	private int Courseid;
	private String CourseName;
	private String CourseCode;
	private String CourseRating;

	public int getCourseid() {
		return Courseid;
	}

	public void setCourseid(int courseid) {
		Courseid = courseid;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}

	public String getCourseRating() {
		return CourseRating;
	}

	public void setCourseRating(String courseRating) {
		CourseRating = courseRating;
	}

}

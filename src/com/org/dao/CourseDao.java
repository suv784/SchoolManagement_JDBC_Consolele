package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.Course;

import com.org.helper.ConnectionHelper;

public class CourseDao {
	Connection con = ConnectionHelper.getConobj();

	public boolean saveCourse(Course r) {
		String sql = "INSERT INTO course VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getCourseid());
			ps.setString(2, r.getCourseName());
			ps.setString(3, r.getCourseCode());
			ps.setString(4, r.getCourseRating());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) { e.printStackTrace();
		 * } }
		 */
		return false;

	}

	public List<Course> getCourse() {
		String query = "select *  from course"; 
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<Course> li = new ArrayList<Course>();

			while (rs.next()) {
				Course c = new Course();
				c.setCourseid(rs.getInt(1));
				c.setCourseName(rs.getString(2));
				c.setCourseCode(rs.getString(3));
				c.setCourseRating(rs.getString(4));
				li.add(c);
			}
			return li;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * finally {
		 * 
		 * try { con.close(); } catch (SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } }
		 */
		return null;

	}

	public boolean deleteCourse(int id) {
		String query = "DELETE FROM course WHERE Courseid=" + id;
		try {
			Statement statement = con.createStatement();
			int res = statement.executeUpdate(query);
			if (res != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCourseName(int id, String Name) {
		String query = "update course set CourseName='" + Name + "'where Courseid=" + id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(query);
			if (res != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
		 */
		return false;

	}

	public boolean updatecourseCode(int id, String code) {
		String query = "update course set CourseCode='" + code + "'where Courseid=" + id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(query);
			if (res != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		return false;

	}

	public boolean updatecourseRating(int id, String rate) {
		String query = "update course set CourseRating='" + rate + "'where Courseid=" + id;
		try {
			Statement st = con.createStatement();
			int res = st.executeUpdate(query);
			if (res != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) { e.printStackTrace();
		 * } }
		 */
		return false;

	}

	public boolean updateAllDetails(int id, String Name, String code, String rate) {
		String query = "update course set CourseName=?,CourseCode=?,CourseRating=? where Courseid=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Name);
			ps.setString(2, code);
			ps.setString(3, rate);
			ps.setInt(4, id);
			int res = ps.executeUpdate();
			if (res != 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		return false;

	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}

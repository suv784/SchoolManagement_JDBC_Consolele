package com.org.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.Student;
import com.org.helper.ConnectionHelper;

public class StudentDao {
	Connection con = ConnectionHelper.getConobj();

	public boolean saveStudent(Student s) {
		String sql = "INSERT INTO student VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setInt(4, s.getAge());
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

	public List<Student> getStudent() {
		String query = "select * from student";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<Student> li = new ArrayList<Student>();

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setAge(rs.getInt(4));
				li.add(s);
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

	public boolean deleteStudent(int id) {
		String query = "DELETE FROM student WHERE id=" + id;
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

	public boolean updateName(int id, String Name) {
		String query = "update student set Name='" + Name + "'where id=" + id;
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

	public boolean updateEmail(int id, String email) {
		String query = "update student set email='" + email + "'where id=" + id;
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

	public boolean updateAge(int id, int age) {
		String query = "update student set age='" + age + "'where id=" + id;
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

	public boolean updateAllDetails(int id, String Name, String email, int age) {
		String query = "update student set name=?,email=?,age=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Name);
			ps.setString(2, email);
			ps.setInt(3, age);
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

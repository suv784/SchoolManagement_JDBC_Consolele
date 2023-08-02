package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.Teacher;
import com.org.helper.ConnectionHelper;

public class TeacherDa0 {
	Connection con = ConnectionHelper.getConobj();

	public boolean saveTeacher(Teacher t) {
		String sql = "INSERT INTO teacher VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getSubject());
			ps.setInt(4, t.getPhone());
			ps.execute();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
		 */
		return false;

	}

	public List<Teacher> getTeachers() {
		String query = "select * from teacher";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<Teacher> li = new ArrayList<Teacher>();

			while (rs.next()) {
				Teacher t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setSubject(rs.getString(3));
				t.setPhone(rs.getInt(4));
				li.add(t);
			}
			return li;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally {
		 * 
		 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
		 */
		return null;

	}

	public boolean deleteTeacher(int id) {
		String query = "DELETE FROM teacher WHERE id=" + id;
		try {
			Statement statement = con.createStatement();
			int res = statement.executeUpdate(query);
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

	public boolean updateName(int id, String Name) {
		String query = "update teacher set Name='" + Name + "'where id=" + id;
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

	public boolean updateSubject(int id, String Subject)

	{
		String query = "update teacher set Subject ='" + Subject + "'where id=" + id;
		try {
			Statement statement = con.createStatement();
			int res = statement.executeUpdate(query);
			if (res != 0)
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

	public boolean updatephone(int id, int phone) {
		String query = "update teacher set phone='" + phone + "'where id=" + id;
		try {
			Statement statement = con.createStatement();
			int res = statement.executeUpdate(query);
			if (res != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
		 */

		return false;

	}

	public boolean updateAllDetails(int id, String Name, String Subject, int phone) {
		String query = "update teacher set Name=?,Subject=?,phone=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Name);
			ps.setString(2, Subject);
			ps.setInt(3, phone);
			ps.setInt(4, id);
			int res = ps.executeUpdate();
			if (res != 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * finally { try { con.close(); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
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

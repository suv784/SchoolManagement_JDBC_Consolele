package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.ReportCard;
import com.org.helper.ConnectionHelper;

public class ReportCardDao {
	Connection con = ConnectionHelper.getConobj();

	public boolean saveReport(ReportCard r) {
		String sql = "INSERT INTO progressivereport VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setString(2, r.getName());
			ps.setString(3, r.getSubject());
			ps.setString(4, r.getGrade());
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

	public List<ReportCard> getReportCards() {
		String query = "select * from progressivereport";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<ReportCard> li = new ArrayList<ReportCard>();

			while (rs.next()) {
				ReportCard s = new ReportCard();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSubject(rs.getString(3));
				s.setGrade(rs.getString(4));
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

	public boolean deleteReport(int id) {
		String query = "DELETE FROM progressivereport WHERE id=" + id;
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
		String query = "update progressivereport set Name='" + Name + "'where id=" + id;
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

	public boolean updateSubject(int id, String Subject) {
		String query = "update progressivereport set Subject='" + Subject + "'where id=" + id;
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

	public boolean updateGrade(int id, String Grade) {
		String query = "update progressivereport set Grade='" + Grade + "'where id=" + id;
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

	public boolean updateAllDetails(int id, String Name, String Subject, String Grade) {
		String query = "update progressivereport set Name=?,Subject=?,Grade=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Name);
			ps.setString(2, Subject);
			ps.setString(3, Grade);
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

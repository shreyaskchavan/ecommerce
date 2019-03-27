package counter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import db.DatabaseManager;

public class CounterBo {

	private ServletContext context;

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public long getCurrentCounterValue() {
		long count = 0;
		String sql = "select * from counter";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(getConnection(), sql);
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getLong("websitecounter");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Connection getConnection() {
		String dburl = (String) context.getAttribute("dburl");
		String dbuname = (String) context.getAttribute("dbuname");
		String dbpass = (String) context.getAttribute("dbpassword");

		Connection con = DatabaseManager.getConnection(dburl, dbuname, dbpass);
		return con;

	}

	public void update(long count) {
		Connection con = getConnection();
		String sql = "update counter set websitecounter = ?";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setLong(1, count);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DatabaseManager;

public class MemberDaoImpl implements MemberDao {
	Connection con;

	public MemberDaoImpl(Connection con)// constructor injection
	{
		super();
		this.con = con;
	}

	public MemberDaoImpl() {

	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con)// setter injection
	{
		this.con = con;
	}

	@Override
	public String insert(MemberDto mdto) {

		// put jdbc code here
		String result = "data entered successfully";
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setString(1, mdto.getUname());
			ps.setString(2, mdto.getPassword());
			ps.setString(3, mdto.getFname());
			ps.setString(4, mdto.getLname());
			ps.setString(5, mdto.getEmail());
			ps.setLong(6, mdto.getPhone());
			ps.setDate(7, mdto.getDob());
			ps.setDate(8, mdto.getDor());
			ps.setString(9, mdto.getMlevel());

			ps.executeUpdate();

		} catch (SQLException e) {
			result = "data not entered successfully";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import db.DatabaseManager;

public class LoginCheck {
	private ServletContext scontext;
	
	public ServletContext getScontext() {
		return scontext;
	}

	public void setScontext(ServletContext scontext) {
		this.scontext = scontext;
	}

	public String checkLogin(String uname, String password) 
	{
		//check if user with the given username and password exist and return mlevel. 
		//if not then return null
	Connection con = getConnection();
	
	String sql = "select * from member where uname=? and password=?";
	PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
	try {
		ps.setString(1, uname);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		
		
		return "m1";
	}
	
	public Connection getConnection() {
		String dburl = (String) scontext.getAttribute("dburl");
		String dbuname = (String) scontext.getAttribute("dbuname");
		String dbpass = (String) scontext.getAttribute("dbpassword");

		Connection con = DatabaseManager.getConnection(dburl, dbuname, dbpass);
		return con;

	}
}

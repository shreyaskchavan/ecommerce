package member;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import db.DatabaseManager;

public class MemberBo {
	ServletContext scontext;

	public ServletContext getScontext() {
		return scontext;
	}

	public void setScontext(ServletContext scontext) {
		this.scontext = scontext;
	}

	// this function will be the entry point of the jsp page and from here the other
	// classes will get called.
	// it will return the status whether the data was entered successfully or not
	// entered successfully.
	public String insert(MemberForm mform) {

		MemberDto mdto = formToDto(mform);
		Connection con = getConnection();
		MemberDao mdao = new MemberDaoImpl(con);
		String result = mdao.insert(mdto);

		return result;

	}

	public MemberDto formToDto(MemberForm mform) {
		java.sql.Date dob = null;
		java.sql.Date dor = null;

		String dd = mform.getDd();
		String mm = mform.getMm();
		String yy = mform.getYy();
		String pattern = "dd/MM/yyyy";

		String d1 = dd + "/" + mm + "/" + yy;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			java.util.Date d2 = sdf.parse(d1);
			dob = new Date(d2.getTime());

			java.util.Date d4 = new java.util.Date();
			dor = new Date(d4.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MemberDto mdto = new MemberDto(mform.getUname(), mform.getPassword(), mform.getFname(), mform.getLname(),
				mform.getEmail(), "m1", Long.parseLong(mform.getPhone()), dob, dor);

		return mdto;
	}

	public Connection getConnection() {
		String dburl = (String) scontext.getAttribute("dburl");
		String dbuname = (String) scontext.getAttribute("dbuname");
		String dbpass = (String) scontext.getAttribute("dbpassword");

		Connection con = DatabaseManager.getConnection(dburl, dbuname, dbpass);
		return con;

	}
}

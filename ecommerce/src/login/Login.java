package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet 
{
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		LoginCheck lcheck = new LoginCheck();
		lcheck.setScontext(request.getServletContext());
		
		String mlevel = lcheck.checkLogin(uname, password);
		
		if(mlevel != null) {
			//the user is logged in properly
			
			
			//we should create a session only iff the user is logged in properly.
			HttpSession hs = request.getSession(true);
			hs.setAttribute("uname", uname);
			hs.setAttribute("password", password);
			hs.setAttribute("mlevel", mlevel);
			hs.setAttribute("cart", null);
			
			if(remember != null) {
				//create cookies
				Cookie c1 = new Cookie("uname", uname);
				Cookie c2 = new Cookie("password", password);
				
				c1.setMaxAge(10000);
				c2.setMaxAge(10000);
				response.addCookie(c1);
				response.addCookie(c2);
				
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("member/member.jsp");
			rd.forward(request, response);
			
			//response.sendRedirect("member/member.jsp");
		}
		else {
			//user is not logged in properly
			response.sendRedirect("login.jsp");
		}
	}

}

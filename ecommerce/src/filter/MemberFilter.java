package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MemberFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		boolean authenticated = false;
		boolean authorized = false;

		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse hsresponse = (HttpServletResponse) response;
		
		HttpSession hs = hsr.getSession(false);

		if (hs != null) {
			Object obj = hs.getAttribute("mlevel");
			if (obj != null) {
				authenticated = true;
				String mlevel = (String) obj;

				if (mlevel.equals("m1")) {
					authorized = true;
				} else {
					authorized = false;
				}
			}
		} else {
			authenticated = false;
			authorized = false;
		}

		System.out.println("Member filter executed");

		// pass the request along the filter chain
		if (authenticated == true && authorized == true) {
			chain.doFilter(request, response);
		}
		else {
			hsresponse.sendRedirect("../login.jsp");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

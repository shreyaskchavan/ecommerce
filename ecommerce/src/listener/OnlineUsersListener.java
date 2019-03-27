package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineUsersListener
 *
 */
@WebListener
public class OnlineUsersListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public OnlineUsersListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext context = arg0.getSession().getServletContext();
		String count = (String) context.getAttribute("onlineusercount");
		int userCount = Integer.parseInt(count);
		userCount = userCount + 1;
		context.setAttribute("onlineusercount", Integer.toString(userCount));
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext context = arg0.getSession().getServletContext();
		String count = (String) context.getAttribute("onlineusercount");
		int userCount = Integer.parseInt(count);
		userCount = userCount - 1;
		context.setAttribute("onlineusercount", Integer.toString(userCount));
	}

}

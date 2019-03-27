package listener;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.io.FileUtils;

import counter.CounterBo;
import db.DatabaseManager;

/**
 * Application Lifecycle Listener implementation class InitializationListener
 *
 */

public class InitializationListener implements ServletContextListener, ServletContextAttributeListener {

	/**
	 * Default constructor.
	 */
	public InitializationListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ecommerce destroyed");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("ecommerce initialized");
		ServletContext context = arg0.getServletContext();

		System.out.println("inside init");

		String dburl = context.getInitParameter("dburl");
		Enumeration<String> e = context.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = context.getInitParameter(name);
			context.setAttribute(name, value);
			System.out.println("name = " + name + " value = " + value);

		}
		String driver = (String) context.getAttribute("dbdriver");
		DatabaseManager.loadDriver(driver);

		// we are going to copy the content from the ecommerce images folder to our
		// present project images
		// folder

		String imageLocation = (String) context.getAttribute("imageLocation");
		String contextPath = context.getRealPath("/");
		String destinationLocation = contextPath + ("/images");

		File sourcedir = new File(imageLocation);
		File destdir = new File(destinationLocation);
		try {
			FileUtils.copyDirectory(sourcedir, destdir);
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		// website counter
		// We will read the counter table once and put the value into the servletContext
		// attribute
		CounterBo cbo = new CounterBo();
		cbo.setContext(context);
		long count = cbo.getCurrentCounterValue();
		context.setAttribute("websitecount", Long.toString(count));

		context.setAttribute("onlineusercount", "0");

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		String name = arg0.getName();

		if (name.equals("websitecount")) {
			//update database only if attribute's name is websitecount
			CounterBo cbo = new CounterBo();
			cbo.setContext(arg0.getServletContext());
			String s = (String) arg0.getServletContext().getAttribute("websitecount");
			long count = Long.parseLong(s);
			cbo.update(count);
		}
	}

}

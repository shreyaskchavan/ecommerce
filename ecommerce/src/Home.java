import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.io.FileUtils;

import db.DatabaseManager;

//javax.servlet package contains many classes and interfaces 
//interfaces are
//Servlet,ServletRequest,ServletResponse,ServletContext,ServletConfig
//to create a servlet, we need to implement the Servlet interface
public class Home implements Servlet
{
	
	//life cycle of a servlet:
	//after tomcat receives a request for the servlet and gets hold of
	//a recent servlet object. then it calls the init service only
	//once throughout the life cycle of the servlet object
	//then, the service method will get called for each consequent
	//calls. destroy will get called when the service object will
	//get garbage collected

	@Override
	public void destroy() {  
		System.out.println("inside destroy");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		
		
		
		
		
//		ServletContext context = arg0.getServletContext();
//	
//		System.out.println("inside init");
//		
//		String dburl = arg0.getInitParameter("dburl");
//		Enumeration<String> e = arg0.getInitParameterNames();
//		while(e.hasMoreElements())
//		{
//			String name = e.nextElement();
//			String value = arg0.getInitParameter(name);
//			context.setAttribute(name, value);
//			System.out.println("name = " + name + " value = " + value);
//			
//		}
//		String driver = (String) context.getAttribute("dbdriver");
//		DatabaseManager.loadDriver(driver);
//		
//		//we are going to copy the content from the ecommerce images folder to our present project images
//		//folder
//		
//		String imageLocation = (String) context.getAttribute("imageLocation");
//		String contextPath = context.getRealPath("/");
//		String destinationLocation = contextPath + ("/images");
//		
//		File sourcedir = new File(imageLocation);
//		File destdir = new File(destinationLocation);
//		try {
//			FileUtils.copyDirectory(sourcedir, destdir);
//		} catch (IOException e1) {
//			
//			e1.printStackTrace();
//		}
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("inside service");
		RequestDispatcher rd = arg0.getRequestDispatcher("home.jsp");
		rd.include(arg0, arg1);
		
	}
	
}
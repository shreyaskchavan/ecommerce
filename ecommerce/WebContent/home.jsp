<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img src="images/ecommerce.jpg">

	<%
		Object obj = application.getAttribute("websitecount");
		String count = (String) obj;
		long l = Long.parseLong(count);
		l = l + 1;
		application.setAttribute("websitecount", Long.toString(l));
	%>
	<%="website counter is " + l%>
</body>
</html>
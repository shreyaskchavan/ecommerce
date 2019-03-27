<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie a[] = request.getCookies();
		for (Cookie x : a) {
			out.println(x.getName() + ", " + x.getValue() + "</br>");
		}

		String count = (String) application.getAttribute("onlineusercount");
	%>
	The number of online users is:
	<%=count%>
</body>
</html>
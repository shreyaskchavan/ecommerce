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
		HttpSession hs = request.getSession(false);
		if (hs != null) {
			hs.invalidate();
		}
		
		Cookie[] arr = request.getCookies();
		for(int i = 0; i < arr.length; i++) {
			Cookie c = arr[i];
			c.setMaxAge(-1);
			response.addCookie(c);
		}
	%>
</body>
</html>
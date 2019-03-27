<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- we'll use jsp action elements here -->

	<jsp:useBean id="memberFormBean" class="member.MemberForm"></jsp:useBean>
	<!-- The above line is creating an object of MemberForm which can be referred to using variable 'MemberFormBean' -->

	<jsp:setProperty property="*" name="memberFormBean" />
	<!-- this function will call all the setter methods of the MemberFormBean object and fill it up with the request
	parameters -->

	<jsp:useBean id="memberBoBean" class="member.MemberBo"></jsp:useBean>
	<%
		memberBoBean.setScontext(application);
		String result = memberBoBean.insert(memberFormBean);
		out.println(result);
	%>



	<%=result%>
	<!-- this expression will display the result -->

</body>
</html>
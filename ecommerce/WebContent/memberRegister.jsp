<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Member Register</h1>
	<form action="memberRegisterResult.jsp" method="post">

		<table class="table table-hover">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><select name="dd"><option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option></select> <select name="mm"><option
							value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option></select> <select name="yy"><option
							value="2001">2001</option>
						<option value="2002">2002</option>
						<option value="2003">2003</option></select></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>

	</form>
</body>
</html>
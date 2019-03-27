<%@page import="product.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
	<th>Check Out</th>
		<%
			double total = 0;
			Object obj = session.getAttribute("cart");
			if (obj != null) {
				List<ProductDto> l = (List<ProductDto>) obj;
				for (ProductDto pdto : l) {
					total += pdto.getPrice();
		%>

		<tr>
			<td><%=pdto.getTitle()%></td>
			<td><%=pdto.getPrice()%></td>
		</tr>

		<%
			}
			}
		%>
		<tr>
			<td>Total is</td>
			<td><%=total%></td>
		</tr>
	</table>
</body>
</html>
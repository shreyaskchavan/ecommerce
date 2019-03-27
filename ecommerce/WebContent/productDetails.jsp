<%@page import="product.ProductDto"%>
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
	<jsp:useBean id="productbobean" class="product.ProductBo"></jsp:useBean>
	<table class="table table-hover">
		<%
			productbobean.setScontext(application);
			ProductDto pdto = productbobean.searchById(request.getParameter("id"));
		%>
		<tr>
			<td><%=pdto.getTitle()%></td>
		</tr>
		<tr>
			<td><%=pdto.getDescription()%></td>
		</tr>
		<tr>
			<td><img src="images/<%=pdto.getPicture1()%>" width="200"
				height="200"></td>
		</tr>
		<tr>
			<td>Price = <%=pdto.getPrice()%></td>
		</tr>
		<tr>
			<td><%=pdto.getProductid()%></td>
		</tr>
		<tr>
			<td><%=pdto.getCatid()%></td>
		</tr>
		<tr>
			<td><%=pdto.getSubcatid()%></td>
		</tr>
		<tr>
			<td><%=pdto.getStatus()%></td>
		</tr>
		<tr>
			<td><%=pdto.getUname()%></td>
		</tr>
		<tr>
			<td><%=pdto.getClass()%></td>
		</tr>
		<tr>
			<td><%=pdto.getDou()%></td>
		</tr>
		<tr>
			<td><a href ="member/addToCart.jsp?pid=<%=pdto.getProductid() %>">Add to cart</a></td>
		</tr>
	</table>
</body>
</html>
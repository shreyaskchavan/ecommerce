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
	<h1>Product Upload</h1>
	<form action="productUploadResult.jsp" method="post" enctype="multipart/form-data">

		<table class="table table-hover">
			<tr>
				<td>Category</td>
				<td><select name="catid"><option value="toy">Toy</option>
						<option value="book">Book</option>
						</select></td>
			</tr>
			<tr>
				<td>Subcategory</td>
				<td><select name="subcatid"><option value="chess">Chess</option>
						<option value="novel">Novel</option>
						</select></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"></td>
			</tr>
			
			<tr>
				<td>Picture1</td>
				<td><input type="file" name="picture1"></td>
			</tr>
			<tr>
				<td>Picture2</td>
				<td><input type="file" name="picture2"></td>
			</tr>
			

			<tr>
				<td></td>
				<td><input type="submit" value="Upload"></td>
			</tr>
		</table>

	</form>
</body>
</html>
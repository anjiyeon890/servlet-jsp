<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.techtutorial.connection.DbCon"%>
<%@ page import="cn.techtutorial.model.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
%>
<!DOCTYPE html>
<html>
<head>

<title>Cart Page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>

	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: $452</h3>
			<a class="mx-3 btn btn-primary" href="#">Check OutS</a>
			<table class="table table-light">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Category</th>
						<th scope="col">Price</th>
						<th scope="col">Buy Now</th>
						<th scope="col">Cancel</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Women Shoes</td>
						<td>Shoes</td>
						<td>45$</td>
						<td>
							<form action="" method="post" class="form-inline">
								<input type="hidden" name="id" value="1" class="form-input">
								<div class="form-group d-flex justify-between"></div>
								<a class="btn btn-sm btn-incre" href=""><i
									class="fas fa-plus-square"></a>
									
								<input type="text" name="quantity" class="">
									
								<a class="btn btn-sm btn-decre" href=""><i
									class="fas fa-minus-square"></a>
							</form>

						</td>
					</tr>
				</tbody>

			</table>
		</div>

	</div>


	<%@include file="includes/head.jsp"%>
</body>
</html>
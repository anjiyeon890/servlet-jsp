<%@page import="cn.techtutorial.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.techtutorial.connection.DbCon"%>
<%@ page import="cn.techtutorial.model.*"%>
<%@ page import="java.util.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
%>

<%
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>

<title>Welcome to Shopping Cart</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Product</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card" style="width: 18rem;">
					<img src="product-images/<%= p.getImage() %>" class="card-img-top"
						alt="<%= p.getImage() %>">
					<div class="card-body">
						<h5 class="card-title"><%= p.getName() %></h5>
						<h5 class="price">Price: $<%= p.getPrice() %></h5>
						<h5 class="category">Category: <%= p.getCategory() %></h5>
						<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-cart?id=<%=p.getId() %>" class="btn btn-dark">Add to Cart</a> 
							<a href="#"
								class="btn btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%}
			}%>
		</div>
	</div>

	<%@include file="includes/head.jsp"%>
</body>
</html>
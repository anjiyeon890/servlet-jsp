<%@page import="java.text.DecimalFormat"%>
<%@page import="cn.techtutorial.dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.techtutorial.connection.DbCon"%>
<%@ page import="cn.techtutorial.model.*"%>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProducts = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProducts = pDao.getCartProducts(cart_list);
	Double total = pDao.getTotalCartPrice(cart_list);
	cart_list = (ArrayList<Cart>) cartProducts;
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
}
%>

<main>
	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: $ ${ (total>0)?dcf.format(total):0 }</h3>
			<a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a>
		</div>
		<table class="table table-light text-center align-middle">
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
				<%
				if (cart_list != null) {
					for (Cart c : cart_list) {
				%>

				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%=dcf.format(c.getPrice())%></td>
					<td>
						<form action="order-now" method="post" class="d-flex"
							style="justify-content: center;">
							<input type="hidden" name="id" value=<%=c.getId()%>
								class="form-input w-50">
							<div class="form-group d-flex justify-between w-50">
								<a class="btn btn-decre"
									href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i
									class="fas fa-minus-square"></i></a> <input type="text"
									name="quantity" class="form-control" value=<%=c.getQuantity()%>
									readonly> <a class="btn btn-incre"
									href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i
									class="fas fa-plus-square"></i></a>

							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>

					</td>
					<td><a class="btn btn-sm btn-danger"
						href="remove-from-cart?id=<%=c.getId()%>">Remove</a></td>
				</tr>

				<%
				}
				}
				%>




			</tbody>

		</table>


	</div>
</main>



<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">E-Commerce Shopping Cart</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarScroll" aria-controls="navbarScroll"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span
						class="badge bg-danger">${cart_list.size()}</span></a></li>

				<%
				if (auth != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="order.jsp">Order</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="log-out">Logout</a>
				</li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>
				<%
				}
				%>



			</ul>
		</div>
	</div>
</nav>


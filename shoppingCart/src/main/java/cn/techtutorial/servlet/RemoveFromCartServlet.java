package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.techtutorial.model.Cart;

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter writer = response.getWriter()) {
			String id = request.getParameter("id");
			if (id != null) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

				if (cart_list != null) {
					for (Cart c : cart_list) {
						if (c.getId() == Integer.parseInt(id)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}

					}

				}
//				response.sendRedirect("cart.jsp");
				request.setAttribute("tileName", "cart");
				request.getRequestDispatcher("/includes/cart.jsp").forward(request, response);
			} else {
//				response.sendRedirect("cart.jsp");
				request.setAttribute("tileName", "cart");
				request.getRequestDispatcher("/includes/cart.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

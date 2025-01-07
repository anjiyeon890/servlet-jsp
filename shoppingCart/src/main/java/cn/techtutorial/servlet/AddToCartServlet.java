package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.techtutorial.model.Cart;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter writer = response.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<>();

			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id : " + id);
			Cart cart = new Cart();
			cart.setId(id);
			cart.setQuantity(1);

			System.out.println("now cart : " + cart.toString());

			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart-list", cartList);
//				response.sendRedirect("index.jsp");
				request.setAttribute("tileName", "index");
				request.getRequestDispatcher("/includes/index.jsp").forward(request, response);
			} else {

				for (int i = 0; i < cart_list.size(); i++) {
					System.out.println(cart_list.get(i).toString());
				}

				cartList = cart_list;

				System.out.println("새로운 시작");

				if (cartList.contains(cart)) {
					writer.println("<h3 style='color:crimson; text-align:center;'>Item already exist in Cart<a href='cart.jsp'>Go to Cart Page</a></h3>");
				} else {
					cartList.add(cart);
					session.setAttribute("cart-list", cartList);
//					response.sendRedirect("index.jsp");
					request.setAttribute("tileName", "index");
					request.getRequestDispatcher("/includes/index.jsp").forward(request, response);					
					
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

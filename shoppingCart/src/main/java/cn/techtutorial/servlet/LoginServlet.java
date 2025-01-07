package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.UserDao;
import cn.techtutorial.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.sendRedirect("login.jsp");
		request.setAttribute("tileName", "login");
		request.getRequestDispatcher("/includes/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");

			try {
				UserDao uDao = new UserDao(DbCon.getConnection());
				User user = uDao.userLogin(email, password);

				if (user != null) {
					out.print("user login");
					request.getSession().setAttribute("auth", user);
//					response.sendRedirect("index.jsp");
					request.setAttribute("tileName", "index");
					request.getRequestDispatcher("/includes/index.jsp").forward(request, response);
				} else {
					out.print("user login failed");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			out.print(email + password);

		}
	}

}

package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.techtutorial.model.Order;
import cn.techtutorial.model.Product;

public class OrderDao {

	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public OrderDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean insertOrder(Order model) {
		boolean result = false;

		try {

			query = "insert into orders(p_id, u_id, o_quantity, o_date) values(?, ?, ?, ?)";
			pst = this.connection.prepareStatement(query);
			pst.setInt(1, model.getId());
			pst.setInt(2, model.getUid());
			pst.setInt(3, model.getQuantity());
			pst.setString(4, model.getDate());

			pst.executeUpdate();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public List<Order> userOrders(int id) {
		List<Order> list = new ArrayList<Order>();

		try {
			query = "select * from orders where u_id=? order by orders.o_id desc";
			pst = this.connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				ProductDao productDao = new ProductDao(this.connection);
				int pId = rs.getInt("p_id");
				Product product = productDao.getSingleProduct(pId);
				order.setOrderId(rs.getInt("o_id"));
				order.setId(pId);
				order.setName(product.getName());
				order.setCategory(product.getCategory());
				order.setPrice(product.getPrice() * rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void cancelOrder(int id) {
		try {
			query = "delete from orders where o_id=?";
			pst = this.connection.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

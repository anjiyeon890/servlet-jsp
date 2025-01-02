package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.techtutorial.model.Cart;
import cn.techtutorial.model.Product;

public class ProductDao {
	private Connection connection;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();

		try {
			query = "select * from products";
			pst = this.connection.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));

				products.add(row);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> products = new ArrayList<Cart>();

		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select * from products where id=?";
					pst = this.connection.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getDouble("price") * item.getQuantity());
						row.setQuantity(item.getQuantity());
						System.out.println(row.toString());
						products.add(row);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return products;

	}

	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;

		try {

			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select price from products where id=?";
					pst = this.connection.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();

					while (rs.next()) {
						sum += rs.getDouble("price") * item.getQuantity();

					}
				}
			} 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return sum;

	}

	public Product getSingleProduct(int id) {
		
		Product row=null;
		
		try {
			
			query="select * from products where id=?";
			pst=this.connection.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				row=new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return row;
	}

}

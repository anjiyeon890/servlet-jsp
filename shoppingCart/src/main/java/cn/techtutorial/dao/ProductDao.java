package cn.techtutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
				row.setPrice(rs.getString("price"));
				row.setImage(rs.getString("image"));

				products.add(row);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

}

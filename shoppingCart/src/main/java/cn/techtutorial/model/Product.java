package cn.techtutorial.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
	private int id;
	private String name;
	private String category;
	private String price;
	private String image;

}

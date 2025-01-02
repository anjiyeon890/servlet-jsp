package cn.techtutorial.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Product {
	private int id;
	private String name;
	private String category;
	private double price;
	private String image;

}

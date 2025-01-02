package cn.techtutorial.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Order extends Product{
	
	private int orderId;
	private int uid;
	private int quantity;
	private String date;
	
}

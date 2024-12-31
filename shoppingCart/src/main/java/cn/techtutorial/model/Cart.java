package cn.techtutorial.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"quantity"})
@ToString(callSuper = true)
public class Cart extends Product{
	
	private int quantity;

}

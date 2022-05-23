package shop;

import java.io.Serializable;

public class CartBean extends ShohinBean implements Serializable {
	
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getSumPrice() {
		return price * quantity; 
	}
}

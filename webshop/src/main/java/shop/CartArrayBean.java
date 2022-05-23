package shop;

import java.io.Serializable;
import java.util.ArrayList;

public class CartArrayBean implements Serializable {

	private ArrayList<CartBean> cartArray = new ArrayList<CartBean>();
	
	public CartArrayBean() {
	}
	
	public ArrayList<CartBean> getcartArray() {
		return cartArray;
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for (CartBean rec : cartArray) {
			sum += rec.getSumPrice();
		}
		return sum;
	}
	
	public void delCartArray(String shohinCode) {
		for (int i=0;i<cartArray.size();i++) {
		//for (CartBean rec : cartArray) {
			
			CartBean rec = cartArray.get(i);
			if (rec.getCode().equals(shohinCode)) {
				cartArray.remove(rec);
			}
		}
	}
	
	public void addcartArray(CartBean crb) {
		cartArray.add(crb);
	}
}

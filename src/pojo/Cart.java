package pojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private ArrayList<LineItem> lineItems = new ArrayList();
	
	public Cart() {
		
	}
	public void addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public int getItemCount() {
		return lineItems.size();
	}

}

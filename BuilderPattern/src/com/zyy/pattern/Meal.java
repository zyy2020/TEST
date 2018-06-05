package com.zyy.pattern;

import java.util.ArrayList;

public class Meal {
	private ArrayList<Item>items=new ArrayList<>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public float getCost() {
		float sum=0.0f;
		for (Item item : items) {
			sum+=item.price();
		}
		return sum;
	}
	
	public void showItems() {
		
		for (Item item : items) {
			 System.out.print("Item : "+item.name());
	         System.out.print(", Packing : "+item.packing().pack());
	         System.out.println(", Price : "+item.price());
		}
	}

}

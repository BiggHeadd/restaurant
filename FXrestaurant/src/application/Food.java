package application;

import javafx.scene.control.CheckBox;

public class Food {
	private String name;
	private double price;
	
	public Food() {
		this("Null", 0);
	}
	public Food(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public CheckBox getFood() {
		String str = String.format("%-20s\t%-10.1f", this.getName(), this.getPrice());
		CheckBox temp = new CheckBox(str);
		return temp;
	}
}

package application;

public class Stack {
	private static final Food None = null;
	private Food[] FoodArray = new Food[20];
	private int top;
	private int buttom;
	public Stack() {
		this.top = this.buttom = 0;
	}
	public void Push(Food food_insert) {
		if(this.top < 20) {
			FoodArray[this.top] = food_insert;
			this.top += 1;
		}
		else {
			System.out.println("You have ordered too many food!");
		}
	}
	
	public Food Pop() {
		if(this.top == this.buttom) {
			System.out.println("you have ordered nothing!");
			return None;
		}
		else {
			this.top -= 1;
			return this.FoodArray[top];
		}
	}
	
	public boolean StackEmpty() {
		if(this.top == this.buttom) {
			return true;
		}
		else {
			return false;
		}
	}
}

package application;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class RestautantFood {
	private Stack stack_food = new Stack();
	public RestautantFood() throws IOException {
//		System.out.println("here");
		Scanner input = new Scanner(new File("food/foods.txt"));
//		System.out.println("here");
		while(input.hasNextLine()) {
			String[] str = input.nextLine().split(" ");
//			System.out.print(str[0]+'\n');
//			System.out.print(str[1]+'\n');
			Food food = new Food(str[0], Double.parseDouble(str[1]));
			this.stack_food.Push(food);
			
		}
		input.close();
	}
	public Stack get_stack() {
		return this.stack_food;
	}
//	public void main(String[] args) throws IOException {
//		RestautantFood my_food = new RestautantFood();
//		my_food.get_stack();
//	}
}

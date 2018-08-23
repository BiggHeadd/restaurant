package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GetPane {
	private BorderPane pane;
	private int index = 1;
	private double total = 0;
	private String[] ordered_food = new String[20];
	private double now_total = 0;
	private boolean flaggg = true;
	public GetPane() {
		this.pane = new BorderPane();
	}
	
	public BorderPane get_pane() throws IOException {
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(5, 5, 5, 5));
		vbox.setStyle("-fx-border-color: green");
		
		VBox total = new VBox();
		total.setPadding(new Insets(5, 5, 5, 5));
		total.setStyle("-fx-border-color: green");
		
		RestautantFood rf = new RestautantFood();
		Stack food_list = rf.get_stack();
		CheckBox[] checkboxes = new CheckBox[20];
		Text[] texts = new Text[20];
		while(!food_list.StackEmpty()) {
			Food temp = new Food();
			temp = food_list.Pop();
			checkboxes[index] = temp.getFood();
			texts[index] = new Text(temp.getName() + ' ' + temp.getPrice());
			vbox.getChildren().add(checkboxes[index]);
			index += 1;
		}
//		System.out.println(texts[1].toString());
		System.out.println(checkboxes[1].toString());
//		vbox.setAlignment(Pos.CENTER);
		
		VBox ordered = new VBox();
		Text text = new Text("Your Food:");
		ordered.getChildren().add(text);
		
		
		int[] flagarray = new int[20];
		for(int i=1; i<flagarray.length; i++) {
			flagarray[i]=0;
		}
		Text money = new Text(String.valueOf(this.total));
		Text money_name = new Text("Total:");
		total.getChildren().add(money_name);
		total.getChildren().add(money);
		
		Button confirm = new Button("confirm");
		confirm.setAlignment(Pos.BASELINE_LEFT);
		total.getChildren().add(confirm);
		
		
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
            public void handle(ActionEvent event) {
				flaggg=false;
                System.out.println("Confirm!");
                Text confirm_message = new Text("you have finished your order!");
                ordered.getChildren().add(confirm_message);
                
                for(int i=1; i<index; i++) {
    				if(flagarray[i] == 1) {
    					System.out.println(texts[i].getText());
    					ordered_food[i] = texts[i].getText();
    				}
    			}
                System.out.println(now_total);
            }
		});
		
//		System.out.println(flagarray.toString());
		if(this.flaggg) {
			EventHandler<ActionEvent> handler = e->{
				for(int i=1; i<index; i++) {
					if(checkboxes[i].isSelected() && flagarray[i] == 0) {
						ordered.getChildren().add(texts[i]);
						double temp = Double.parseDouble(texts[i].getText().split(" ")[1]);
//						System.out.println(texts[i].getText().split(" ")[1]);
//						this.total += temp;
						flagarray[i] = 1;
					}
					else if(!checkboxes[i].isSelected()){
						ordered.getChildren().remove(texts[i]);
//						double temp = Double.parseDouble(texts[i].getText().split(" ")[1]);
//						this.total -= temp;
						flagarray[i] = 0;
					}
				}
				for(int i=1; i<index; i++) {
					if(flagarray[i] == 1) {
						System.out.println(texts[i].getText());
						ordered_food[i] = texts[i].getText();
					}
				}
//				System.out.println(ordered_food[1]);
				this.total = 0;
				for(int i=1; i<index; i++) {
					if(flagarray[i] == 1) {
						double temp = Double.parseDouble(texts[i].getText().split(" ")[1]);
						System.out.println(texts[i].getText().split(" ")[1]);
						this.total += temp;
					}
				}
				money.setText(String.valueOf(this.total));
				
				System.out.println("total cost: " + this.total);
				this.now_total = this.total;
			};
			
			for(int i = 1; i < index; i++) {
				checkboxes[i].setOnAction(handler);
			}
		}
		
		
//		checkboxes[0].setOnAction(handler);
//		checkboxes[1].setOnAction(handler);
//		checkboxes[2].setOnAction(handler);
//		checkboxes[3].setOnAction(handler);
//		
		
//		System.out.println("\n");
		
		this.pane.setBottom(total);
		this.pane.setTop(vbox);
		this.pane.setCenter(ordered);
		
		return this.pane;
	}
}

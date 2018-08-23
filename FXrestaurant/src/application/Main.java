package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GetPane get = new GetPane();
			BorderPane pane = get.get_pane();
			Scene scene = new Scene(pane, 500, 500);
			primaryStage.setTitle("MyRestaurant");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
//		RestautantFood my_food = new RestautantFood();
//		Stack my_stackk = my_food.get_stack();
//		Food top = new Food();
//		top = my_stackk.Pop();
//		System.out.println(top.getName() + " " + top.getPrice());
	}
}

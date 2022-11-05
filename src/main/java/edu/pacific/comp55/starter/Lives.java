package edu.pacific.comp55.starter;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lives{
	Text lives;
	Text points;
	int numPoints = 0;
	int numLives = 3;
	Pane root = new Pane();
 
	public static void main(String[] args) {
	
 
	}
	public void start(Stage primaryStage) throws Exception {
 
		//life and points
 
		lives = new Text("Lives: 3");
		lives.setLayoutX(20);
		lives.setLayoutY(30);
		lives.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
		lives.setFill(Color.WHITE);
	    points = new Text("Points: 0");
	    points.setLayoutX(350);
		points.setLayoutY(30);
		points.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
		points.setFill(Color.WHITE);
		root.getChildren().addAll(lives, points);
}
	private void isPlayerDestroyed() {
		// write a for loop and if condition on when to decrease the lives

		
					       numLives -= 1;
					       lives.setText("Lives: " + String.valueOf(numLives));
	 
		
	}
}
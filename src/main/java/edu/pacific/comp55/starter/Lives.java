package edu.pacific.comp55.starter;


import java.util.ArrayList;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Lives extends GraphicsProgram {
	GraphicsProgram gamescreenRef;
	int START_X = 10;
	int START_Y = 10;
	private ArrayList<GImage>Lives = new ArrayList<GImage>() {
		{
		add(new GImage("images/lives(test).png", 365, 5));
		add(new GImage("images/lives(test).png", 400, 5));
		add(new GImage("images/lives(test).png", 435, 5));
		}
	};
	Lives(GraphicsProgram Ref) {
		gamescreenRef = Ref;
	}

	public void drawLives() {
		for (GImage life : Lives) {
			gamescreenRef.add(life);
		}
	}
	
	public void deleteImage() {
		int index = Lives.size() - 1;
		gamescreenRef.remove(Lives.get(index));
		Lives.remove(Lives.size()-1);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		//add(livesImage);
	
		
		
	}
	
		  
	
	
}
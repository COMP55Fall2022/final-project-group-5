package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Lives extends GraphicsProgram {
	GraphicsProgram gamescreenRef;
	int START_X = 10;
	int START_Y = 10;
	private int liveCount = 3;
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
		Lives.remove(Lives.size()-1);
	}
	
	static int count(int livesCounter) {
		  livesCounter = livesCounter - 1; 
		  if(livesCounter == -1) {
		    System.out.println("Lost");  
		  }
		  else
		  {
		  System.out.println(livesCounter);
		  }
		  return livesCounter;
		}

	public static void main(String[] args) {
	   
	  //new Lives().start();
	  int livesCounter = 3;  
	  livesCounter=count(livesCounter);
	  livesCounter=count(livesCounter);
	  livesCounter=count(livesCounter);
	  livesCounter=count(livesCounter);
	  
	  }
	
	public void run() {
		// TODO Auto-generated method stub
		//add(livesImage);
	
		
		
	}
	
		  
	
	
}
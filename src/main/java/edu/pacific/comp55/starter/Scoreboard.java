package edu.pacific.comp55.starter;

import acm.program.GraphicsProgram;
import acm.program.*;
import java.awt.Color;
import acm.graphics.*;


public class Scoreboard {
	GraphicsProgram gameScreenRef;
	protected GRect exit;
	
	Scoreboard(GraphicsProgram ref){
		gameScreenRef = ref;
	}
	
	public void Draw() {
		GLabel name = new GLabel("Scoreboard", 168, 130);
		name.setFont("Arial-Bold-30");
		name.setColor(Color.WHITE);
		
		
		GRect popUp = new GRect(98, 70, 300, 330);
		popUp.setColor(Color.BLACK);
		popUp.setFilled(true);
		
		exit = new GRect(103, 75, 33, 33);
		exit.setColor(Color.WHITE);
		
		GLine x1 = new GLine(103, 75, 135, 107);
		x1.setColor(Color.white);
		GLine x2 = new GLine(103, 107, 135, 75);
		x2.setColor(Color.white);
		
		gameScreenRef.add(popUp);
		gameScreenRef.add(name);
		gameScreenRef.add(x1);
		gameScreenRef.add(x2);
		gameScreenRef.add(exit);
	}
	
	public void Exit() {
		gameScreenRef.removeAll();
	}
	
	


}

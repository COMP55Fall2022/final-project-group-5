package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class PauseMenu {
	GraphicsProgram gameScreenRef;
	private GRect resumeBox, exitBox, popUp;
	private GLabel pause, resume, exit;
	private GLine pauseLine;
	private boolean pauseGame = false;
	
	PauseMenu(GraphicsProgram ref){
		gameScreenRef = ref;
	}
	
	public boolean getPause() {
		return pauseGame;
	}
	
	public GRect getResume() {
		return resumeBox;
	}
	
	public GRect getExit() {
		return exitBox;
	}
	
	public void Draw() {
		popUp = new GRect(137, 135, 225, 205);
		popUp.setColor(Color.BLACK);
		popUp.setFilled(true);
		gameScreenRef.add(popUp);
		
		pause = new GLabel("Pause", 206, 170);
		pause.setFont("Arial-Bold-30");
		pause.setColor(Color.WHITE);
		gameScreenRef.add(pause);
		
		resume = new GLabel("Resume", 203, 230);
		resume.setFont("Arial-Bold-25");
		resume.setColor(Color.WHITE);
		gameScreenRef.add(resume);
		
		exit = new GLabel("Exit", 230, 290);
		exit.setFont("Arial-Bold-25");
		exit.setColor(Color.WHITE);
		gameScreenRef.add(exit);
		
		pauseLine = new GLine(215, 175, 283, 175); 
		pauseLine.setColor(Color.white);
		gameScreenRef.add(pauseLine);
		
		resumeBox = new GRect(197, 205, 110, 33);
		resumeBox.setColor(Color.WHITE);
		gameScreenRef.add(resumeBox);
		
		exitBox = new GRect(197, 265, 110, 33);
		exitBox.setColor(Color.WHITE);
		gameScreenRef.add(exitBox);
	}
	
	public void removeDraw() {
		gameScreenRef.remove(popUp);
		gameScreenRef.remove(pause);
		gameScreenRef.remove(resume);
		gameScreenRef.remove(exit);
		gameScreenRef.remove(pauseLine);
		gameScreenRef.remove(resumeBox);
		gameScreenRef.remove(exitBox);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			Draw();
			pauseGame = true;
			System.out.println("pause");
		}
	}
	
	public void mousePressed(MouseEvent e) {
	
	}
}

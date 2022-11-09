package edu.pacific.comp55.starter;

import acm.program.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import acm.graphics.*;

public class gameScreen extends GraphicsProgram{
	
	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;
	
	private GRect start, score;
	
	public Scoreboard scoreboard;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		// all draws
		GImage background = new GImage("media/spaceBackground.jpg");
		background.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		add(background);
		drawMainMenu();
		addKeyListeners();
		addMouseListeners();
	}
	
	private void drawMainMenu() {
		GLabel title = new GLabel("INVADERZ", 150, 150);
		title.setFont("Arial-Bold-40");
		title.setColor(Color.WHITE);
		
		GLabel startGame = new GLabel("Start Game", 185, 215);
		startGame.setFont("Arial-Bold-22");
		startGame.setColor(Color.WHITE);
		add(startGame);
		start = new GRect(176, 187, 140, 40);
		start.setColor(Color.WHITE);
		add(start);
		
		GLabel scoreboard = new GLabel("Scoreboard", 183, 268);
		scoreboard.setFont("Arial-Bold-22");
		scoreboard.setColor(Color.WHITE);
		add(scoreboard);
		score = new GRect(176, 240, 140, 40);
		score.setColor(Color.WHITE);
		add(score);
		
		GImage movement = new GImage("media/movementCTRL.png");
		movement.setLocation(258, 380);
		movement.setSize(65, 50);
		
		GImage fire = new GImage("media/SpaceBar.png");
		fire.setLocation(165, 380);
		fire.setSize(75, 50);
		
		GLabel controls = new GLabel("Controls", 207, 360);
		controls.setFont("Arial-Bold-18");
		controls.setColor(Color.WHITE);
		
		GLabel fireShot = new GLabel("Fire", 190, 450);
		fireShot.setFont("Arial-Bold-15");
		fireShot.setColor(Color.WHITE);
		
		GLabel move = new GLabel("Move", 270, 450);
		move.setFont("Arial-Bold-15");
		move.setColor(Color.WHITE);
		
		add(move);
		add(fireShot);
		add(controls);
		add(fire);
		add(movement);
		add(title);
		
	}
	
	private void drawGame() {
		removeAll();
		GImage background = new GImage("media/spaceBackground.jpg");
		background.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		add(background);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (getElementAt(e.getX(), e.getY()) == start) {
			System.out.println("start");
			drawGame();
		}
		else if (getElementAt(e.getX(), e.getY()) == score) {
			System.out.println("scoreboard");
			//scoreboard.Draw();
		}
		else {
			System.out.println("nothing");
		}
	}
	

	public static void main(String[] args) {
		new gameScreen().start();
	}
}

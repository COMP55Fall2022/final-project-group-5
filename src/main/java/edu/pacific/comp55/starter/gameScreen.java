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

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	
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
		GLabel scoreboard = new GLabel("Scoreboard", 184, 268);
		scoreboard.setFont("Arial-Bold-22");
		scoreboard.setColor(Color.WHITE);
		GImage movement = new GImage("media/movementCTRL.png");
		movement.setLocation(265, 380);
		movement.setSize(65, 50);
		GImage fire = new GImage("media/SpaceBar.png");
		fire.setLocation(160, 380);
		fire.setSize(75, 50);
		GLabel controls = new GLabel("Controls", 207, 355);
		controls.setFont("Arial-Bold-18");
		controls.setColor(Color.WHITE);
		add(controls);
		add(fire);
		add(movement);
		add(title);
		add(startGame);
		add(scoreboard);
	}
	
	

	public static void main(String[] args) {
		new gameScreen().start();
	}
}

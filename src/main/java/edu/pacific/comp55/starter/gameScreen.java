package edu.pacific.comp55.starter;

import acm.program.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.apache.commons.math3.analysis.function.Add;

import acm.graphics.*;

public class gameScreen extends GraphicsProgram{
	
	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;
	public Bomb bomb;
	private GRect start, score;
	public Invaders invaders;
	public Scoreboard scoreboard;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		scoreboard = new Scoreboard(this);
		// all draws
		drawMainMenu();
		addKeyListeners();
		addMouseListeners();
	}
	
	private void addBackground() {
		GImage background = new GImage("media/spaceBackground.jpg");
		background.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		add(background);
	}
	
	private void drawMainMenu() {
		addBackground();
		
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
		movement.setLocation(260, 380);
		movement.setSize(65, 50);
		
		GImage fire = new GImage("media/SpaceBar.png");
		fire.setLocation(167, 380);
		fire.setSize(75, 50);
		
		GLabel controls = new GLabel("Controls", 209, 360);
		controls.setFont("Arial-Bold-18");
		controls.setColor(Color.WHITE);
		
		GLabel fireShot = new GLabel("Fire", 192, 450);
		fireShot.setFont("Arial-Bold-15");
		fireShot.setColor(Color.WHITE);
		
		GLabel move = new GLabel("Move", 272, 450);
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
		addBackground();
		
		GLabel lives = new GLabel("Lives: ", 300, 20); 
		lives.setFont("Arial-Bold-18");
		lives.setColor(Color.WHITE);
		add(lives);
		
		GRect pause = new GRect(17, 6, 30, 16);
		pause.setColor(Color.WHITE);
		add(pause);
		
		GLabel esc = new GLabel("Esc", 18, 20); 
		esc.setFont("Arial-Bold-16");
		esc.setColor(Color.WHITE);
		add(esc);
		
		
		GRect bomb = new GRect(200, 200, 5, 5);
		bomb.setColor(Color.GRAY);
		bomb.setFilled(true);
		add(bomb);
	}
	
	private void drawScoreboard() {
		scoreboard.Draw();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (getElementAt(e.getX(), e.getY()) == start) {
			System.out.println("start");
			drawGame();
		}
		else if (getElementAt(e.getX(), e.getY()) == score) {
			System.out.println("scoreboard");
			drawScoreboard();
		}
		else if (getElementAt(e.getX(), e.getY()) == scoreboard.getExit()) {
			System.out.println("scoreboard exit");
			scoreboard.Exit();
			drawMainMenu();
		}
		else {
			System.out.println("nothing");
		}
	}
	

	public static void main(String[] args) {
		new gameScreen().start();
	}
	}

package edu.pacific.comp55.starter;

import acm.program.*;

import java.awt.Color;


import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.applet.*;
import javax.swing.Timer;

import acm.graphics.*;
import java.awt.event.*;

public class gameScreen extends GraphicsProgram implements ActionListener{
	
	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;
	public Bomb bomb;
	public Lives life;
	private GRect start, score;
	public Invaders invaders;
	public Scoreboard scoreboard;
	private PlayerShip player;
	private PauseMenu pause;
	private Shot shot;
	private int bombT = 0;
	private int bombSPD = 10;
	private boolean gameStarted = false;
	private Timer invadersUpdateTimer;
	private int invadersSpeed = 300;
	//private Timer bombTimer;
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		scoreboard = new Scoreboard(this);
		life = new Lives(this);
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
		
		GRect pauseRect = new GRect(17, 6, 30, 16);
		pauseRect.setColor(Color.WHITE);
		add(pauseRect);
		
		GLabel esc = new GLabel("Esc", 18, 20); 
		esc.setFont("Arial-Bold-16");
		esc.setColor(Color.WHITE);
		add(esc);

		life.drawLives();
		
		player = new PlayerShip(this);
		invaders = new Invaders(this);
		shot = new Shot(this);
		pause = new PauseMenu(this);
		gameStarted = true;
		bomb = new Bomb(this);
		invadersUpdateTimer = new Timer(invadersSpeed, this);
		invadersUpdateTimer.start();
		
		invaders.run();
	}
	
	private void drawScoreboard() {
		scoreboard.Draw();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == invadersUpdateTimer && invadersUpdateTimer.isRunning()) {
			invaders.Move();
			bombT++;
			bomb.actionPerformed(e);
			if (bombT == bombSPD) {
				invaders.setRandInv();
				bomb.addABomb(invaders.getRandX() + 10, invaders.getRandY() + 5);
				bombT = 0;
			}
			if (invaders.getBound()) {
				invadersUpdateTimer.stop();
				invadersSpeed -= 25;
				invadersUpdateTimer = new Timer(invadersSpeed, this);
				bombSPD -= (bombSPD > 0) ? 1 : 0;
				invadersUpdateTimer.start();
			}
			//check shot collision
			
			for (GOval sh :shot.getShots()) {
				Rectangle temp1 = new Rectangle();
				temp1.setBounds((int)sh.getX(), (int)sh.getY(), (int)sh.getWidth(), (int)sh.getHeight());
				//sh.getX(), sh.getY(), sh.getWidth(), sh.getHeight()
				for(GImage inv : invaders.getInvaders()) {
					Rectangle temp2 = new Rectangle();
					temp2.setBounds((int)inv.getX(), (int)inv.getY(), (int)inv.getWidth(), (int)inv.getHeight());
					if (temp1.intersects(temp2) && sh.isVisible() && inv.isVisible()) {
						if (inv.isVisible()) {
							inv.setVisible(false);
							sh.setVisible(false);
						}
					}
				}	
			}
			
			for (GImage inv : invaders.getInvaders()) {
				if (inv.getX() >= player.getX() && inv.getX() <= (player.getX() + 30) && inv.getY() >= player.getY() && inv.getY() <= (player.getY() + 23) && inv.isVisible()) { 
					player.damaged(true);
				}
			}
			}
/*
			if (invaders.checkCollisions()) {
				// game over screen
			}*/
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (!gameStarted) {
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
		else {
			if (getElementAt(e.getX(), e.getY()) == pause.getExit()) {
				pause.removeDraw();
				player = null;
				invaders = null;
				shot = null;
				pause = null;
				bomb = null;
				invadersUpdateTimer = null;
				gameStarted = false;
				drawMainMenu();
			}
			else if (getElementAt(e.getX(), e.getY()) == pause.getResume()) {
				pause.removeDraw();
				invadersUpdateTimer.start();
				bomb.resumeBomb();
				pause.setPause();
			}
			else {
				System.out.println("nothing");
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (gameStarted && invadersUpdateTimer.isRunning()) {
			player.keyPressed(e);
			if (pause.keyPressed(e)) {
				invadersUpdateTimer.stop();
				bomb.pauseBomb();
			}
			if (shot != null) {
				if (key == KeyEvent.VK_SPACE) {
					shot.addAShot(player.getX() + 19, player.getY() - 5);
				}
			}
		}
	}	

	public static void main(String[] args) {
		new gameScreen().start();
	}
	}

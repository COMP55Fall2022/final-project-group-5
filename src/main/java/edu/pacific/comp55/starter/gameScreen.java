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

public class gameScreen extends GraphicsProgram implements ActionListener {

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
	private Boss boss;
	private int bombT = 0;
	private int bombSPD = 10;
	private boolean gameStarted = false;
	private boolean invDestroyed;
	private boolean mm;
	private Timer invadersUpdateTimer;
	private int invadersSpeed = 300;
	private int numLives = 0;
	private long elapseTime;
	AudioPlayer audio;
	private String currentMusic;
	private GRect resumeBox, exitBox, popUp;
	//private Timer bombTimer;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		scoreboard = new Scoreboard(this);
		life = new Lives(this);
		// all draws
		drawWin();
		//drawMainMenu();
		addKeyListeners();
		addMouseListeners();
	}

	private void addBackground() {
		GImage background = new GImage("media/spaceBackground.jpg");
		background.setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		add(background);
	}
	
	private void drawWin() {
		addBackground();
		mm = false;
		//popUp = new GRect(137, 135, 225, 205);
		//popUp.setColor(Color.BLACK);
		//popUp.setFilled(true);
		//add(popUp);
		
		GLabel win = new GLabel("Congragulation!", 134, 170);
		win.setFont("Arial-Bold-30");
		win.setColor(Color.WHITE);
		add(win);
		
		GLabel stringWin = new GLabel("For your attempt at", 134, 200);
		stringWin.setFont("Arial-Bold-26");
		stringWin.setColor(Color.WHITE);
		add(stringWin);
		
		GLabel stringWin2 = new GLabel("ABORTION!", 180, 230);
		stringWin2.setFont("Arial-Bold-26");
		stringWin2.setColor(Color.WHITE);
		add(stringWin2);
		
		elapseTime = 200;
		
		int S = (int) (elapseTime % 60);
        int H = (int) (elapseTime / 60);
        int M = H % 60;
		
		
		GLabel recordString = new GLabel("RECORD:" , 193, 300);
		recordString.setFont("Arial-Bold-26");
		recordString.setColor(Color.WHITE);
		add(recordString);
		
		GLabel record = new GLabel(M + ":" + S, 223, 340);
		record.setFont("Arial-Bold-26");
		record.setColor(Color.WHITE);
		add(record);
		
		
		//elapseTime
	}

	private void drawMainMenu() {
		addBackground();
		
		mm = true;
		
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
		audio = AudioPlayer.getInstance();
		audio.playSound("sounds", "Invaders_Background.mp3", true);
		currentMusic = "Invaders_Background.mp3";
		
		removeAll();
		mm = false;
		addBackground();
		
		//fireRate = 100;
		numLives = 3;

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
		
		elapseTime = 0;

		life.drawLives();
		invDestroyed = false;
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
		if (e.getSource() == invadersUpdateTimer && invadersUpdateTimer.isRunning()) {
			elapseTime++;
			if (shot.getFireRate() < 3) {
				shot.incrementRate();
			}
			if (invDestroyed == false) {
				invPerform(e);
			} else {
				bossPerform(e);
			}
		}
	}
	/*
	 * if (invaders.checkCollisions()) { // game over screen }
	 */

	public void bossLVL() {
		audio = AudioPlayer.getInstance();
		audio.stopSound("sounds", "Invaders_Background.mp3");
		audio.playSound("sounds", "boss_music.mp3", true);
		currentMusic = "boss_music.mp3";
		boss = new Boss(this);
		invadersUpdateTimer = new Timer(boss.getInvadersSpeed(), this);
		invadersUpdateTimer.start();
	}

	public void bossPerform(ActionEvent e) {
		if (boss.isBossDead()) {
			audio.stopSound("sounds", currentMusic);
			player = null;
			boss = null;
			shot = null;
			pause = null;
			bomb = null;
			invadersUpdateTimer = null;
			gameStarted = false;
			drawWin();
			return;
		} else {
			if (player.isVisible() == false) {
				player.revive();
			}
			boss.moveBoss();
			bombT++;
			bomb.actionPerformed(e);
			if (bombT == bombSPD) {
				bomb.addABomb(boss.getX() + 10, boss.getY() + 5);
				bombT = 0;
			}
			for (GOval sh : shot.getShots()) {
				Rectangle temp1 = new Rectangle();
				temp1.setBounds((int) sh.getX(), (int) sh.getY(), (int) sh.getWidth() + 5, (int) sh.getHeight() + 5);
				Rectangle temp2 = new Rectangle();
				temp2.setBounds((int) boss.getX(), (int) boss.getY(), (int) boss.getWidth() + 10,
						(int) boss.getHeight() + 10);
				if (temp1.intersects(temp2) && sh.isVisible() && boss.isVisible()) {
					if (boss.isVisible()) {
						boss.minusNumLives();
						if (boss.getNumLives() == 1) {
							audio = AudioPlayer.getInstance();
							audio.stopSound("sounds", "boss_music.mp3");
							audio.playSound("sounds", "Boss_final_form.mp3", true);
							currentMusic = "Boss_final_form.mp3";
						}
						boss.setImage(true);
						sh.setVisible(false);
					}
				}
			}
			for (GRect b : bomb.getBombs()) {
				Rectangle temp1 = new Rectangle();
				temp1.setBounds((int) b.getX(), (int) b.getY(), (int) b.getWidth(), (int) b.getHeight());
				Rectangle temp2 = new Rectangle();
				temp2.setBounds((int) player.getX(), (int) player.getY(), player.getW(), player.getH());
				if (temp1.intersects(temp2) && player.isVisible() && b.isVisible()) {
					numLives--;
					player.damaged(true, numLives);
					life.deleteImage();
					audio = AudioPlayer.getInstance();
					audio.playSound("sounds", "explosion.mp3", false);
					b.setVisible(false);
					if (numLives == 0) {
						player = null;
						invaders = null;
						shot = null;
						pause = null;
						bomb = null;
						invadersUpdateTimer = null;
						gameStarted = false;
						audio.stopSound("sounds", currentMusic);
						drawMainMenu();
						return;
					}
				}
			}
		}
	}

	public void invPerform(ActionEvent e) {
		if (invaders.getDeaths()) {
			// player = null;
			invaders = null;
			// shot = null;
			// pause = null;
			// bomb = null;
			invDestroyed = true;
			invadersUpdateTimer = null;
			// gameStarted = false;
			bossLVL();
			return;
		} else {
			if (player.isVisible() == false) {
				player.revive();
			}
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

			// check shot collision

			for (GOval sh : shot.getShots()) {
				Rectangle temp1 = new Rectangle();
				temp1.setBounds((int) sh.getX(), (int) sh.getY(), (int) sh.getWidth() + 10, (int) sh.getHeight() + 5);
				for (GImage inv : invaders.getInvaders()) {
					Rectangle temp2 = new Rectangle();
					temp2.setBounds((int) inv.getX(), (int) inv.getY(), (int) inv.getWidth() + 10,
							(int) inv.getHeight() + 10);
					if (temp1.intersects(temp2) && sh.isVisible() && inv.isVisible()) {
						if (inv.isVisible()) {
							invaders.incrementDeaths();
							inv.setVisible(false);
							sh.setVisible(false);
						}
					}
				}
			}

			for (GRect bomb : bomb.getBombs()) {
				Rectangle temp1 = new Rectangle();
				temp1.setBounds((int) bomb.getX(), (int) bomb.getY(), (int) bomb.getWidth(), (int) bomb.getHeight());
				Rectangle temp2 = new Rectangle();
				temp2.setBounds((int) player.getX(), (int) player.getY(), player.getW(), player.getH());
				if (temp1.intersects(temp2) && player.isVisible() && bomb.isVisible()) {
					numLives--;
					player.damaged(true, numLives);
					life.deleteImage();
					bomb.setVisible(false);
					audio = AudioPlayer.getInstance();
					audio.playSound("sounds", "explosion.mp3", false);
					if (numLives == 0) {
						player = null;
						invaders = null;
						shot = null;
						pause = null;
						bomb = null;
						invadersUpdateTimer = null;
						gameStarted = false;
						audio.stopSound("sounds", currentMusic);
						drawMainMenu();
						return;
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!gameStarted) {
			if (getElementAt(e.getX(), e.getY()) == start) {
				System.out.println("start");
				drawGame();
			} else if (getElementAt(e.getX(), e.getY()) == score) {
				System.out.println("scoreboard");
				drawScoreboard();
			} else if (getElementAt(e.getX(), e.getY()) == scoreboard.getExit()) {
				System.out.println("scoreboard exit");
				scoreboard.Exit();
				drawMainMenu();
			} else {
				System.out.println("nothing");
			}
		} else {
			if (getElementAt(e.getX(), e.getY()) == pause.getExit()) {
				pause.removeDraw();
				player = null;
				invaders = null;
				shot = null;
				pause = null;
				bomb = null;
				invadersUpdateTimer = null;
				gameStarted = false;
				audio = AudioPlayer.getInstance();
				audio.stopSound("sounds", currentMusic);
				drawMainMenu();
			} else if (getElementAt(e.getX(), e.getY()) == pause.getResume()) {
				pause.removeDraw();
				invadersUpdateTimer.start();
				bomb.resumeBomb();
				pause.setPause();
			} else {
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
		if (gameStarted == false && mm == false) {
			if (key == KeyEvent.VK_SPACE) {
				drawMainMenu();
			}
		}
	}

	public static void main(String[] args) {
		new gameScreen().start();
	}
}

package edu.pacific.comp55.starter;

import acm.program.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.applet.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import acm.graphics.*;
import java.awt.event.*;

public class gameScreen extends GraphicsProgram implements ActionListener {

	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;
	
	private Bomb bomb;
	private Lives life;
	private GRect start, score;
	private Invaders invaders;
	private Scoreboard scoreboard;
	private PlayerShip player;
	private PauseMenu pause;
	private Shot shot;
	private Boss boss;
	AudioPlayer audio;

	
	private int bombT, bombSPD, scareSec, invadersSpeed;
	private int numLives = 0;
	
	private boolean gameStarted = false;
	private boolean invDestroyed, scareOn, mm;
	
	private Timer invadersUpdateTimer, jumpScareT;
	
	private long elapseTime;
	
	private String currentMusic;
	private GImage scareImg;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}

	public void run() {
		scoreboard = new Scoreboard(this);
		drawMainMenu();
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
		
		GLabel win = new GLabel("Congragulation!", 134, 170);
		win.setFont("Arial-Bold-30");
		win.setColor(Color.WHITE);
		add(win);
		
		int S = (int) (elapseTime % 60);
        int H = (int) (elapseTime / 60);
        int M = H % 60;
		
		
		GLabel recordString = new GLabel("RECORD:" , 193, 230);
		recordString.setFont("Arial-Bold-26");
		recordString.setColor(Color.WHITE);
		add(recordString);
		
		GLabel record = new GLabel(M + ":" + S, 223, 260);
		record.setFont("Arial-Bold-26");
		record.setColor(Color.WHITE);
		add(record);
		
		GLabel recordName = new GLabel("Please enter a name for record" , 91, 320);
		recordName.setFont("Arial-Bold-22");
		recordName.setColor(Color.WHITE);
		add(recordName);
		
		GLabel max = new GLabel("(Max: 4 CHAR)" , 175, 350);
		max.setFont("Arial-Bold-22");
		max.setColor(Color.WHITE);
		add(max);
		
		String name = JOptionPane.showInputDialog(null, "Please enter a name here:");
			
		scoreboard.setRanks(elapseTime, name);
		
		
		//elapseTime
	}

	private void drawMainMenu() {
		addBackground();
		
		scareOn = false;
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
		bombSPD = 6;
		bombT = 0;
		invadersSpeed = 200;
		life = new Lives(this);
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
			if (shot.getFireRate() < 2) {
				shot.incrementRate();
			}
			if (invDestroyed == false) {
				invPerform(e);
			} else {
				bossPerform(e);
			}
		}
		if (e.getSource() == jumpScareT && jumpScareT.isRunning()) {
			scareSec++;
			if ((scareSec % 2) == 0) {
				remove(scareImg);
				scareImg = new GImage("media/scary image 2.PNG", 0, 0);
				add(scareImg);
			}
			else {
				remove(scareImg);
				scareImg = new GImage("media/scary image 1.PNG", 0, 0);
				add(scareImg);
			}
		}
	}

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
			life = null;
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
						life = null;
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
			invaders = null;
			invDestroyed = true;
			invadersUpdateTimer = null;
			bossLVL();
			return;
		} else {
			if (player.isVisible() == false) {
				player.revive();
			}
			invaders.Move();
			for (GImage inv : invaders.getInvaders()) {
				if (inv.isVisible() && inv.getY() >= 410) {
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
			bombT++;
			bomb.actionPerformed(e);
			if (bombT == bombSPD) {
				invaders.setRandInv();
				bomb.addABomb(invaders.getRandX() + 10, invaders.getRandY() + 5);
				bombT = 0;
			}
			if (invaders.getBound()) {
				invadersUpdateTimer.stop();
				if (invadersSpeed > 30) {
					invadersSpeed -= 13;
				}
				invadersUpdateTimer = new Timer(invadersSpeed, this);
				bombSPD -= (bombSPD > 1) ? 1 : 0;
				bombT = 0;
				invadersUpdateTimer.start();
			}


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
			
			for (GOval sh : shot.getShots()) {
				Rectangle temp1 = new Rectangle();
				temp1.setBounds((int) sh.getX(), (int) sh.getY(), (int) sh.getWidth() + 40, (int) sh.getHeight() + 20);
				for (GRect bomb : bomb.getBombs()) {
					Rectangle temp2 = new Rectangle();
					temp2.setBounds((int) bomb.getX(), (int) bomb.getY(), (int) bomb.getWidth() + 15, (int) bomb.getHeight() + 5);
					if (temp1.intersects(temp2)) {
						if (bomb.isVisible() && sh.isVisible()) {
							sh.setVisible(false);
							bomb.setVisible(false);
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
						//drawMainMenu();
						jumpScare();
						return;
					}
				}
			}
		}
	}

	public void jumpScare() {
		setSize(1002, 797);
		scareSec = 0;
		audio = AudioPlayer.getInstance();
		audio.playSound("sounds", "scary sound.mp3", true);
		scareImg = new GImage("media/scary image 2.PNG", 0, 0);
		add(scareImg);
		jumpScareT = new Timer(80, this);
		scareOn = true;
		jumpScareT.start();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (!gameStarted) {
			if (getElementAt(e.getX(), e.getY()) == start) {
				drawGame();
			} else if (getElementAt(e.getX(), e.getY()) == score) {
				drawScoreboard();
			} else if (getElementAt(e.getX(), e.getY()) == scoreboard.getExit()) {
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
				life = null;
				gameStarted = false;
				audio = AudioPlayer.getInstance();
				audio.stopSound("sounds", currentMusic);
				drawMainMenu();
			} else if (getElementAt(e.getX(), e.getY()) == pause.getResume()) {
				pause.removeDraw();
				invadersUpdateTimer.start();
				bomb.resumeBomb();
				pause.setPause();
				shot.resumeShots();
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
				shot.stopShots();
			}
			if (shot != null) {
				if (key == KeyEvent.VK_SPACE) {
					shot.addAShot(player.getX() + 19, player.getY() - 5);
				}
			}
		}
		if (gameStarted == false && mm == false) {
			if (key == KeyEvent.VK_W) {
				jumpScare();
			}
		}
		if (scareOn == true && jumpScareT.isRunning()) {
			if (key == KeyEvent.VK_ESCAPE) {
				audio = AudioPlayer.getInstance();
				audio.stopSound("sounds", "scary sound.mp3");
				jumpScareT.stop();
				jumpScareT = null;
				remove(scareImg);
				setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
				drawMainMenu();
			}
		}
	}

	public static void main(String[] args) {
		new gameScreen().start();
	}
}

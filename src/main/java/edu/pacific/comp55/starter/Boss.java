package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;



public class Boss {
	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;
	private static final int boss1Size = 125;
	private static final int boss2Size = 84;
	private static final int boss3Size = 43;
	int x;
	int y;
	int start_x = 250;
	int start_y = 250;
	private Timer invadersUpdateTimer;
	private int invadersSpeed = 100;
	private int numLives;
	
	public int getNumLives() {
		return numLives;
	}

	public int getInvadersSpeed() {
		return invadersSpeed;
	}

	public void setInvadersSpeed(int invadersSpeed) {
		this.invadersSpeed = invadersSpeed;
	}

	private boolean bossDead = false;
	GRect Boss;
	GraphicsProgram gameScr; 
	
	public Boss(GraphicsProgram screen) {
		gameScr = screen;
		run();
	}
	
	public boolean isBossDead() {
		return bossDead;
	}

	//@Override
	public void run() {
		Boss = new GRect(start_x, start_y, boss1Size, boss1Size);
		Boss.setColor(Color.WHITE);
		Boss.setFilled(true);
		numLives = 3;
		gameScr.add(Boss);
		//invadersUpdateTimer = new Timer(invadersSpeed, this);
		//invadersUpdateTimer.start();
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == invadersUpdateTimer) {
			moveBoss();
		}
	}
	*/
	public void minusNumLives() {
		numLives--;
		if (numLives == 0) {
			bossDead = true;
		}
	}
	
	public void moveBoss() {
		var generator = new Random();
		double dx = generator.nextInt((360-10))+10;
		double dy = generator.nextInt(250);
		setX((int) dx);
		setY((int) dy);
		Boss.setLocation(dx, dy);
	}
	
	public void setImage(boolean damaged) {
		if (damaged) {
			if (numLives == 2) {
				Boss.setSize(boss2Size, boss2Size);
			}
			else if (numLives == 1) {
				Boss.setSize(boss3Size, boss3Size);
			}
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return Boss.isVisible();
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return (int) Boss.getWidth();
	}
	
	public int getHeight() {
		// TODO Auto-generated method stub
		return (int) Boss.getHeight();
	}
	}
	
//audio.playSound("src/main/resources" , "bossSound.mp3");
//public void playSound(String sounds, String bossSound.mp3) {
//	playSound(sounds, filename, bossSound.mp3);
//}
	
	
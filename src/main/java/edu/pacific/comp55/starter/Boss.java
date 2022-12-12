package edu.pacific.comp55.starter;

import java.awt.Color;
import java.util.Random;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;



public class Boss {
	int x;
	int y;
	int start_x = 250;
	int start_y = 250;
	private int invadersSpeed = 100;
	private int numLives;
	private boolean bossDead = false;
	GImage Boss;
	GraphicsProgram gameScr; 
	
	public Boss(GraphicsProgram screen) {
		gameScr = screen;
		run();
	}
	
	public boolean isBossDead() {
		return bossDead;
	}

	public void run() {
		Boss = new GImage("media/boss.png", start_x, start_y);
		Boss.setColor(Color.WHITE);
		numLives = 3;
		gameScr.add(Boss);
	}
	
	public int getNumLives() {
		return numLives;
	}

	public int getInvadersSpeed() {
		return invadersSpeed;
	}

	public void setInvadersSpeed(int invadersSpeed) {
		this.invadersSpeed = invadersSpeed;
	}
	
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
				gameScr.remove(Boss);
				Boss = new GImage("media/IMG_0668 Background Removed.png", getX(), getY());
				gameScr.add(Boss);
			}
			else if (numLives == 1) {
				gameScr.remove(Boss);
				Boss = new GImage("media/smaller fetus.png", getX(), getY());
				gameScr.add(Boss);
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
		return (int) Boss.getWidth();
	}
	
	public int getHeight() {
		return (int) Boss.getHeight();
	}
	}
	

	
	
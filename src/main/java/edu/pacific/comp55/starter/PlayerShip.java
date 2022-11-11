package edu.pacific.comp55.starter;
import acm.graphics.*;

import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerShip extends GraphicsProgram {
	private Shot shot;
	private int lives;
	int k;
	int x;
	int y;
	int START_X = 200;
	int START_Y = 200;
	GObject playerShip = new GImage("images/playerShip.png", START_X, START_Y);
	
	
	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	public PlayerShip () {
		initPlayerShip();
	}
	
	public void initPlayerShip() {
		setX(START_X);
		setY(START_Y);
	}
	
	public void run() {
		add(playerShip);
		addKeyListeners();
	}
	
	public void move() {
		x += k;
		
		if (x <= 2) {
			x = 2;
		}
		
		if (x >= gameScreen.PROG_WIDTH - 2 * 500) {
			x = gameScreen.PROG_WIDTH - 2 * 500;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			k = -2;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			k = 2;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			k = 0;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			k = 0;
		}
	}
	
	public void revive() { 
		
	}
	
	public void pause() { //connect to the pause button
		
	}
	
	public void resume() { //connect to resume button
		
	}
	
	public void damaged() { 
		
	}
	
	public static void main(String[] args) {
		new PlayerShip().start();
	}
}

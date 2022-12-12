package edu.pacific.comp55.starter;

import acm.graphics.*;
import acm.program.*;
import java.awt.event.KeyEvent;


public class PlayerShip {
	boolean damaged = false;
	int x;
	int y;
	int START_X = 230;
	int START_Y = 420;
	GImage explosion;
	GObject playerShip; //= new GImage("images/playerShip4.png", START_X, START_Y);
	GraphicsProgram gameScr; 
	
	public PlayerShip(GraphicsProgram screen) {
		gameScr = screen;
		playerShip = new GImage("images/playerShip4.png", START_X, START_Y);
		gameScr.add(playerShip);
	}
	
	
	
	public double getX() {
		return playerShip.getX();
	}
	
	public double getY() {
		return playerShip.getY();
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT && playerShip.getX() > 0) {
			playerShip.move(-5, 0);
		}
		
		if (key == KeyEvent.VK_RIGHT && playerShip.getX()+playerShip.getWidth() + 15 < gameScr.getWidth()) {
			playerShip.move(5, 0);
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			playerShip.move(0, 0);
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			playerShip.move(0, 0);
		}
	}
	
	public void revive() { 
		gameScr.remove(explosion);
		playerShip.setVisible(true);
	}
	
	public void damaged(boolean damaged, int lives) { 
		if (damaged) {
			explosion = new GImage("ship_exp.png", playerShip.getX(), playerShip.getY());
			playerShip.setVisible(false);
			gameScr.add(explosion);
		}
	}

	public boolean isVisible() {
		return playerShip.isVisible();
	}
	
	public int getH() {
		return (int) playerShip.getHeight();
	}
	
	public int getW() {
		return (int) playerShip.getWidth();
	}
	
}


package edu.pacific.comp55.starter;
import acm.graphics.*;

import acm.program.*;
import java.awt.event.KeyEvent;

import javax.swing.Timer;


public class PlayerShip {
	private Lives life;
	private Bomb bomb;
	boolean damaged;
	int x;
	int y;
	int START_X = 230;
	int START_Y = 420;
	private Timer t;
	GObject playerShip = new GImage("images/playerShip4.png", START_X, START_Y);
	GraphicsProgram gameScr; 
	
	public PlayerShip(GraphicsProgram screen) {
		gameScr = screen;
		gameScr.add(playerShip);
	}
	
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
	
	public double getX() {
		return playerShip.getX();
	}
	
	public double getY() {
		return playerShip.getY();
	}
	
	public void run() {
		gameScr.add(playerShip);
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
		playerShip.setVisible(true);
	}
	
	public void damaged() { 
		if (bomb.checkHitShip() == true) { 
			damaged = true;
			life.deleteImage();
		}

		if (damaged = true) {
			playerShip.setVisible(false);
		}
	}
	
}

package edu.pacific.comp55.starter;
import acm.graphics.*;

import acm.program.*;
import java.awt.event.KeyEvent;

public class PlayerShip extends GraphicsProgram {
	private Shot shot;
	private int lives;
	int x;
	int y;
	int START_X = 350;
	int START_Y = 450;
	GObject playerShip = new GImage("images/playerShip1.png", START_X, START_Y);
	
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
		add(playerShip);
		
		addKeyListeners();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			playerShip.move(-75, 0);
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			playerShip.move(75, 0);
		}
		
		if (key == KeyEvent.VK_ESCAPE) {
			//connect to pause menu once pause menu created
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			playerShip.move(0, 0);;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			playerShip.move(0, 0);;
		}
	}
	
	public void revive() { 
		
	}
	
	public void pause() { 
		
	}
	
	public void resume() { //connect to resume button
		
	}
	
	public void damaged() { 
		
	}
	
	public static void main(String[] args) {
		new PlayerShip().start();
	}
}

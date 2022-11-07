package edu.pacific.comp55.starter;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerShip  {
	private Shot shot;
	private int lives;
	int k;
	GObject player;
	int START_X = 200;
	int START_Y = 200;
	
	public PlayerShip () {
		initPlayerShip();
	}
	
	public void initPlayerShip() {
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			k = -2;
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			k = 2;
		}
	}
	
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
}

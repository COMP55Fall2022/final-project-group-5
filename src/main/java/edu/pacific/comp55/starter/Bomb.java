package edu.pacific.comp55.starter;

import java.awt.Color;

import acm.graphics.GRect;

public class Bomb {

	private int x;
	private int y;
	private boolean destroyed;
	public Bomb(int x, int y) {
		 initBomb(x , y);
	}
	private void initBomb(int x, int y) {
		this.x = x;
		this.y = y;
		invaders(true);
		GRect bomb = new GRect(10, 20, 40, 40);
		bomb.setColor(Color.GRAY);
		
	}
	private void invaders(boolean destroyed) {
		this.destroyed = destroyed;
	}
		public boolean isDestroyed() {
			return destroyed;
		}
		
	}



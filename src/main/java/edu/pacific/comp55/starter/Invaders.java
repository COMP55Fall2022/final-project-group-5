package edu.pacific.comp55.starter;

import acm.graphics.GImage;


public class Invaders {
	private Bomb bomb;
	private int x;
	private int y;
	public Invaders(int x, int y) {
		initInvaders(x, y);
	}
	private void initInvaders(int x, int y) {
		this.x = x;
		this.y = y;
		
		GImage invaders = new GImage("media/invaders.png");
		bomb = new Bomb(x, y);
	}
	public void act(int direction) {
		this.x += direction;
	}
	public Bomb getBomb() {
		return bomb;
	}
}
		




package edu.pacific.comp55.starter;

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
		
		bomb = new Bomb(x, y);
		
	}
}


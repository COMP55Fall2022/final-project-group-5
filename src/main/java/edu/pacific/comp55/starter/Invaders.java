package edu.pacific.comp55.starter;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;


public class Invaders extends GraphicsProgram {
	private Bomb bomb;
	private int x;
	private int y;
	GObject invaders = new GImage("media/invaders(test).PNG");
	public Invaders() {
		initInvaders(x, y);
	}
	private void initInvaders(int x, int y) {
		this.x = x;
		this.y = y;
		bomb = new Bomb(x, y);
	}
	public void act(int direction) {
		this.x += direction;
	}
	public Bomb getBomb() {
		return bomb;	}
	
	@Override
	public void run() {
		add(invaders);
		
	}
	public static void main (String[] args) {
		new Invaders().start();
	}
}
		




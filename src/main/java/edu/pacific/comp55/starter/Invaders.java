package edu.pacific.comp55.starter;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;


public class Invaders {
	private Bomb bomb;
	int x;
	int y;
	int start_x = 50;
	int start_y = 50;
	GObject invaders = new GImage("media/new invaders resize.PNG", start_x, start_y);
	GraphicsProgram gameScr; 
	
	public Invaders(GraphicsProgram screen) {
		gameScr = screen;
		gameScr.add(invaders);
	}
	
	public Invaders() {
		initInvaders();
	}
	private void initInvaders() {
		setX(start_x);
		setY(start_y);
		//bomb = new Bomb(x, y);
	}
	private void setX(int x) {
		this.x = x;
	}
	private void setY(int y) {
		this.y = y;
	}
	
	public double getX() {
		return invaders.getX();
	}
	
	public double getY() {
		return invaders.getY();
	}
	
	public Bomb getBomb() {
		return bomb;	
		}
	
	public void run() {
		gameScr.add(invaders);
	}
}
		
	//comment




package edu.pacific.comp55.starter;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;


public class Boss {
	private Bomb bomb;
	int x;
	int y;
	int start_x = 50;
	int start_y = 50;
	GObject Boss = new GImage("media/new invaders boss2.png", start_x, start_y);
	GraphicsProgram gameScr; 
	public Boss(GraphicsProgram screen) {
		gameScr = screen;
		gameScr.add(Boss);
	}
	
	public Boss() {
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
		return Boss.getX();
	}
	
	public double getY() {
		return Boss.getY();
	}
	
	public Bomb getBomb() {
		return bomb;	
		}
	
	public void run() {
		gameScr.add(Boss);
	}
}
	
		
	




package edu.pacific.comp55.starter;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;


public class Invaders {
	private static final int MOVE_RANGE = 32;
	private Bomb bomb;
	int x;
	int y;
	int start_x = 0;
	int start_y = 50;
	int moveRange = MOVE_RANGE;
	boolean reachedBound = false;
	ArrayList<GImage> invaders;
	//GObject invaders = new GImage("media/new invaders resize.PNG", start_x, start_y);
	GraphicsProgram gameScr; 
	
	public Invaders(GraphicsProgram screen) {
		gameScr = screen;
		invaders = new ArrayList<GImage>();
	}
	
	public void run() {
		initInvaders();
		for (GObject invader : invaders) {
			System.out.println("add");
			gameScr.add(invader);
		}
	}
	
	private void initInvaders() {
		System.out.println("create");
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				invaders.add(new GImage("media/new invaders resize.PNG", start_x + (i*50), start_y + (j*50)));
			}
		}
		//bomb = new Bomb(x, y);
	}
	
	public void Move() {
		
		int dx = (moveRange > 1) ? 5 : -5;
		int dy = (moveRange == 2 || moveRange == -2) ? 20 : 0;
		
		moveRange += (moveRange > 1) ? -1 : 1;
		
		if (moveRange == 1) {
			moveRange = -1 * MOVE_RANGE;
			reachedBound = true;
		} else 
		if (moveRange == -1) {
			moveRange = MOVE_RANGE;
			reachedBound = true;
		} else {
			reachedBound = false;
		}
		
		for(GObject inv: invaders) {
			inv.move(dx, dy);
		}
	}
	
	public boolean getBound() {
		return reachedBound;
	}
	private void setX(int x) {
		this.x = x;
	}
	private void setY(int y) {
		this.y = y;
	}
	
	public double getX() {
		return 0; //invader.getX();
	}
	
	public double getY() {
		return 0;//invader.getY();
	}
	
	public Bomb getBomb() {
		return bomb;	
		}
}
		
	//comment




package edu.pacific.comp55.starter;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;


public class Invaders {
	private static final int MOVE_RANGE = 32;
	int x;
	int y;
	int start_x = 0;
	int start_y = 50;
	double invX, invY;
	private int deaths = 0;
	
	public boolean getDeaths() {
		if (deaths == 21) {
			return true;
		}
		else {
			return false;
		}
	}

	public void incrementDeaths() {
		deaths++;
	}

	int moveRange = MOVE_RANGE;
	double randX = 0;
	double randY = 0;
	boolean reachedBound = false;
	ArrayList<GImage> invaders;
	
	public ArrayList<GImage> getInvaders() {
		return invaders;
	}

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
				setX(start_x + (i*50));
				setY(start_y + (j*50));
			}
		}
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
		
		for (GObject inv: invaders) {
			inv.move(dx, dy);
			setX(dx);
			setY(dy);
		}
	}
	
	
	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return x;
	}
	
	public void setRandInv() {
		var generator = new Random();
		boolean visible = false;
		int index = generator.nextInt(invaders.size());
		while (!visible) {
			if (invaders.get(index).isVisible()) {
				visible = true;
				break;
			}
			index = generator.nextInt(invaders.size());
		}
		this.randX = invaders.get(index).getX();
		this.randY = invaders.get(index).getY();
	}
	
	public double getRandX() {
		return randX;
	}
	
	public double getRandY() {
		return randY;
	}
	
	public boolean getBound() {
		return reachedBound;
	}

	
	public void removeInv(double x, double y) {
		for (int i = 0; i < invaders.size(); i++) {
			if (invaders.get(i).getX() == x && invaders.get(i).getY() == y && invaders.get(i).isVisible()) {
				gameScr.remove(invaders.get(i));
				invaders.remove(i);
				System.out.println("delete");
				return;
			}
		}
	}

	public boolean checkCollisions() {
		for (GImage inv : getInvaders()) {
			if (inv.getY() == 420) {
				return true;
			}
		}
		return false;
	}}

	//comment
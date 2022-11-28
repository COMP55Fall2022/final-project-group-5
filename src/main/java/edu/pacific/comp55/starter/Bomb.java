package edu.pacific.comp55.starter;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Bomb extends GraphicsProgram {
	private int x;
	private int y;
	private boolean destroyed;
	GRect bomb = new GRect(10, 20, 40, 40);
	

	
	
	public Bomb(int x2, int y2) {
		initBomb(x, y);
	
	}

	public Bomb() {
		
	}

	private void initBomb(int x, int y) {
		this.x = x;
		this.y = y;
		Invaders(true);
		bomb.setColor(Color.GRAY);
		bomb.setFilled(true);
	}
	private void Invaders(boolean destroyed) {
		this.destroyed = destroyed;
	}
		public boolean isDestroyed() {
			return destroyed;
		}

		public void run() {
			add(bomb);
			
		}
		public static void main(String[] args) {
			new Bomb().start();
		}
		
	}

//comment

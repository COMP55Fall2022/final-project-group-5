package edu.pacific.comp55.starter;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Bomb extends GraphicsProgram {
	private int x;
	private int y;
	private boolean destroyed;
	GRect bomb = new GRect(63, 75, 3, 10);
	GraphicsProgram gameScr; 
	public Bomb(GraphicsProgram screen) {
		gameScr = screen;
	}

	public void createBomb(int x2, int y2) {
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
		gameScr.add(bomb);
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

		public boolean checkHitShip() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

//comment

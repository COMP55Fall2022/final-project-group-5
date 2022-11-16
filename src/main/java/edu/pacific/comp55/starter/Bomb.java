package edu.pacific.comp55.starter;

import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Bomb {
	GraphicsProgram gameScreenRef;
	private int x;
	private int y;
	private boolean destroyed;
	public Bomb(GraphicsProgram ref){
		gameScreenRef = ref;
	}
	public Bomb(int x, int y) {
		 initBomb(x , y);
	}
	
	private void initBomb(int x, int y) {
		this.x = x;
		this.y = y;
		Invaders(true);
		GRect bomb = new GRect(10, 20, 40, 40);
		bomb.setColor(Color.GRAY);
		bomb.setFilled(true);
		
		
	}
	private void Invaders(boolean destroyed) {
		this.destroyed = destroyed;
	}
		public boolean isDestroyed() {
			return destroyed;
		}
		
	}



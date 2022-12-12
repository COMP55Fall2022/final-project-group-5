package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Bomb extends GraphicsProgram  {
	public static final int SIZE = 30;
	public static final int MS = 50;
	public static final double SPEED = 1;
	private ArrayList <GRect> bombs;
	public static Timer t;
	GraphicsProgram gameScr; 
	public Bomb(GraphicsProgram screen) {
		gameScr = screen;
		run();
	}
	
	public void run() {
		bombs = new ArrayList<GRect>();
		t = new Timer(10, this);
		t.start();
	}
	
	public ArrayList<GRect> getBombs() {
		return bombs;
	}
	
	public void addABomb(double x, double y) {
		GRect bomb = makeBomb(x, y);
		gameScr.add(bomb);
		bombs.add(bomb);
	}
	
	public GRect makeBomb(double x, double y) {
		GRect temp = new GRect(x, y, 3, 10);
		temp.setColor(Color.GRAY);
		temp.setFilled(true);
		return temp;
	}
	
	public void actionPerformed(ActionEvent e) {
		moveAllBombsOnce();
	}
	
	private void moveAllBombsOnce() {
		for(GRect bomb: bombs) {
			bomb.move(0, SPEED);
		}
	}
	
	public int getArrSize() {
		return bombs.size();
	}
	
	public void pauseBomb() {
		t.stop();
	}
	
	public void resumeBomb() {
		t.start();
	}
	
}

//comment

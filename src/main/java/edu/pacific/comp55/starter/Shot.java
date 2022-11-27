package edu.pacific.comp55.starter;
import acm.graphics.*;

import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;


public class Shot implements ActionListener {
	public static final int SIZE = 25;
	public static final int MS = 50;
	public static final int SPEED = 2;
	//GObject shot = new GImage("images/shot1.png");
	private ArrayList <GOval> shots;
	//private Invaders ArrayList<GObject> enemies;
	public static Timer t;
	PlayerShip ship;
	private GObject s;
	GraphicsProgram gameScr; 
	
	public Shot(GraphicsProgram screen) {
		gameScr = screen;
		
	}
	
	public void run() {
		shots = new ArrayList<GOval>();
		t = new Timer(10, this);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		moveAllShotsOnce();
		//removeShot();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			GOval shot = makeShot(ship.getX(), 370);
			addAShot(ship.getX());
		}
	}
	
	private void addAShot(double x) {
		GOval shot = makeShot(x, SIZE/2);
		gameScr.add(shot);
		shots.add(shot);
	}
	
	public GOval makeShot(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.WHITE);
		temp.setFilled(true);
		gameScr.add(temp);
		return temp;
	}
	
	private void moveAllShotsOnce() {
		for(GOval shot:shots) {
			shot.move(SPEED, 0);
		}
	}
	
//	private void removeShot() {
//		for(GOval shot: shots) {
//			for(GRect enemy: enemies) {
//				s = getElementAt(shot.getX() + shot.getWidth() + 1, shot.getY() + shot.getHeight() / 2);
//				if(s == enemy) {
//					enemies.remove(s);
//				}
//			}
//		}
//	}

	
}

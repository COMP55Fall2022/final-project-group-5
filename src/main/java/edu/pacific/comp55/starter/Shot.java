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
	public static final int SIZE = 10;
	public static final int MS = 50;
	public static final int SPEED = 10;
	private ArrayList <GOval> shots;
	public static Timer t;
	GraphicsProgram gameScr; 
	
	public Shot(GraphicsProgram screen) {
		gameScr = screen;
		init();
	}
	
	public void init() {
		//ship = new PlayerShip(gameScr);
		shots = new ArrayList<GOval>();
		System.out.println("shot run");
		t = new Timer(50, this);
		t.start(); 
	}
	
	public void actionPerformed(ActionEvent e) {
		moveAllShotsOnce();
	}
	
	public void addAShot(double x, double y) {
		GOval shot = makeShot(x, y);
		System.out.println("shot count");
		gameScr.add(shot);
//		shots.add(shot);
	}
	
	public GOval makeShot(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.WHITE);
		temp.setFilled(true);
		shots.add(temp);
		// AudioPlayer
		return temp;
	}
	
	private void moveAllShotsOnce() {
		for(GOval shot:shots) {
			shot.move(0, -SPEED);
		}
	}
	
	public void stopShots() {
		t.stop();
	}
	
	public void resumeShots() {
		t.start();
	}

	public ArrayList<GOval> getShots() {
		return shots;
	}
	
	public void removeShot(double x, double y) {
		for (int i = 0; i < shots.size(); i++) {
			if (shots.get(i).getX() == x && shots.get(i).getY() == y) {
				shots.remove(i);
				gameScr.remove(shots.get(i));
				System.out.println("delete");
			}
		}
	}
	
//	private void removeShot() {
//		for(GOval shot: shots) {
//			for(Invaders enemy: enemies) {
//				s = getElementAt(shot.getX() + shot.getWidth() + 1, shot.getY() + shot.getHeight() / 2);
//				if(s == enemy) {
//					enemies.remove(s);
//				}
//			}
//		}
//	}

	
}

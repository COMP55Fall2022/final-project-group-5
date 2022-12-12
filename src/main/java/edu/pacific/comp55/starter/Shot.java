package edu.pacific.comp55.starter;
import acm.graphics.*;

import acm.program.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;


public class Shot implements ActionListener {
	public static final int SIZE = 10;
	public static final int MS = 50;
	public static final int SPEED = 10;
	private ArrayList <GOval> shots;
	public static Timer t;
	private int fireRate;
	GraphicsProgram gameScr; 
	
	public Shot(GraphicsProgram screen) {
		gameScr = screen;
		fireRate = 0;
		init();
	}
	
	public void init() {
		shots = new ArrayList<GOval>();
		t = new Timer(50, this);
		t.start(); 
	}
	
	public int getFireRate() {
		return fireRate;
	}
	
	public void incrementRate() {
		fireRate++;
	}
	
	public void actionPerformed(ActionEvent e) {
		moveAllShotsOnce();
	}
	
	public void addAShot(double x, double y) {
		if (fireRate == 2) {
			GOval shot = makeShot(x, y);
			gameScr.add(shot);
			AudioPlayer audio = AudioPlayer.getInstance();
			audio.playSound("sounds", "shoot.mp3", false);
			fireRate = 0;
		}
	}
	
	public GOval makeShot(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.WHITE);
		temp.setFilled(true);
		shots.add(temp);
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
}

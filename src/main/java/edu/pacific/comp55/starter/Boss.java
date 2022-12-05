package edu.pacific.comp55.starter;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;



public class Boss extends GraphicsProgram {
	//private Bomb bomb;
	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;
	private static final int boss1Size = 125;
	private static final int boss2Size = 84;
	private static final int boss3Size = 43;
	int x;
	int y;
	int start_x = 250;
	int start_y = 250;
	private Timer invadersUpdateTimer;
	private int invadersSpeed = 300;
	GObject Boss;
	GraphicsProgram gameScr; 
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public static void main(String args[]) {
		new Boss().start();
	}

	@Override
	public void run() {
		Boss = new GRect(start_x, start_y, boss3Size, boss3Size);
		add(Boss);
		invadersUpdateTimer = new Timer(invadersSpeed, this);
		invadersUpdateTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == invadersUpdateTimer) {
			moveBoss();
		}
	}
		
	private void moveBoss() {
		var generator = new Random();
		int dx = generator.nextInt((360-10))+10;
		int dy = generator.nextInt(250);
		Boss.setLocation(dx, dy);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
		
		public Bomb getBomb() {
			return bomb;	
			}
		
		public void run() {
			gameScr.add(Boss);
		}
	}
	
//audio.playSound("src/main/resources" , "bossSound.mp3");
//public void playSound(String sounds, String bossSound.mp3) {
//	playSound(sounds, filename, bossSound.mp3);
//}
	
	
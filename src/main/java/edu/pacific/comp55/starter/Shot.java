package edu.pacific.comp55.starter;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class Shot extends GraphicsProgram {
	GObject shot = new GImage("images/shot1.png");
	int x;
	int y;
	int START_X;
	int START_Y;
	
	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	private void removeShot() {
		
	}
	
	public Shot() {
		fireShot();
	}
	
	@Override
	public void run() {
		add(shot);
		
		addKeyListeners();
	}
	
	public void fireShot() {
		
	}
	
	public static void main(String[] args) {
		new Shot().start();
	}
}

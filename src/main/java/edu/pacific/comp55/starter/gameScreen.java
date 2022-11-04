package edu.pacific.comp55.starter;
import acm.program.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import acm.graphics.*;

public class gameScreen extends GraphicsProgram{
	
	private static final int PROGRAM_HEIGHT = 500;
	private static final int PROGRAM_WIDTH = 500;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	
	}

	public void run() {
		// all draws
		drawMainMenu();
		addKeyListeners();
		addMouseListeners();
	}
	
	private void drawMainMenu() {
		
	}
	
	

	public static void main(String[] args) {
		new gameScreen().start();
	}
}
// todo
package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class PauseMenu {
	GraphicsProgram gameScreenRef;
	private GRect resume;
	private GRect exit;
	
	PauseMenu(GraphicsProgram ref){
		gameScreenRef = ref;
	}
	
	public void Draw() {
		GRect popUp = new GRect(137, 250, 200, 150);
		popUp.setColor(Color.BLACK);
		popUp.setFilled(true);
		gameScreenRef.add(popUp);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			Draw();
			System.out.println("pause");
		}
	}
}

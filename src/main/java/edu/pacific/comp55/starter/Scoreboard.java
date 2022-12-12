package edu.pacific.comp55.starter;

import acm.program.GraphicsProgram;
import javafx.util.Pair;
import java.awt.Color;
import java.util.ArrayList;


import acm.graphics.*;


public class Scoreboard {
	GraphicsProgram gameScreenRef;
	private GRect exit;
	private ArrayList<Pair<String, Long>> ranks = new ArrayList<Pair<String, Long>>() {
		 {
             add(new Pair<>("p1", 0L));
             add(new Pair<>("p2", 0L));
             add(new Pair<>("p3", 0L));
         }
	};
	
	public GRect getExit() {
		return exit;
	}

	Scoreboard(GraphicsProgram ref){
		gameScreenRef = ref;
	}
	
	public void Draw() {
		GLabel name = new GLabel("Scoreboard", 168, 130);
		name.setFont("Arial-Bold-30");
		name.setColor(Color.WHITE);
		
		GRect popUp = new GRect(98, 70, 300, 330);
		popUp.setColor(Color.BLACK);
		popUp.setFilled(true);
		
		exit = new GRect(103, 75, 33, 33);
		exit.setColor(Color.WHITE);
		
		GLine x1 = new GLine(103, 75, 135, 107);
		x1.setColor(Color.white);
		GLine x2 = new GLine(103, 107, 135, 75);
		x2.setColor(Color.white);
		
		gameScreenRef.add(popUp);
		gameScreenRef.add(name);
		gameScreenRef.add(x1);
		gameScreenRef.add(x2);
		gameScreenRef.add(exit);
		
		for (int i = 0; i < ranks.size(); i++) {
			int y = 175 + i*50; 
			if (ranks.get(i).getValue() == 0L) {
				GLabel rank = new GLabel((i+1)+". N/A - 00:00:00", 153, y);
				rank.setFont("Arial-Bold-22");
				rank.setColor(Color.WHITE);
				gameScreenRef.add(rank);;
			}
			else {
				int S = (int) (ranks.get(i).getValue() % 60);
		        int H = (int) (ranks.get(i).getValue() / 60);
		        int M = H % 60;
				GLabel rank = new GLabel((i+1)+". " + ranks.get(i).getKey() + " - " + M + ":"+S, 153, y);
				rank.setFont("Arial-Bold-22");
				rank.setColor(Color.WHITE);
				gameScreenRef.add(rank);
			}
		}
		//140
		
	}
	
	public void setRanks(long elapseTime, String name) {
		for (int i = 0; i < ranks.size();i++) {
			if (ranks.get(i).getValue() < elapseTime) {				
				ranks.set(i, new Pair<> (name, elapseTime));
				return;
			}
		}
	}
	
	public void Exit() {
		gameScreenRef.removeAll();
	}
	
	


}

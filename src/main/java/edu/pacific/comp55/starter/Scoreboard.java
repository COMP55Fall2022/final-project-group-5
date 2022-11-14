package edu.pacific.comp55.starter;

import acm.program.GraphicsProgram;
import acm.program.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import acm.graphics.*;


public class Scoreboard {
	GraphicsProgram gameScreenRef;
	private GRect exit;
	private Map<String, Long> ranks = Map.ofEntries(Map.entry("P1", 0L), 
			Map.entry("P2", 0L), 
			Map.entry("P3", 0L));
	
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
		
		int i = 0;
		for (Map.Entry<String,Long> entry : ranks.entrySet()) {
			int y = 175 + i*50; 
			GLabel rank = new GLabel("1. N/A - 00:00:00", 153, y);
			rank.setFont("Arial-Bold-22");
			rank.setColor(Color.WHITE);
			gameScreenRef.add(rank);;
			i++;
		}
		//140
		
	}
	
	public void setRanks(Long elapseTime, String name) {
		Map<String,Long> newMap = new HashMap<>();
		for (Map.Entry<String,Long> entry : ranks.entrySet()) {
			if (entry.getValue() < elapseTime) {
		        newMap.put(name, elapseTime);
		        newMap.put(entry.getKey(), entry.getValue());
			}
			else {
		        newMap.put(entry.getKey(), entry.getValue());
			}
			ranks = newMap;
		}
	}
	
	public void Exit() {
		gameScreenRef.removeAll();
	}
	
	


}

package edu.pacific.comp55.starter;

import acm.graphics.GImage;

public class Lives{
	
	static int count(int livesCounter) {
		  livesCounter = livesCounter - 1; 
		  if(livesCounter == -1) {
		    System.out.println("Lost");  
		  }
		  else
		  {
		  System.out.println(livesCounter);
		  }
		  return livesCounter;
		}
	public static void main(String[] args) {
	    int livesCounter = 3;  
	  livesCounter=count(livesCounter);
	  livesCounter=count(livesCounter);
	 
	  
	  
	  }
		  
	
	
}


   
package edu.pacific.comp55.starter;



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

		  
	
	
}


   
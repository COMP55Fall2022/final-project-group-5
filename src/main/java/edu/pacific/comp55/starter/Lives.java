package edu.pacific.comp55.starter;



public class Lives{
	
    public static void main(String[] args) {  
        //initialize counter  
        int livesCounter = 4;  
          
        //using for loop to decrement the counter variable  
        for(int lives=0; lives<4; lives++){  
        	//write the condition when hit by the enemy
            //decrement counter variable  
            livesCounter = livesCounter - 1;  
            //print the counter variable value  when shot
            System.out.println(livesCounter);  
            if(livesCounter == 0) {
                System.out.println("Lost");  

            }
        }  
    }
	
	
}
//new
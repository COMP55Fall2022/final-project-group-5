package edu.pacific.comp55.starter;

public class Invaders {
	private Bomb bomb;
	private int x;
	private int y;
	public Invaders(int x, int y) {
		initInvaders(x, y);
	}
	private void initInvaders(int x, int y) {
		this.x = x;
		this.y = y;
		
		//this should get img for the enemiesInvaders = "gets image for the enemy"
		bomb = new Bomb(x, y);
		//this should get img for the bomb
		
		// setImage(ii.getImage());
	}
	public void act(int direction) {
		
	}
	public Bomb getBomb() {
		return bomb;
	}
	public class Bomb extends Invaders {

		public Bomb(int x, int y) {
			 initBomb(x , y);
		}
		private void initBomb(int x, int y) {
			
		}
	}
		
}




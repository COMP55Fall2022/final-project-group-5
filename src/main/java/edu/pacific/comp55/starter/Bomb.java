package edu.pacific.comp55.starter;

public class Bomb {

	private int x;
	private int y;
	private boolean destroyed;
	public Bomb(int x, int y) {
		 initBomb(x , y);
	}
	private void initBomb(int x, int y) {
		this.x = x;
		this.y = y;
		invaders(true);
	//var imgBomb = ""
	//var II = new "";
	//setImage(ii.getImage());	
	}
	private void invaders(boolean destroyed) {
		this.destroyed = destroyed;
	}
		public boolean isDestroyed() {
			return destroyed;
		}
		
	}



package model;
import processing.core.PApplet;

public class Enemigos extends Personaje implements Runnable{

	public Enemigos(int posX, int posY, int size, PApplet app) {
		super(posX, posY, size, app);
		
	}

	public void pintar() {
	
	
		app.fill(255,128,0);
		app.rect(posX, posY, size, size);
	}


	public void mover() {
		
		
		posX +=speed;
		if(posX >= 550 || posX <= 50){
			posY += 120;
			speed*=-1;		
		}
	
	}


	public void run() {
		
		
		mover();
	}


}

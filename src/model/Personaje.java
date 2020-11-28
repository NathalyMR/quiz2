package model;
import processing.core.PApplet;

public abstract class Personaje{

	protected PApplet app;
	protected int posX, posY, size, speed;
	
	public Personaje(int posX, int posY, int size, PApplet app) {
	
		
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.size=size;
		
		speed = 1;
	}
	
	public abstract void pintar();
	
	
	public abstract void mover();
	

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
}

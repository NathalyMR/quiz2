package model;
import java.util.ArrayList;

import processing.core.PApplet;


public class Jugador extends Personaje implements Runnable{

	private ArrayList<Proyectil> proyectil;
	private boolean borrarProyectil;
	
	public Jugador(int posX, int posY, int size, PApplet app) {
		super(posX, posY, size, app);
		speed=5;
		proyectil = new ArrayList<Proyectil>();
		borrarProyectil=false;
	}

	public void pintar() {
		
		app.fill(112,186,167);
		app.ellipse(posX, posY, size, size);
	}
	
	public void pintarProyectil() {
		
		for (int i = 0; i < proyectil.size(); i++) {
			proyectil.get(i).pintar();
			proyectil.get(i).mover();
			
			if(borrarProyectil == true) {
				proyectil.remove(i);
				borrarProyectil = false;
			}
			
		}
		
		for (int i = 0; i < proyectil.size(); i++) {
			
			if (proyectil.get(i).getPosY() <= 0) {
				
				proyectil.remove(i);
			}
		}
	}


	public void mover() {
		
	}

	public void moverDerecha() {
		
		posX += speed;
		
		if (posX== 550) {
			
			posX -= speed;
		}
	}
	
	public void moverIzquierda() {
		
		posX -= speed;
		
		if (posX== 50) {
			
			posX += speed;
		}
	}
	
	public void disparar() {
		
		Proyectil b = new Proyectil(posX, posY-30, app);
		proyectil.add(b);
	}


	
	public void run() {
		
		
		moverIzquierda();
		moverDerecha();
	}


	public ArrayList<Proyectil> getProyectil() {
		return proyectil;
	}


	public void setProyectil(ArrayList<Proyectil> bullet) {
		this.proyectil = bullet;
	}


	public boolean isBorrarProyectil() {
		return borrarProyectil;
	}


	public void setBorrarProyectil(boolean eliminateBullet) {
		this.borrarProyectil = eliminateBullet;
	}
	
	
	
}

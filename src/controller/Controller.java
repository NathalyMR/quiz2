package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private PApplet app;
	private Logic logic;
	
	public Controller (PApplet app) {
		
		this.app=app;
		
		logic = new Logic(app);
	}

	public void pintarEnemigo() {
		
		
		logic.pintarEnemigo();
	}

	public void pintarJugador() {
		
		
		logic.pintarJugador();
	}
	
	public void pintarProyectil() {
		
		logic.pintarProyectil();
	}

	public void moverDerecha() {
	
		
		logic.moverDerecha();
	}
	
	public void moverIzquierda() {
		
		logic.moverIzquierda();
	}

	public void diparar() {
				
		logic.diparar();
	}
	
	public void contadorEnemigo() {
		
		logic.contadorEnemigo();
	}
	
	public void finalizar() {
		logic.finalizar();
	}
	
	public void keyPressed(char key) {
		logic.keyPressed(key);
	}
}

package view;

import controller.Controller;
import model.Logic;

import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
	
		PApplet.main("view.Main");
	}

	private Controller controller;
	private boolean moverIzquierda;
	private boolean moverDerecha;
	
	public void settings() {
		
		size(600, 600);
	}
	
	public void setup() {
		
		controller= new Controller(this);
	}
	
	public void draw() {
		
		rectMode(CENTER);
		background (255);
		
		controller.pintarEnemigo();
		controller.pintarJugador();
		controller.pintarProyectil();
		controller.contadorEnemigo();
		controller.finalizar();
		
		if (moverDerecha==true){

			controller.moverDerecha();; 
		}

		if (moverIzquierda==true){

			controller.moverIzquierda();
		}
	}
	
	public void keyPressed() {
		
		controller.keyPressed(key);
		
		if(keyCode == 68) {
			moverDerecha=true;
		}
		if(keyCode == 65) {
			moverIzquierda=true;
		}
		
		if (keyCode == ' ') {
			
			controller.diparar();
		}
		
	}
	
	public void keyReleased() {
		
		if(keyCode == 68) {
			moverDerecha=false;
		}
		if(keyCode == 65) {
			moverIzquierda=false;
		}
	}
}

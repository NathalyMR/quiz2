package model;
import java.util.ArrayList;

import javax.swing.Box.Filler;

import exception.Perder;
import exception.Ganar;
import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private ArrayList<Enemigos> enemigo;
	private Jugador jugador;
	
	private int contadorEnemigos;
	private int finalizar;
	private boolean gameOver;
	
	public Logic(PApplet app) {
		
		this.app = app;
		
		enemigo = new ArrayList<Enemigos>();
		jugador = new Jugador(300, 550, 50, app);
		contadorEnemigos=0;
		finalizar= 0;
		gameOver=false;
		crearEnemigos();
		
	}
	
	public void crearEnemigos() {
		
		for (int i = 0; i < 6; i++) {
			
			enemigo.add(new Enemigos((i*55)+50, 100, 50, app));
		}
		
		for (int i = 0; i < 6; i++) {
			
			enemigo.add(new Enemigos((i*55)+50, 40, 50, app));
		}
		
	
	}
	
	public void pintarEnemigo() {
		
		for (int i = 0; i < enemigo.size(); i++) {
			enemigo.get(i).pintar();
			Thread newAlien = new Thread(enemigo.get(i));
			newAlien.start();
		}

		try {
			impacto();
		} catch (Perder e) {
			
			
			gameOver=true;
			finalizar=2;
			
		}
		
		moverJugador();
		
	}
	
	public void pintarJugador() {
		
		jugador.pintar();
		Thread newHero = new Thread (jugador);
		newHero.start();
		
		try {
			impact();
		} catch (Ganar e) {
			
			
			
			gameOver=true;
			finalizar=1;
			
		
		}
	}
	
	public void moverDerecha() {
		
		jugador.moverDerecha();
	}
	
	public void moverIzquierda() {
		
		jugador.moverIzquierda();
		
	}
	
	public void moverJugador() {
		
		for (int i = 0; i < enemigo.size(); i++) {
	
			enemigo.get(i).mover();
		}
	}
	
	public void pintarProyectil() {
		
		jugador.pintarProyectil();
		Thread newBullet = new Thread (jugador);
		newBullet.start();
		
	}
	
	public void diparar() {
		
		jugador.disparar();
	}
	
	public void contadorEnemigo() {
		
		app.fill(0);
		app.text("Enemigos abatidos= "+ contadorEnemigos, 50, 50);
	}
	
	public void impact() throws Ganar{
		
		for (int i = 0; i < jugador.getProyectil().size(); i++) {
			for (int j = 0; j < enemigo.size(); j++) {
				
				int posX1=jugador.getProyectil().get(i).getPosX();
				int posY1=jugador.getProyectil().get(i).getPosY();
				int posX2=enemigo.get(j).getPosX();
				int posY2=enemigo.get(j).getPosY();
				int size=enemigo.get(j).getSize();
				
				if (PApplet.dist(posX1, posY1, posX2, posY2) < size) {
					
					jugador.setBorrarProyectil(true);
					enemigo.remove(j);
					contadorEnemigos++;
					
					
				}
				
			}
		}
		
		if (enemigo.size()==0) {
			
			throw new Ganar("¡Ganaste!");
			
		}
		
	}
	
	public void impacto() throws Perder{
		
		for (int i = 0; i < enemigo.size(); i++) {
			
			int posX1=enemigo.get(i).getPosX();
			int posY1=enemigo.get(i).getPosY();
			int posX2=jugador.getPosX();
			int posY2=jugador.getPosY();
			int size=jugador.getSize();
			
			if (PApplet.dist(posX1, posY1, posX2, posY2) < size) {
				
				throw new Perder("Perdiste");
				
			}
		}
	}
	
	public void finalizar() {
		
		switch (finalizar) {
		case 1:			
			app.fill(205,127,50);
			app.rect(400, 380, 800, 800);
			app.fill(255);
			app.text("¡Ganaste!", 250, 380);
			app.text("Presiona R para jugar de nuevo", 200, 400);
			break;
			
		case 2:			
			app.fill(205,127,50);
			app.rect(400, 380, 800, 800);
			app.fill(255);
			app.text("Perdiste", 250, 380);
			app.text("Presiona R para jugar de nuevo", 200, 400);
			break;

		default:
			break;
		}
	}
	
	public void keyPressed(char key) {
		
		if (gameOver==true) {
			if (key =='r') {
				
				if (enemigo.size()==0) {
					
					jugador.getProyectil().clear();
					enemigo.clear();					
					finalizar=0;
					contadorEnemigos=0;
					gameOver=false;
					crearEnemigos();
					
					
				} else {
					
					jugador.getProyectil().clear();
					enemigo.clear();					
					finalizar=0;
					contadorEnemigos=0;
					gameOver=false;
					crearEnemigos();
				}
			}
		}
	}


}

package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener{

	private final static int numeroTeclas = 120;
	private boolean[] teclas = new boolean[numeroTeclas];
	
	public boolean arriba;
	public boolean abajo;
	public boolean derecha;
	public boolean izquierda;
	
	public void actualizar(){
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		derecha = teclas[KeyEvent.VK_D];
		izquierda = teclas[KeyEvent.VK_A];
	}
	

	public void keyPressed(KeyEvent arg0) { //Pulsada sin soltar
		// TODO Auto-generated method stub
		teclas[arg0.getKeyCode()] = true;
	}


	public void keyReleased(KeyEvent arg0) { //Liberada
		// TODO Auto-generated method stub
		teclas[arg0.getKeyCode()] = false;
	}


	public void keyTyped(KeyEvent arg0) { //Accion completa
		// TODO Auto-generated method stub
		
	}

}

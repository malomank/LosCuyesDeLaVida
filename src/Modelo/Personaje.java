package Modelo;
import java.util.ArrayList;

public abstract class Personaje { //sin constructor

	private  int ancho ; 
	private int alto ; 
	private Posicion pos; //Sin set y get
	private char letraAsociada ;
	private boolean visible ; 
	private boolean atravesable ;
	
	private Sprite matriz[][] ; //Sin set y get
	private ArrayList<Integer> estados ; //Sin set y get
	private int estadoActual ;
	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}

	public char getLetraAsociada() {
		return letraAsociada;
	}

	public void setLetraAsociada(char letraAsociada) {
		this.letraAsociada = letraAsociada;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isAtravesable() {
		return atravesable;
	}

	public void setAtravesable(boolean atravesable) {
		this.atravesable = atravesable;
	}

	public int getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(int estadoActual) {
		this.estadoActual = estadoActual;
	}
	
}

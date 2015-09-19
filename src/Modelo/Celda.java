package Modelo;

public class Celda {
	private char caracter ;
	private Posicion pos;
	
	public Celda(){
		this.setCaracter(' ');
		pos = new Posicion(0,0);
	}
	
	public Celda(int fil, int col, char caracter){
		this.setCaracter(caracter);
		pos = new Posicion(fil,col);
	}
	
	private char getCaracter() {
		return caracter;
	}
	private void setCaracter(char caracter) {
		this.caracter = caracter;
	}
	
}

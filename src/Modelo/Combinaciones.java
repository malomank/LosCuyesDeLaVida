package Modelo;

public class Combinaciones {

	private int numLetras;
	private char[] letrasEspeciales ;
	//acciones arreglo de string
	
	public Combinaciones(){
		this.numLetras = 0;
	}
	public char[] getLetrasEspeciales() {
		return letrasEspeciales;
	}
	public void setLetrasEspeciales(char[] letrasEspeciales) {
		this.letrasEspeciales = letrasEspeciales;
	}

	public int getNumLetras() {
		return numLetras;
	}

	public void setNumLetras(int numLetras) {
		this.numLetras = numLetras;
	}
}

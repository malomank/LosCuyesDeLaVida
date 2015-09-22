package Modelo;

public class AccionesEspeciales {
	private int numIndividuales;
	private int numDuos;
//	individuales arreglo de combinaciones
	private Combinaciones [] individuales;
//	enconjunto   arreglo de combinaciones (la clase que est arriba )
	private Combinaciones [] duo;
	
	public AccionesEspeciales(){
		this.numIndividuales = 0;
		this.numDuos = 0;
		this.individuales = new Combinaciones[4];
		this.duo = new Combinaciones[4];
	}
	
	public void setCadenasIndividuales(char x[]){
		this.individuales[numIndividuales++].setLetrasEspeciales(x);
	}
	
	public void setCadenasDuos(char x[]){
		this.duo[numDuos++].setLetrasEspeciales(x);
	}
	
	public void setIndividuales(char[] x){
		this.numIndividuales++;
	}
	
	public int getNumIndividuales() {
		return numIndividuales;
	}
	public void setNumIndividuales(int numIndividuales) {
		this.numIndividuales = numIndividuales;
	}
	public int getNumDuos() {
		return numDuos;
	}
	public void setNumDuos(int numDuos) {
		this.numDuos = numDuos;
	}
}

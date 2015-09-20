package Modelo;

public class Mapa {
	private AccionesEspeciales acciones;
	private Celda [][] mapa = new Celda[12][16];
	private int estadoDuo ; 
	private int contador ; 
	
	public Mapa(){		//Inicializa el mapa con caracteres en blanco
		for(int i=0;i<12;i++){
			for(int j=0;j<16;j++){
				mapa[i][j] = new Celda(' ', i, j);
			}
		}
	}
	
	public void ImprimirMapa(){ //Imprime mapa para verificar que estaba bien cargado
		for(int i=0;i<12;i++){
			for(int j=0;j<16;j++){
				System.out.print(mapa[i][j].getCaracter());
			}
			System.out.println();
			}
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public AccionesEspeciales getAcciones() {
		return acciones;
	}

	public void setAcciones(AccionesEspeciales acciones) {
		this.acciones = acciones;
	}

	public int getEstadoDuo() {
		return estadoDuo;
	}

	public void setEstadoDuo(int estadoDuo) {
		this.estadoDuo = estadoDuo;
	}
	
}

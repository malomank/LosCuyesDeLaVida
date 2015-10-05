package Graficos;

public final class Sprites {
	private final int lado; //tamaño del cuadrado
	
	private int x; //Coordenadas en tiles
	private int y; //Coordenadas en tiles
	
	public int[] pixeles;
	private final HojaSprites hoja;
	
	public Sprites(final int lado, final int columna, final int fila, final HojaSprites hoja){
		this.lado = lado;
		pixeles = new int[this.lado * this.lado];
		
		this.x = columna*lado; //El eje X abarca una columna
		this.y = fila*lado; //el eje Y abarca una fila
		this.hoja = hoja;
		
		for (int i = 0; i < lado; i++){ // i = y
			for(int j = 0; j < lado; j++){ // j = x
				pixeles[i + j * lado] = hoja.pixeles[(j + this.x) + ( i + this.y) * hoja.getAncho()];
			}
		}
	}
}

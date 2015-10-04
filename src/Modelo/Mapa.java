package Modelo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Mapa  extends JFrame{
	private AccionesEspeciales acciones;
	private Celda [][] mapa = new Celda[12][16];
	private int estadoDuo ; 
	private int contador ; 
	private BufferedImage img = null; //por si acaso Null :v
	
	
	public Mapa(int indice){		//Inicializa el mapa con caracteres en blanco
		super("Mapa " + indice); //Constructor (padre) JFrame
		
		//createBufferStrategy(2); //Activar doble buffering 			
		for(int fil=0;fil<12;fil++){
			for(int col=0;col<16;col++){
				mapa[fil][col] = new Celda( fil, col,' ');
			}
		}		
		try {
			switch (indice){
			case 0:		
				setImg(ImageIO.read(new File("Pantalla_inicio_cuy.jpg")));// ImageIO permite leer desde file, url entre otros :)	 	       				
				break;
			case 1:
				setImg(ImageIO.read(new File("Pantalla_inicio_cuy.jpg")));
				break;
			case 2:
				setImg(ImageIO.read(new File("Pantalla_inicio_cuy.jpg")));
				break;
			}
		} catch (IOException ex) {
	            System.out.println("No se pudo leer la imagen");
	    }
		
		setSize(500,500); //Para dimensionar el tamaño
	}
	
	//Carga combinaciones por mapa
	public void setAccionesIndividuales(String cadena){
		this.acciones.setCadenasIndividuales(cadena);
	}
	
	public void setAccionesDuos(String cadena){
		this.acciones.setCadenasDuos(cadena);
	}
	//funcion
	public void establecerCaracter(int i, int j, char x){
		mapa[i][j].setCaracter(x);
	}
	
	public char obtenerCaracter(int fil, int col){
		return mapa[fil][col].getCaracter();
	}
	
	public void ImprimirMapa(){ //Imprime mapa para verificar que estaba bien cargado
		for(int fil=0;fil<12;fil++){
			for(int col=0;col<16;col++){
				System.out.print(mapa[fil][col].getCaracter());
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

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
}

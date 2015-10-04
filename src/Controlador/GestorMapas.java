package Controlador;
import Modelo.*;
import java.io.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GestorMapas  {
		
		
	    //Por ahora SOLO carga los mapas
		public void cargarMapaGrafico(Mapa mapa,int indice)throws IOException{
			
		}
	
		
		public void crearMapa(Mapa mapa,int indice)throws IOException{
			FileReader Lector;
			File archivo=null;
			char car;
			int fil=0;
			String linea;
			BufferedReader br;
			switch (indice){
			case 0:
			
				
				fil=0;
				archivo = new File ("./Mapas/tutorial.txt");
				Lector=new FileReader(archivo);
				br = null;
				br = new BufferedReader(Lector);
				//aqui esta la rutina para leer
				 while((linea=br.readLine())!=null){
					 for(int col=0;col<16;col++){
						 car=linea.charAt(col);
						 mapa.establecerCaracter(fil, col,car);
					 }
					 fil++;
				 }
				Lector.close();
			    break;
			case 1: 
				fil=0;
				archivo = new File ("./Mapas/Nivel1.txt");
				Lector=new FileReader(archivo);
				br = null;
				br = new BufferedReader(Lector);
				//aqui esta la rutina para leer
				 while((linea=br.readLine())!=null){
					 for(int col=0;col<16;col++){
						 car=linea.charAt(col);
						 mapa.establecerCaracter(fil, col,car);
					 }
					 fil++;
				 }
				Lector.close();
			        break;
			case 2:
				fil=0;
				archivo = new File ("./Mapas/Nivel2.txt");
				Lector=new FileReader(archivo);
				br = null;
				br = new BufferedReader(Lector);
				//aqui esta la rutina para leer
				 while((linea=br.readLine())!=null){
					 for(int col=0;col<16;col++){
						 car=linea.charAt(col);
						 mapa.establecerCaracter(fil, col,car);
					 }
					 fil++;
				 }
				Lector.close();
					break;
			}
			
		}
		
}
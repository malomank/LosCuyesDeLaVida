package Controlador;
import Vista.Renderizador;
import Modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.sun.xml.internal.ws.encoding.MimeMultipartParser;

public class Juego implements Renderizador{

	private int nextLevel ;
	private Scanner teclado;
	
	private PersonajePrincipal personajeA ; // EL Cuyo  
	private PersonajePrincipal personajeB ;  // La Cuya
	private ArrayList <PersonajeSecundario> listPersonajesSecundarios ; 
	private ArrayList <Objeto> listObjetos ; 
	private ArrayList <Mapa> listMapas ; 
	private GestorMapas gestorMapa ;
	private InterpreteComandos interpreteComando ; 
	//private Rendenrizador renderizador ;  Ya no se usará renderizador
	private Mapa  mapaActual ; 
	
	public Juego(int numeroMapas , int numerosDeObjetos , int numPersSecund){
		
	}
	
	public void ImprimirMapa(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal cuy2){
		int flagDuo=0, flagAccA=0, flagAccB=0, flagNuevoEnemigo=0, esp=0;
		
		for(int fil=0;fil<12;fil++){
			for(int col=0;col<16;col++){
				if(mapa.obtenerCaracter(fil,col)==' ') esp++;
				if ((/*cuy1.getPosX()==i && cuy1.getPosY()==j*/ cuy1.getPos(fil, col)) ||(cuy2.getPos(fil, col))){ 
					if( cuy1.getPos(fil, col)) {
						System.out.print('A');
						if (mapa.obtenerCaracter(fil,col)=='D') flagDuo++;
						if (mapa.obtenerCaracter(fil,col)=='C') flagAccA++;
						if(((cuy1.getPosX()==11 && cuy1.getPosY()==1)||(cuy1.getPosX()==10 && cuy1.getPosY()==0)) && esp>50){
							flagNuevoEnemigo++;
							mapa.establecerCaracter(i, j+1, '@');
							//Esto hace que el caracter del costado muestre al enemigo en la impresion
							
						}
						//if (mapa.obtenerCaracter(i,j)=='C') flagAccA++;
					}					    
					if(cuy2.getPosX()==i && cuy2.getPosY()==j) {
						System.out.print('B');
						if (mapa.obtenerCaracter(i,j)=='D') flagDuo++;	
						if (mapa.obtenerCaracter(i,j)=='C') flagAccB++;
					}			
				}
				else System.out.print(mapa.obtenerCaracter(i,j));								
			
			}
			System.out.println();
		}
	}
	
}

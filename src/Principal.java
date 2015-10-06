import java.awt.Image;

import Vista.Juego;
import Vista.*;
import Vista.Imagen; 



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

 	    
 	    //Ventana v = new Ventana() ; 
 	    //v.setVisible(true);
 	    //Ventana2 ven = new Ventana2() ; 
		
		Imagen ima = new Imagen();
		Juego nuevoJuego = new Juego(10, 50,40) ; 
 	    nuevoJuego.iniciarPersonajes();
 	    nuevoJuego.PantallaInicial();

	}
	
}

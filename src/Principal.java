import Vista.*;




public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaPP ve = new VentanaPP() ; 
		
 	    Juego nuevoJuego = new Juego(10, 50,40) ; 
 	    nuevoJuego.iniciarPersonajes();
 	    nuevoJuego.PantallaInicial(); 	    	    		
	}
	
}

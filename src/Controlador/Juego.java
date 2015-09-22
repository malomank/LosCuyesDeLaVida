package Controlador;
import Vista.Renderizador;
import Modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.nio.sctp.PeerAddressChangeNotification;
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
	private Mapa  mapaActual ; 
	
	public void FinDelJuego(){
		System.out.println("Felicitaciones, eres el mejor. Terminaste el juego Mi estimado LOL by --BrayanRP");		
	}
	public void Historia_3(){
		String linea;
		System.out.println("Bienvenido a Historia_3  (presione enter para continuar)");
		linea = teclado.next();
		FinDelJuego();
	}

	
	public Juego(int numeroMapas , int numerosDeObjetos , int numPersSecund){
		 nextLevel =  0  ;
		 listObjetos  = new  ArrayList <Objeto>(numerosDeObjetos) ; 
		 listPersonajesSecundarios = new ArrayList <PersonajeSecundario>(numPersSecund) ;
		 listMapas = new ArrayList <Mapa>(numeroMapas) ;
		 interpreteComando = new InterpreteComandos() ;		 		 				 	
		 gestorMapa = new GestorMapas();		 		
		 
		 for(int i = 0 ; i <3 ; i++ ){ //Crea los mapas a utilizar
			 listMapas.add(new Mapa());			 
		 }	
		 
		 int indice = 0 ;
		 for (Mapa miMapa : listMapas){
			 gestorMapa.crearMapa(miMapa, indice);
			 miMapa.setContador(0);
			 miMapa.setEstadoDuo(indice);
			 indice++ ; 
		 }

		 mapaActual = new Mapa();
		 //gestorMapa.crearMapa(mapaActual, 0);
		 mapaActual =  listMapas.get(0);  // puede ser no necesario		 
		 //	 mapaActual.ImprimirMapa();		 
		 
		 // Prueba 
		 /*personajeA = new PersonajePrincipal("Brayan", 22,22,2, 2, 'A', true, false) ; 
		 personajeB = new PersonajePrincipal("Brando", 22,22,3,3, 'A', true, false) ;
		 ImprimirMapa(mapaActual, personajeA, personajeB);*/		 
	}
	public void PerdisteElJuego(){
		System.out.println("Game Over");	
	}
	public boolean movimientoValido(Personaje a ,Personaje b , int direccion , Mapa mapa){
		int xx , yy ,posibleX , posibleY ;  
		if( direccion == 1 || direccion == 7){ 			 
			xx = -1 ; yy = 0 ; 
		}else if(direccion == 2 || direccion == 8){
			xx = +1 ; yy = 0;			
		}else if(direccion == 3 || direccion == 9){
			xx = 0 ; yy = -1 ; 
		}else if(direccion == 4 || direccion == 10){
			xx = 0 ; yy = +1 ;			
		}else {
			xx = 0 ; yy = 0;
		}
		if(direccion <=6 ){
			posibleX = a.getPosX()  +  xx ;
			posibleY = a.getPosY()  +  yy ;			
		}else{
			posibleX = b.getPosX()  +  xx ;
			posibleY = b.getPosY()  +  yy ;			
		}
		
		if(!(  posibleX >= 0 && posibleX <=11 )) return false ; 
		if(!(  posibleY >= 0 && posibleY <=15 ))return false ;
		char c = mapa.obtenerCaracter(posibleX, posibleY) ; 
		if (c == 'N' || c=='S' || c =='T' || c == 'E' || c == 'D' || c == 'C' ||  c=='@') return true ; 
		if (c == 'p' || c == 'v') return false ; 		
		return false ; 		
	}
	
	public void Nivel_2(PersonajePrincipal perA, PersonajePrincipal perB){
		int entero, direccion;
		char entrada ; 
		System.out.println("Bienvenido al Nivel_2  (escriba un numero para continuar)");
		entero = teclado.nextInt();
		perA.setPosX(10);
		perA.setPosY(0);
		perB.setPosX(5);
		perB.setPosY(0);
		
		if(entero != nextLevel){
			while(true){
				// Fin de nivel
				System.out.println("TU VIDA ES" + perA.getVida());
				if (perA.getPosY() == 15 && perB.getPosY() == 15) break ;
				ImprimirMapa(listMapas.get(2), perA, perB);
				if (perA.getVida() <= 0 ) {
				PerdisteElJuego();		
				break ; 
			}
			entrada = teclado.next().charAt(0); 
			direccion = interpreteComando.esTeclaValida(entrada);
			System.out.println(direccion);
				if (movimientoValido(perA , perB , direccion , listMapas.get(2))){
					moverPersonajes(perA, perB, direccion);		
				}
			}
			if (perA.getVida() > 0 )Historia_3();
		}
		else{
			FinDelJuego();
		}
	}
	public void Historia_2(PersonajePrincipal perA, PersonajePrincipal perB){
		String linea;
		System.out.println("Bienvenido a Historia_2  (presione enter para continuar)");
		linea = teclado.next();
		Nivel_2(perA, perB);
	}
	public void moverPersonajes(Personaje a ,Personaje b , int direccion ){
		int xx , yy ;
		if( direccion == 1 || direccion == 7){ 			 
			xx = -1 ; yy = 0 ; 
		}else if(direccion == 2 || direccion == 8){
			xx = +1 ; yy = 0;			
		}else if(direccion == 3 || direccion == 9){
			xx = 0 ; yy = -1 ; 
		}else if(direccion == 4 || direccion == 10){
			xx = 0 ; yy = +1 ;			
		}else {
			xx = 0 ; yy = 0;
		}
		if(direccion <=6 ){
			a.setPosX( a.getPosX() + xx );
			a.setPosY( a.getPosY() + yy );
		}else {
			b.setPosX( b.getPosX() + xx );
			b.setPosY( b.getPosY() + yy );			
		}
	}
	public void Nivel_1(PersonajePrincipal perA , PersonajePrincipal perB){
		int entero, direccion;
		char entrada ; 
		System.out.println("Bienvenido al Nivel_1  (escriba un numero para continuar)");
		entero = teclado.nextInt();
		perA.setPosX(11);
		perA.setPosY(0);
		perB.setPosX(7);
		perB.setPosY(0);
		if(entero != nextLevel){			
			while(true){
				// Fin de nivel
				System.out.println("TU VIDA ES" + perA.getVida());
				if (perA.getPosY() == 15 && perB.getPosY() == 15) break ;
				ImprimirMapa(listMapas.get(1), perA, perB);
				if (perA.getVida() <= 0 ) {
				PerdisteElJuego();		
				break ; 
			}
			entrada = teclado.next().charAt(0); 
			direccion = interpreteComando.esTeclaValida(entrada);
			System.out.println(direccion);
				if (movimientoValido(perA , perB , direccion , listMapas.get(1))){
					moverPersonajes(perA, perB, direccion);		
				}
			}
			if (perA.getVida() > 0 )							
			 Historia_2(perA, perB);
		}
		else{
			System.out.println("Game Over");			
		}
	}
	
	public void Tutorial(PersonajePrincipal perA , PersonajePrincipal perB){
		int entero, direccion;
		char entrada ; 
		System.out.println("Movimientos Jugador1 - Movimientos Jugador2");
		System.out.println("Arriba:    W         - Arriba:     I       ");
		System.out.println("Abajo:     K         - Abajo:      K       ");
		System.out.println("Izquierda: A         - Izquierda:  J       ");
		System.out.println("Derecha:   D         - Derecha:    L       ");
		System.out.println("Especial:  Q         - Especial:   U       ");
		System.out.println("Especial:  E         - Especial:   P       ");
		System.out.println("");
		System.out.println("Al llegar a D, aparecera los comandos que debe presionar\nLuego dar enter para activar la acción especial");
		System.out.println("Cualquier numero y enter para continuar ");
		entero = teclado.nextInt();
		if(entero != nextLevel){
			while(true){
				// Fin de nivel
				System.out.println("VIDA " + perA.getVida());
				if (perA.getPosY() == 15 && perB.getPosY() == 15) break ;
				ImprimirMapa(listMapas.get(0), perA, perB);
				if (perA.getVida() <= 0 ) {
				PerdisteElJuego();		
				break ; 
			}
			entrada = teclado.next().charAt(0); 
			direccion = interpreteComando.esTeclaValida(entrada);
			System.out.println(direccion);
				if (movimientoValido(perA , perB , direccion , listMapas.get(0))){
					moverPersonajes(perA, perB, direccion);		
				}
			}
			if (perA.getVida() > 0 ) Nivel_1(perA, perB);
		}
		else{
			PerdisteElJuego();			 
		}
	}
	public void Historia_1(PersonajePrincipal perA , PersonajePrincipal perB)	{		
		String linea ; 
		System.out.println("Bienvenido a Historia1 ");
		System.out.println("Cristobal y su hermana eran cuyes pequeños.\nSiempre se preguntaban para qué servían, si su existencia era valiosa.\nPara responder a sus incógnitas, fueron en busca de la llama Sabia.\nUn ser lleno de respuestas.");
		System.out.println("( cualquier numero y enter para continuar )");
		linea = teclado.next();
		Tutorial(perA , perB);			
		
	}
	public void NuevoJuego(PersonajePrincipal perA, PersonajePrincipal perB){
		String linea;
		System.out.println("Escriba su nombre: ");
		linea = teclado.next();	
		System.out.println("Wecome to my world my friend " + linea);
		Historia_1(perA ,perB);
	}
	public void PantallaInicial(){
		
		int opcion;
		int salida = 0;
		
		while(true){
		
			teclado = new Scanner(System.in);
			
			System.out.println("Bienvenidos Todos! amiguitos! a este juego kawai!\n\n");
			System.out.println("1) Nuevo juego");
			System.out.println("2) Salir\n\n");
			System.out.println("Seleccione una de las dos opciones: ");
			
			opcion = teclado.nextInt();
			
			if(opcion == 1){
				NuevoJuego(personajeA , personajeB);	
			}
			else if(opcion == 2){
				System.out.println("Seguro que quiere salir? ");
				System.out.println("1) Sí");
				System.out.println("2) No");
								
				salida = teclado.nextInt();
				if(salida == 1)   // Si lo cambiamos este (una linea mas arriba regresa al menu principal)
					break;
			}			
		}
		System.out.println("Espero que Regrese Pronto mi estimado .");
	}
	
	
	public void iniciarPersonajes(){
		PersonajePrincipal cuy1 = new PersonajePrincipal("Cristobal", 10, 190, 10 , 0, 'A', true, false);
 	    //System.out.print(cuy1.getEstadoActual());
 	    
 	    PersonajePrincipal cuy2 = new PersonajePrincipal("Hermana", 10, 190,5, 0, 'B', true, false);
 	    //System.out.print(cuy2.getEstadoActual());
 	    
		personajeA = cuy1  ; 
		personajeB = cuy2 ; 
		
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
							mapa.establecerCaracter(fil, col+1, '@');
							//Esto hace que el caracter del costado muestre al enemigo en la impresion
							
						}
						//if (mapa.obtenerCaracter(i,j)=='C') flagAccA++;
					}					    
					if(cuy2.getPosX()==fil && cuy2.getPosY()==col) {
						System.out.print('B');
						if (mapa.obtenerCaracter(fil,col)=='D') flagDuo++;	
						if (mapa.obtenerCaracter(fil,col)=='C') flagAccB++;
					}			
				}
				else System.out.print(mapa.obtenerCaracter(fil,col));								
			
			}
			System.out.println();
		}
	}
	
}


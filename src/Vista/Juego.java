package Vista;
import Modelo.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.GestorMapas;
import Controlador.InterpreteComandos;


//public class Juego extends VentanaJuego implements Renderizador {

public class Juego extends JFrame implements Renderizador{

	//Ventanas
	private BufferedImage img2, img = null; //por si acaso Null :v
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel panelTutorial=new JPanel();
	boolean dibujoListo;
	//String mensaje = "Cargando imagen ...";
	private BufferStrategy bufferStrategy;
	
	// cerrar ventanas
	private int nextLevel ;
	private Scanner teclado;	
	private PersonajePrincipal personajeA ; // EL Cuyo  
	private PersonajePrincipal personajeB ;  // La Cuya
	private ArrayList <PersonajeSecundario> listPersonajesSecundarios ; 
	private ArrayList <Objeto> listObjetos ; 
	private ArrayList <Mapa> listMapas ; 
	private GestorMapas gestorMapa ;
	private InterpreteComandos interpreteComando ; 
	private Mapa mapaActual ; 
	
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
		
		//Crear ventana
		setSize(1300,768); //Para dimensionar la imagen(ventana)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("El Pequeño y Valiente Cristobal");                   // colocamos titulo a la ventana
        
		//Deben cargarse las imágenes antes de mostrar la ventana
		setVisible(true);
		//Antes de crear la estrategia se debe hacer visible la ventana
		createBufferStrategy(2);
		//La estrategia se debe obtener una vez creada para poder usarla
		//en el paint. Si se obtiene en el paint se producirá parpadeo
        bufferStrategy = getBufferStrategy();

		// fin crear ventana
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
			 try {
				gestorMapa.crearMapa(miMapa, indice);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	// VENTANAS
	public void configurarVentana(){
		//this.setSize(310, 210);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        
        //se agregan los paneles a la ventana
        add(panel1,BorderLayout.CENTER);
        add(panel2);
        
	}
	
	public void leerImagen(){
		//este metodo carga la imagen de memoria
		//y la pone en uno de los contenedores

        try {
            img = ImageIO.read(new File("cuy_1024x768.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            //canvas.drawImage(img,0,0);
            panel1.add(new JLabel(new ImageIcon(img)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        
    }
	//CERRAR VENTANAS
	
	
	
	
	public void PerdisteElJuego(){
		System.out.println("Game Over");	
	}
		
	public void Nivel_2(PersonajePrincipal perA, PersonajePrincipal perB){
		int entero, direccion;
		char entrada ; 
		System.out.println("Bienvenido al Nivel_2  (escriba un numero para continuar)");
		entero = teclado.nextInt();
		//Posición inicial de los cuyes de nivel 2
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
				if (interpreteComando.movimientoValido(perA , perB , direccion , listMapas.get(2))){
					interpreteComando.moverPersonajes(perA, perB, direccion);		
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
	
	public void Nivel_1(PersonajePrincipal perA , PersonajePrincipal perB){
		int entero, direccion;
		char entrada ; 
		System.out.println("Bienvenido al Nivel_1  (escriba un numero para continuar)");
		entero = teclado.nextInt();
		//POsición inicial en Nivel 1
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
				if (interpreteComando.movimientoValido(perA , perB , direccion , listMapas.get(1))){
					interpreteComando.moverPersonajes(perA, perB, direccion);		
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
				if (interpreteComando.movimientoValido(perA , perB , direccion , listMapas.get(0))){
					interpreteComando.moverPersonajes(perA, perB, direccion);		
				}
			}
			if (perA.getVida() > 0 ) Nivel_1(perA, perB);
		}
		else{
			PerdisteElJuego();			 
		}
	}
	
	public void Historia_1(PersonajePrincipal perA , PersonajePrincipal perB)	{		
		//String linea ; 
		JOptionPane.showMessageDialog(null,"Bienvenido a Historia1\nCristobal y su hermana eran cuyes pequeños.\nSiempre se preguntaban para qué servían, si su existencia era valiosa.\nPara responder a sus incógnitas, fueron en busca de la llama Sabia.\nUn ser lleno de respuestas.");
		//System.out.println("Bienvenido a Historia1 ");
		//System.out.println("Cristobal y su hermana eran cuyes pequeños.\nSiempre se preguntaban para qué servían, si su existencia era valiosa.\nPara responder a sus incógnitas, fueron en busca de la llama Sabia.\nUn ser lleno de respuestas.");
		//System.out.println("( cualquier numero y enter para continuar )");
		//linea = teclado.next();
		//Tutorial(perA , perB);			
		
	}
	public void NuevoJuego(PersonajePrincipal perA, PersonajePrincipal perB){
		String linea;
		System.out.println("Escriba su nombre: ");
		linea = teclado.next();	
		System.out.println("Wecome to my world my friend " + linea);
		Historia_1(perA ,perB);
	}
	
	public void ConfigurarTutorial(){
		
		Historia_1(this.personajeA, this.personajeB);
		panel1.removeAll();
		remove(panel1);
		//aqui se setean las propiedades de los contenedores
		panelTutorial.setSize(1024, 768);
		panel2.setSize(276, 768);
		panelTutorial.setBorder(/*BorderFactory.createLineBorder(Color.black)*/null);
		panel2.setBorder(/*BorderFactory.createLineBorder(Color.black)*/null);
		try {
            img = ImageIO.read(new File("mapa_tutorial.jpg"));
            img2 = ImageIO.read(new File("barra_lateral.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            panelTutorial.add(new JLabel(new ImageIcon(img)));
            panel2.add(new JLabel(new ImageIcon(img2)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
		add(panelTutorial);
		add(panel2,BorderLayout.EAST);
		setVisible(true);
	}
	
	public void PantallaInicial(){
		
		//aqui se setean las propiedades de los contenedores
		panel1.setSize(1300, 768);
		//panel2.setSize(276, 768);
		panel1.setBorder(/*BorderFactory.createLineBorder(Color.black)*/null);
		//panel2.setBorder(/*BorderFactory.createLineBorder(Color.black)*/null);
		//configurarVentana();
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(true);                               // hacemos que la ventana no sea redimiensionable
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        
        //se agregan los paneles a la ventana
        add(panel1);
        //add(panel2);
		
		//este metodo carga la imagen de memoria
		//y la pone en uno de los contenedores

        try {
            img = ImageIO.read(new File("pantalla_inicio.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            panel1.add(new JLabel(new ImageIcon(img)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
		
        //leerImagen();
		this.setVisible(true);
		
		panel1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getX() >= 80 && e.getX() <= 248){
					if (e.getY() >= 300 && e.getY() <= 360 ){
						//Configurar para tutorial 1 e iniciar juego
						
						ConfigurarTutorial();
						
					}
					if (e.getY() >= 400 && e.getY() <= 460 ){
						//Configurar para cargar partida
					}
					if (e.getY() >= 500 && e.getY() <= 560 ){
						//Configurar para Salir
						String[] opciones = {"Si", "No"};
						 
				        int opcion = JOptionPane.showOptionDialog(
				                               null                             //componente
				                             , "¿Desea salir del juego?"            // Mensaje
				                             , "Salida del juego"         // Titulo en la barra del cuadro
				                             , JOptionPane.DEFAULT_OPTION       // Tipo de opciones
				                             , JOptionPane.INFORMATION_MESSAGE  // Tipo de mensaje (icono)
				                             , null                             // Icono (ninguno)
				                             , opciones                         // Opciones personalizadas
				                             , null                             // Opcion por defecto
				                           );
				        if(opcion == 0){ //salir
				        	System.exit(0);
				        }
				        else
				        	JOptionPane.getRootFrame().dispose();   
				        	//JOptionPane.dispose();
					}					
				}
			}
		});
		
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
 	    
		personajeA = cuy1  ; //Xq igualamos aquí? si igual nunca usamos personajeA ni personajeB
		personajeB = cuy2 ; 
		//Imagen img=new Imagen();
		
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
		
		//la verificacion del duo debe darse en el juego, ya que si la cadena es correcta debera
				//mandar a otro método de impresión
				if(flagDuo==2){
					System.out.println("AMBOS HERMANOS PUEDEN HACER UN DUO");
					if(mapa.getEstadoDuo() == 0){
						ImprimirDuo(mapa, cuy1, cuy2);
						if (cuy1.getVida() <= 0 ) return ;
						
					}else if (mapa.getEstadoDuo() == 1){
						
						if (mapa.getContador() == 0){
							ImprimirDuo2(mapa, cuy1, cuy2);
							mapa.setContador( mapa.getContador() + 1 );
							}
						else{ 
							ImprimirDuo3(mapa, cuy1, cuy2);
							}
						if (cuy1.getVida() <= 0 ) return ;
						
					}else if (mapa.getEstadoDuo() == 2){
						ImprimirDuo4(mapa, cuy1, cuy2);
						if (cuy1.getVida() <= 0 ) return ;
					}	
				}
				if(flagAccA>0){
					System.out.println("CRISTOBAL PUEDE HACER UNA ACCION");
					if(cuy1.getPosX()==9 && cuy1.getPosY()==11) AccionNivel2A(mapa, cuy1, cuy2);
					else AccionTutorial(mapa, cuy1, cuy2);
				}
				if(flagAccB>0){
					System.out.println("LA HERMANA PUEDE HACER UNA ACCION");
					AccionNivel2B(mapa, cuy1, cuy2);
				}
				if(flagNuevoEnemigo>0 && esp> 50){
					//ACA HAY UN NUEVO ENEMIGO ESO VALIDA QUE HAYA PISADO EL TRIGGER
					System.out.println("UN NUEVO ENEMIGO HA APARECIDO");
					cuy1.setPosY(3);
					ImprimirAccionNUEVA(mapa, cuy1, cuy2);
				}
	}
	
	public void AccionTutorial(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR WDEWW");
		String duo1 = "WDEWW" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR WDEWW");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//ACCION - POSICION 1
		cuy1.setPosY(11); ///
		cuy1.setPosX(7);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//ACCION - POSICION 2
		cuy1.setPosY(13);
		cuy1.setPosX(5);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//ACCION - POSICION 3
		cuy1.setPosY(13);
		cuy1.setPosX(8);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		System.out.println("PUEDES MOVERTE Y CONTINUAR");

	}
	
	public void AccionNivel2A(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR WQED");
		String duo1 = "WQED" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR WQED");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//ACCION - POSICION 1
		cuy1.setPosY(4); ///
		cuy1.setPosX(9);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//ACCION - POSICION 2
		cuy1.setPosY(5);
		cuy1.setPosX(9);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		System.out.println("PUEDES MOVERTE Y CONTINUAR");

	}
	
	public void AccionNivel2B(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR IUOL");
		String duo1 = "IUOL" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR IUOL");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//ACCION - POSICION 1
		cuy2.setPosY(4); ///
		cuy2.setPosX(3);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//ACCION - POSICION 2
		cuy2.setPosY(5);
		cuy2.setPosX(3);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine();
		System.out.println("PUEDES MOVERTE Y CONTINUAR");

	}
	
	public void ImprimirAccionNUEVA(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		int flag = validar(cuy1);
		String entrada;
		if(flag==1){
			//ACCION - POSICION 1
			cuy2.setPosY(4); ///
			cuy2.setPosX(8);		
			ImprimirMapa(mapa,cuy1,cuy2);
			entrada = teclado.nextLine() ;
			//ACCION - POSICION 2
			cuy2.setPosY(3);
			cuy2.setPosX(10);
			ImprimirMapa(mapa,cuy1,cuy2);
			entrada = teclado.nextLine() ;
			//ACCION - POSICION 3
			cuy2.setPosY(3);
			cuy2.setPosX(8);
			ImprimirMapa(mapa,cuy1,cuy2);
			System.out.println("HAZ SALVADO A TU HERMANO! :D");
			System.out.println("PUEDES MOVERTE Y CONTINUAR");
			entrada = teclado.nextLine() ;	
		}
	}
	
	public int validar( PersonajePrincipal cuy1){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR WWKSLS");
		String duo1 = "WWKSLS" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR WWKSLS");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) {
				break ;
			}
			entrada = teclado.nextLine() ; 
		}
		if(duo1.equals(entrada)) return 1;
		else return 0;
	}
	
	public void ImprimirDuo4(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR LDOEQUOE");
		String duo1 = "LDOEQUOE" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR LDOEQUOE");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//DUO - POSICION 1
		cuy1.setPosX(6);
		cuy1.setPosY(10);
		cuy2.setPosX(6);
		cuy2.setPosY(9);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 2
		cuy1.setPosX(6);
		cuy1.setPosY(13);
		cuy2.setPosX(5);
		cuy2.setPosY(13);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		System.out.println("PUEDES MOVERTE Y CONTINUAR");
		
	}
	public void ImprimirDuo3(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		///// FAlta 
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR WUOQEI");
		String duo1 = "WUOQEI" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR WUOQEI");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//DUO - POSICION 1
		cuy1.setPosX(9);
		cuy1.setPosY(11);
		cuy2.setPosX(9);
		cuy2.setPosY(10);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 2
		cuy1.setPosX(7);
		cuy1.setPosY(11);
		cuy2.setPosX(7);
		cuy2.setPosY(10);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 3
		cuy1.setPosX(5);
		cuy1.setPosY(11);		
		cuy2.setPosX(6);
		cuy2.setPosY(11);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 4
		cuy1.setPosX(2);
		cuy1.setPosY(12);		
		cuy2.setPosX(2);
		cuy2.setPosY(13);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 5
		cuy1.setPosX(0);
		cuy1.setPosY(12);		
		cuy2.setPosX(4);
		cuy2.setPosY(12);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;

		System.out.println("PUEDES MOVERTE Y CONTINUAR");
	}
	//La impresion del duo
	public void ImprimirDuo2(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR WDEWW");
		String duo1 = "WDEWW" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR WDEWW");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//DUO - POSICION 1
		cuy1.setPosX(9);
		cuy1.setPosY(4);
		cuy2.setPosX(9);
		cuy2.setPosY(5);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 2
		cuy1.setPosX(9);
		cuy1.setPosY(7);
		cuy2.setPosX(9);
		cuy2.setPosY(8);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 3
		cuy1.setPosX(11);
		cuy1.setPosY(7);		
		cuy2.setPosX(7);
		cuy2.setPosY(7);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		
		//DUO - POSICION 3
		//cuy1.setPosX(9);
		//cuy1.setPosY(8);		
		//cuy2.setPosX(5);
		//cuy2.setPosY(8);
		//ImprimirMapa(mapa,cuy1,cuy2);
		//entrada = teclado.nextLine() ;

		System.out.println("PUEDES MOVERTE Y CONTINUAR");
	}
	public void ImprimirDuo(Mapa mapa, PersonajePrincipal cuy1, PersonajePrincipal  cuy2){
		Scanner teclado = new Scanner(System.in);
		System.out.println("DEBE PRESIONAR WSIKDDLL");
		String duo1 = "WSIKDDLL" ;
		String entrada = teclado.nextLine() ;
		while ( !duo1.equals(entrada))  {
			System.out.println("DEBE PRESIONAR WSIKDDLL");
			cuy1.setVida(cuy1.getVida() -1) ;
			if (cuy1.getVida() <= 0 ) return ; 
			entrada = teclado.nextLine() ; 
		}
		//DUO - POSICION 1
		cuy2.setPosX(6);
		cuy2.setPosY(4);
		cuy1.setPosX(8);
		cuy1.setPosY(4);		
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 2
		cuy2.setPosX(7);
		cuy2.setPosY(4);
		cuy1.setPosX(7);
		cuy1.setPosY(5);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		//DUO - POSICION 3
		cuy2.setPosX(8);
		cuy2.setPosY(7);		
		cuy1.setPosX(8);
		cuy1.setPosY(8);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		
		//DUO - POSICION 4
		cuy1.setPosX(9);
		cuy1.setPosY(8);		
		cuy2.setPosX(5);
		cuy2.setPosY(8);
		ImprimirMapa(mapa,cuy1,cuy2);
		entrada = teclado.nextLine() ;
		System.out.println("PUEDES MOVERTE Y CONTINUAR");
	}
	
}


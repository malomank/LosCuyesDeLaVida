package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {
	//se define imagen para cargar lo que se va a mostrar y se crean 2 paneles
	//que serviran de contenedor para las dos partes de la pantalla(mapa y
	//barra de informacion)
	private BufferedImage img = null; //por si acaso Null :v
	private JPanel panel=new JPanel(); //panel para la primera ventana de bienvenida
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	public Ventana(){
		//imprime la ventana de bienvenida del juego
		this.setTitle("Pequeño y valiente Cristobal");
		this.setSize(1300, 768);
		leerImagen();
		this.add(panel,BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getX() >= 80 && e.getX() <= 248){
					if (e.getY() >= 300 && e.getY() <= 360 ){
						//ingresa al juego
						//NuevoJuego(personajeA , personajeB);
						ventanaNivel();
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
	}
	public void ventanaNivel() {
		//aqui se setean las propiedades de los contenedores
		panel.removeAll();
		panel1.setSize(1024, 768);
		panel2.setSize(276, 768);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue));
        leerImagen2();
        leerImagen3();
        configurarVentana();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createBufferStrategy(2);
   }
		
	
	public void configurarVentana(){
		this.setTitle("Tutorial");     
		this.setSize(1300,768);                                 
        this.setLocationRelativeTo(null);                      
        this.setResizable(false);                               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.remove(panel);
        add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.EAST);
        
	}
	
	public void leerImagen(){
		//este metodo carga la imagen de memoria
		//y la pone en uno de los contenedores
        try {
            img = ImageIO.read(new File("Pantalla_Inicio.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            panel.add(new JLabel(new ImageIcon(img)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        
    }
	public void leerImagen2(){
		//este metodo carga la imagen de memoria
		//y la pone en uno de los contenedores
        try {
            img = ImageIO.read(new File("mapa_tutorial.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            panel1.add(new JLabel(new ImageIcon(img)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        
    }
	public void leerImagen3(){
		//este metodo carga la imagen de memoria
		//y la pone en uno de los contenedores
        try {
            img = ImageIO.read(new File("barra_lateral.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            panel2.add(new JLabel(new ImageIcon(img)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        
    }
}

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
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				ventanaNivel();
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
            img = ImageIO.read(new File("cuy_1024x768.jpg"));
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
            img = ImageIO.read(new File("Pantalla_inicio_cuy.jpg"));
            // ImageIO permite leer desde file, url entre otros :)
            panel2.add(new JLabel(new ImageIcon(img)));
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        
    }
}

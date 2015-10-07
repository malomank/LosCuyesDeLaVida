package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

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
		//this.addMouseListener(new mouseClicked);
	}
	public void VentanaNivel() {
		//aqui se setean las propiedades de los contenedores
		panel1.setSize(1024, 768);
		panel2.setSize(276, 768);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue));
		configurarVentana();
        leerImagen2();
        setSize(1300,768); //Para dimensionar la imagen(ventana)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createBufferStrategy(2);
   }
		
	
	public void configurarVentana(){
		this.setTitle("Tutorial");                   // colocamos titulo a la ventana                                 
        this.setLocationRelativeTo(null);                      
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.CENTER);
        
	}
	
	public void leerImagen(){
		//este metodo carga la imagen de memoria
		//y la pone en uno de los contenedores
        try {
            img = ImageIO.read(new File("cuy_1024x768.jpg"));
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
	    
}

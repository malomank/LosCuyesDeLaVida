package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Imagen extends JFrame {
	//se define imagen para cargar lo que se va a mostrar y se crean 2 paneles
	//que serviran de contenedor para las dos partes de la pantalla(mapa y
	//barra de informacion)
	private BufferedImage img = null; //por si acaso Null :v
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	
	public Imagen() {
		super();
		//aqui se setean las propiedades de los contenedores
		panel1.setSize(1024, 768);
		panel2.setSize(276, 768);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setBorder(BorderFactory.createLineBorder(Color.blue));
		configurarVentana();
        leerImagen();
        setSize(1300,768); //Para dimensionar la imagen(ventana)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createBufferStrategy(2);
   }
	
	public void configurarVentana(){
		this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
        this.setSize(310, 210);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp=this.getContentPane();
        //cp.setLayout(new BorderLayout());
        //se agregan los paneles a la ventana
        add(panel1);
        add(panel2);
        
	}
	
	public void leerImagen(){
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

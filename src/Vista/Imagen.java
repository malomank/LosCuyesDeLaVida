package Vista;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;

public class Imagen extends JFrame {
	
	private BufferedImage img=null; //por si acaso Null :v
	private JFrame pantalla;
	private JPanel panel;
	
	public Imagen() {

		pantalla = new JFrame("Los Cuyes de la vida");
		pantalla.setLayout(null);
		pantalla.setBounds(110, 430, 110,120);
		
		 try {
	            img = ImageIO.read(new File("Pantalla_inicio_cuy.jpg"));  // ImageIO permite leer desde file, url entre otros :)
	            
		 } catch (IOException ex) {
	            System.out.println("No se pudo leer la imagen");
	     }
		Container pane = pantalla.getContentPane();
		ColorPanel panel = new ColorPanel(img);
		pantalla.setVisible(true);
		 
		 
	//	configurarVentana();
		pantalla.setSize(1020,890);
		
		
		
		
		pantalla.add(panel);
	
		panel.setBounds(10,10, 600,250);
		panel.setVisible(true);
		
		pantalla.setSize(800, 600);                                 // colocamos tamanio a la ventana (ancho, alto)
		pantalla.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
		pantalla.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
		pantalla.setResizable(false);    
		pantalla.setVisible(true);		
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        //leerImagen();
       // setSize(1820,980); //Para dimensionar la imagen
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
        //createBufferStrategy(2);
   }
	
/*	public void configurarVentana(){
		this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
        this.setSize(310, 210);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/

	public void leerImagen(){

        try {
            img = ImageIO.read(new File("Pantalla_inicio_cuy.jpg"));  // ImageIO permite leer desde file, url entre otros :)
        } catch (IOException ex) {
            System.out.println("No se pudo leer la imagen");
        }
        
    }

	public void paint(){
		
	}
	
	class ColorPanel extends JPanel{
		BufferedImage theCat;
		public ColorPanel(BufferedImage image){
		theCat = image;
		}
	 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(theCat, null, 50,50);
		}
	}
	    
}

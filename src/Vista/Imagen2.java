package Vista;

import java.awt.*;
import java.awt.image.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;

public class Imagen2 extends JFrame {


	public static BufferedImage image; 
	  
	  public Imagen2 () 
	  { 
	    super(); 
	    try 
	    {                
	      image = ImageIO.read(new File("Pantalla_inicio_cuy.jpg")); 
	    } 
	    catch (IOException e) 
	    { 
	      //Not handled. 
	    } 
	    
	    JFrame f = new JFrame("Window"); 
		f.add(new Imagen2());
		f.setSize(image.getWidth(), image.getHeight() + 30); 
	    f.setVisible(true); 
	  } 

	  public void paintComponent(Graphics g) 
	  { 
	    g.drawImage(image, 0, 0, null); 
	    repaint(); 
	  } 
}
